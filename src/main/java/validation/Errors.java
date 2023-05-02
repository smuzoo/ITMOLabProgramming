package validation;

import collection.Fields;
import collection.FuelType;
import collection.VehicleType;

public enum Errors {
    NOTEXISTFILE("Данный файл не существует, передайте в аргумент строки существующий файл"),
    CANNOTREADFILE("Данный файл не имеет права доступа на чтение файла, разрешите доступ для чтения файла"),
    CANNOTWRITEFILE("Данный файл не имеет права доступа на запись данных в файл, разрешите доступ для записи в файл"),
    NOTHAVEENVIRONMENT("При запуске программы аргумент коммандной строки не был передан\n"+"Запустите программу заново, передав аргумент коммандной строки"),

    NOTHAVEERRORS("Ошибок нет"),
    IMPOSSIBLEREADFILE("Невозможно прочитать файл, попробуйте другой"),
    IMPOSSIBLEXMLFILESTRUCTURE("Неверная структура файла, исправте файл"),
    IMPOSSIBLEPARSERCONFIGURATIONFROMFILE("Парсер не может быть создан или настроен из-за неправильной конфигурации или недостатка ресурсов"),
    INCORRECTNUMBERFORMATFROMFILE("Неверный формат, coordinates и/или Fuel Power не являются целым числом"),
    INCORRECTENUMFORMATFROMFILE("Неверный формат, Vehicle Type и/или Fuel Type не являются значениями списка \n" +
            " Vehicle Type может быть " + VehicleType.getStringValues ()  + "\n"
            + " Fuel Type может быть " + FuelType.getStringValues()),
    NOTHASTWOCOORDINATES("Не было введено 2 координаты x и y "),
    LOWERX("Значение поля coordinate.x не может превышать " + Fields.MAXIMUM_X),
    NOTCANTRANSFORMTOINT("Данный аргумент не является целым числом"),
    NOTCANTRANSFORMTODOUBLE("Данный аргумент не является числом двойной точности"),
    EMPTYFIELD("Данное поле не может быть пустым "),
    NOTCANTRANSFORMTOLONG("Данный аргумент не является long числом "),
    ENGINEPOWERLOWERZERO("Неверная сила двигателя " + Fields.ENGINEPOWER),
    NOTHASFIELD("Номера с таким полем не существует");


    private String error;
     Errors(String error){
        this.error = error;
    }


    @Override
    public String toString() {
        return error;
    }
}
