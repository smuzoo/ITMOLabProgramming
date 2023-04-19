package validation;
import collection.Fields;

public enum Errors {
    NOTEXISTFILE("Данный файл не существует, передайте в аргумент строки существующий файл"),
    NOTCANREADFILE("Данный файл не имеет права доступа на чтение файла, разрешите доступ для чтения файла"),
    NOTCANWRITEFILE("Данный файл не имеет права доступа на запись данных в файл, разрешите доступ для записи в файл"),
    NOTHAVEENVIRONMENT("При запуске программы аргумент коммандной строки не был передан\n"+"Запустите программу заново, передав аргумент коммандной строки"),
    EMPTYENVIRONMENT(""),
    WRONGENVIRONMENT(""),

    NOTHAVEERRORS("Ошибок нет");

    private String error;
     Errors(String error){
        this.error = error;
    }


    @Override
    public String toString() {
        return error;
    }
}
