import java.util.ArrayList;
import java.util.List;

// Caretaker
public class ConfigurationCareTaker {
    List<ConfigurationMemento> history = new ArrayList<>();

    public void addMemento(ConfigurationMemento memento) {
        history.add(memento);
    }

    public ConfigurationMemento undo() {
        if(!history.isEmpty()) {
            int lastMementoIndex = history.size() - 1;
            // get the last memento from list
            ConfigurationMemento lastMemento = history.get(lastMementoIndex);
            // remove the last memento from history
            history.remove(lastMementoIndex);
            return lastMemento;
        }
        return null;
    }
}

