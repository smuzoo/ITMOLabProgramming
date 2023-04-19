package validation;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class Validator {
    private final Map<Validating, Errors> validatesMethods = new LinkedHashMap<>();

    abstract protected void addAllErrors();

    protected void addError(Validating method, Errors error){
        validatesMethods.put(method, error);
    }

    protected Errors validateAll(){
        addAllErrors();
        for(Validating method : validatesMethods.keySet()){
            if(method.notValidate()){
                return validatesMethods.get(method);
            }
        }
        return Errors.NOTHAVEERRORS;
    }



    public boolean isValid(){
        Errors error = validateAll();
        if(error != Errors.NOTHAVEERRORS){
            System.out.println(error);
            return false;
        }
        return true;
    }

    public void validateWithExit(){
        boolean validation = isValid();
        if(!validation)System.exit(130);
    }


}
