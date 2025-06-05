import java.util.List;

public class VehicleRentalSystem {

    List<Store> storeList;
    List<User> usersList;

    VehicleRentalSystem(List<Store> storeList, List<User> usersList) {
        this.storeList = storeList;
        this.usersList = usersList;
    }

    public Store getStore(Location location) {
        //based on location, we will filter out the Store from storeList.
        return storeList.get(0);
    }

    //addUsers

    //remove users


    //add stores

    //remove stores

}
