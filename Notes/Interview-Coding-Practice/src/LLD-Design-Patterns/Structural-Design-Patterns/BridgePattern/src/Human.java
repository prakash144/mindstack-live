// RefinedAbstraction (Human)
public class Human extends Species {
    public Human(BreathingMethod breathingMethod) {
        super(breathingMethod);
    }

    @Override
    void breathe() {
        System.out.println("Human is " + breathingMethod.breathe());
    }
}