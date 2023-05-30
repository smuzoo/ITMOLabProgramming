package validation.values;

import authorization.User;
import collection.Vehicle;
import validation.Validator;
import validation.Errors;

public class UserVehicleValidator extends Validator {
    private Vehicle vehicle;
    public UserVehicleValidator(Vehicle vehicle){this.vehicle = vehicle;}
    private boolean NotCreateThisUser(){
        return !vehicle.getUserLogin().equals(User.getLogin());}

    @Override
    protected void addAllErrors() {addError(this::NotCreateThisUser, Errors.NOTCREATETHISUSER);

    }
}
