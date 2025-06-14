// Abstraction (Species) - Base class that holds a reference to BreathingMethod
public abstract class Species {
    protected BreathingMethod breathingMethod;  // has-a BreathingMethod

    public Species(BreathingMethod breathingMethod) {
        this.breathingMethod = breathingMethod;
    }

    abstract void breathe();
}