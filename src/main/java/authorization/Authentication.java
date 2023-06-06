package authorization;


import dataBase.Database;
import parsers.ConsoleParser;
import validation.values.NameValidator;
import validation.values.NotEqualsValidator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class Authentication {
    private static ConsoleParser parser;

    final private static String name_table = "name_table";

    public static void auth() {
        String action;
        do{
            System.out.println("Введите 1 если хотите зарегистрироваться" + "\n"+
                    "2, если войти " +"\n"+
                    "3, если войти гостем " +"\n"+
                    "4, если выйти");
            action = parser.getNewLine();
        }while (!(new NotEqualsValidator(action, "1", "2", "3", "4").isValid()));
        if(action.equals("4")){
            System.exit(0);
        } else if (!action.equals("3")) {
            String login = get("имя пользователя");
            String password = get("пароль");
            switch (action){
                case "1" -> register(login, password);
                case "2" -> login(login, password);
            }
        }


    }
    private static String get(String field){
        String answer;
        do {
            System.out.println("Введите " + field);
            answer = parser.getNewLine();
        } while (!(new NameValidator(answer).isValid()));
        return answer;
    }

    private static String getRandomString(){
        String characters = "fkgbdfkgjdhfsgdlfgKFJLDFHBGSDKLFGDK23094713985idjk";
        int length = 10;
        Random rand = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(characters.length());
            char c = characters.charAt(index);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static void login(String login, String password) {
        Database database = Database.getInstance();
        if (!database.isExistInDB(name_table, "login", login)) {
            System.err.println("Данного пользователя не существует");
            auth();
        } else {
            String pepper = "HHGHJ12-231dd";
            String salt = database.getFieldByField(name_table, "login", login, "salt");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(
                        (pepper + password + salt).getBytes(StandardCharsets.UTF_8));
                String hashUser = bytesToHexString(hash);
                String hashDB = database.getFieldByField(name_table, "login", login, "hash");
                if (hashUser.equals(hashDB)) {
                    User.setLogin(login);
                    User.setPassword(password);
                    System.out.println("Вы успешно вошли в систему");
                } else {
                    System.err.println("Вы ввели неправильный пароль для пользователя " + login);
                    auth();
                }
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    private static void register(String login, String password) {
        Database database = Database.getInstance();
        if(database.isExistInDB(name_table, "login", login)){
            System.err.println("Такое имя пользователя уже существует");
            auth();
        }else{
            String pepper = "HHGHJ12-231dd";
            String salt = getRandomString();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(
                        (pepper + password + salt).getBytes(StandardCharsets.UTF_8));
                String hashString = bytesToHexString(hash);
                database.addUserToDB(name_table, login, salt, hashString);
                User.setLogin(login);
                User.setPassword(password);
                System.out.println("Вы были успешно зарегистрированы");
            }catch (NoSuchAlgorithmException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void setReader(ConsoleParser parser) {
        Authentication.parser = parser;
    }
}
