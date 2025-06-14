public class AirConditioner {
    boolean isOn;
    int temperature;

    public void turnOnAC() {
        this.isOn = true;
        System.out.println("Turning on air conditioner");
    }

    public void turnOffAC() {
        this.isOn = false;
        System.out.println("Turning off air conditioner");
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Setting temperature to " + temperature);
    }
}
