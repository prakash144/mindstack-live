// RefinedAbstraction (Fish)
public class Fish extends Species {
    public Fish(BreathingMethod breathingMethod) {
        super(breathingMethod);
    }

    @Override
    void breathe() {
        System.out.println("Fish is " + breathingMethod.breathe());
    }
}