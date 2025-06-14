// Concrete Factory for Ordinary Cars
public class OrdinaryCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new OrdinaryCar();
    }
}