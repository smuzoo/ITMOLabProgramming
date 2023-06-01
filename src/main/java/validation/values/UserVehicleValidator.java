package validation.values;

import authorization.User;
import collection.Vehicle;
import validation.Errors;
import validation.Validator;

public class UserVehicleValidator extends Validator {
    private final Vehicle vehicle;
    public UserVehicleValidator(Vehicle vehicle){this.vehicle = vehicle;}
    private boolean NotCreateThisUser() {
        String userLogin = User.getLogin();
        String vehicleUserLogin = vehicle.getUserLogin();
        return userLogin != null && vehicleUserLogin != null && !vehicleUserLogin.equals(userLogin);
    }

    @Override
    protected void addAllErrors() {addError(this::NotCreateThisUser, Errors.NOTCREATETHISUSER);

    }
}
