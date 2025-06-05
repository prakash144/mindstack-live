class ParkingSpot {
    private String number;
    private ParkingSpotType type;
    private boolean free;

    public ParkingSpot(String number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }

    public void occupySpot() {
        this.free = false;
        System.out.println("Spot " + number + " is now occupied.");
    }

    public void freeSpot() {
        this.free = true;
        System.out.println("Spot " + number + " is now free.");
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}