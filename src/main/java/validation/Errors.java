package validation;

public enum Errors {
    NOTEXISTFILE("Данный файл не существует, передайте в аргумент строки существующий файл"),
    CANNOTREADFILE("Данный файл не имеет права доступа на чтение файла, разрешите доступ для чтения файла"),
    CANNOTWRITEFILE("Данный файл не имеет права доступа на запись данных в файл, разрешите доступ для записи в файл"),
    NOTHAVEENVIRONMENT("При запуске программы аргумент коммандной строки не был передан\n"+"Запустите программу заново, передав аргумент коммандной строки"),
    EMPTYENVIRONMENT(""),
    WRONGENVIRONMENT(""),

    NOTHAVEERRORS("Ошибок нет"),
    IMPOSSIBLEREADFILE("Невозможно прочитать файл, попробуйте другой"),
    IMPOSSIBLEXMLFILESTRUCTURE("Неверная структура файла, исправте файл"),
    IMPOSSIBLEPARSERCONFIGURATION("Парсер не может быть создан или настроен из-за неправильной конфигурации или недостатка ресурсов");

    private String error;
     Errors(String error){
        this.error = error;
    }


    @Override
    public String toString() {
        return error;
    }
}
