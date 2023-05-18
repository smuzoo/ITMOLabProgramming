package authorization;


import dataBase.Database;
import parsers.ConsoleParser;
import validation.values.NameValidator;
import validation.values.NotEqualsValidator;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import java.util.Base64;
import java.nio.charset.StandardCharsets;


public class Authentication {
    private static ConsoleParser parser;

    final private static String NAME_TABLE = "users";

    public static void auth() {
        String action;
        do{
            System.out.println("Введите 1 если хотите зарегистрироваться, 2 если войти, 3, если войти гостем, 4 если выйти");
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
        if (!database.isExistInDB(NAME_TABLE, "login", login)) {
            System.err.println("Данного имя пользователя не существует");
            auth();
        } else {
            String pepper = "hAV~2zRmv#";
            String salt = database.getFieldByField(NAME_TABLE, "login", login, "salt");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD2");
                byte[] hash = messageDigest.digest(
                        (pepper + password + salt).getBytes(StandardCharsets.UTF_8));
                String hashUser = Arrays.toString(hash);
                String hashDB = database.getFieldByField(NAME_TABLE, "login", login, "hash");
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
            } finally {
                database.closeConnection();
            }
        }
        database.closeConnection();
    }

    private static void register(String login, String password) {
        Database database = Database.getInstance();
        if(database.isExistInDB(NAME_TABLE, "login", login)){
            System.err.println("Такое имя пользователя уже существует");
            auth();
        }else{
            String pepper = "hAV~2z)(()fdgfg";
            String salt = getRandomString();
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(
                        (pepper + password + salt).getBytes(StandardCharsets.UTF_8));
                String hashString = Base64.getEncoder().encodeToString(hash);
                database.addUserToDB(NAME_TABLE, login, salt, hashString);

                User.setLogin(login);
                User.setPassword(password);
                System.out.println("Вы были успешно зарегистрированы");
            }catch (NoSuchAlgorithmException ex){
                ex.printStackTrace();
            }finally {
                database.closeConnection();
            }

        }
        database.closeConnection();

    }

    public static void setReader(ConsoleParser parser) {
        Authentication.parser = parser;
    }
}
