package validation;

import collection.Fields;
import collection.FuelType;
import collection.VehicleType;

/**
 * The enum Errors.
 */
public enum Errors {
    /**
     * Notexistfile errors.
     */
    NOTEXISTFILE("Данный файл не существует, передайте в аргумент строки существующий файл"),
    /**
     * Cannotreadfile errors.
     */
    CANNOTREADFILE("Данный файл не имеет права доступа на чтение файла, разрешите доступ для чтения файла"),
    /**
     * Cannotwritefile errors.
     */
    CANNOTWRITEFILE("Данный файл не имеет права доступа на запись данных в файл, разрешите доступ для записи в файл"),
    /**
     * Nothaveenvironment errors.
     */
    NOTHAVEENVIRONMENT("При запуске программы аргумент коммандной строки не был передан\n" + "Запустите программу заново, передав аргумент коммандной строки"),

    /**
     * Nothaveerrors errors.
     */
    NOTHAVEERRORS("Ошибок нет"),
    /**
     * Impossiblereadfile errors.
     */
    IMPOSSIBLEREADFILE("Невозможно прочитать файл, попробуйте другой"),
    /**
     * Impossiblexmlfilestructure errors.
     */
    IMPOSSIBLEXMLFILESTRUCTURE("Неверная структура файла, исправте файл"),
    /**
     * Impossibleparserconfigurationfromfile errors.
     */
    IMPOSSIBLEPARSERCONFIGURATIONFROMFILE("Парсер не может быть создан или настроен из-за неправильной конфигурации или недостатка ресурсов"),
    /**
     * The Incorrectnumberformatfromfile.
     */
    INCORRECTNUMBERFORMATFROMFILE("Неверный формат, coordinates и/или Fuel Power не являются целым числом"),
    /**
     * The Incorrectenumformatfromfile.
     */
    INCORRECTENUMFORMATFROMFILE("Неверный формат, Vehicle Type и/или Fuel Type не являются значениями списка \n" +
            "Vehicle Type может быть " + VehicleType.getStringValues() + "\n"
            + "Fuel Type может быть " + FuelType.getStringValues()),
    /**
     * Nothastwocoordinates errors.
     */
    NOTHASTWOCOORDINATES("Не было введено 2 координаты x и y "),
    /**
     * Lowerx errors.
     */
    LOWERX("Значение поля coordinate.x не может быть меньше " + Fields.MIM_X),
    /**
     * Notcantransformtoint errors.
     */
    NOTCANTRANSFORMTOINT("Данный аргумент не является целым числом"),
    /**
     * Notcantransformtodouble errors.
     */
    NOTCANTRANSFORMTODOUBLE("Данный аргумент не является числом двойной точности"),
    /**
     * Emptyfield errors.
     */
    EMPTYFIELD("Данное поле не может быть пустым "),
    /**
     * Notcantransformtolong errors.
     */
    NOTCANTRANSFORMTOLONG("Данный аргумент не является long числом "),
    /**
     * Enginepowerlowerzero errors.
     */
    ENGINEPOWERLOWERZERO("Неверная сила двигателя " + Fields.ENGINEPOWER),
    /**
     * Nothasfield errors.
     */
    NOTHASFIELD("Номера с таким полем не существует"),
    /**
     * Notcantrasformtouuid errors.
     */
    NOTCANTRASFORMTOUUID("Данное значение не корректно для UUID"),
    /**
     * Uuidusused errors.
     */
    UUIDUSUSED("Данное значение UUID уже использовано"),
    /**
     * Impossiblewritetofile errors.
     */
    IMPOSSIBLEWRITETOFILE("Невозможно записать данные в файл"),
    /**
     * Nothasarg errors.
     */
    NOTHASARG("Эта команда принимает на вход 1 аргумент"),
    /**
     * Recursion errors.
     */
    RECURSION("В скрипте присутствует рекурсия"),
    /**
     * Notenoughparametrs errors.
     */
    NOTENOUGHPARAMETRS("Неверная структура файла, нехватает какого-то необходимого параметра или параметров");


    private final String error;

    Errors(String error) {
        this.error = error;
    }


    @Override
    public String toString() {
        return error;
    }
}
