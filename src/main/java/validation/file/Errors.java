package validation.file;
import collection.Fields;

public enum Errors {
    NOTEXISTFILE("Данный файл не существует, передайте в переменную окружения существующий файл"),
    NOTCANREADFILE("Данный файл не имеет права доступа на чтение файла, разрешите доступ для чтения файла"),
    NOTCANWRITEFILE("Данный файл не имеет права доступа на запись данных в файл, разрешите доступ для записи в файл"),

    private String error;
     Errors(String error){
        this.error = error;
    }


    @Override
    public String toString() {
        return error;
    }
}
