public class Location {
    String address;
    int pinCode;
    String city;
    String state;
    String country;

    public Location(String address, int pinCode, String city, String state, String country) {
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
