import java.util.Stack;

public class MyRemoteControl {

    Stack<ICommand> acCommandHistory = new Stack<>();
    ICommand command;

    public MyRemoteControl() {}
    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        acCommandHistory.add(command); // Stores the command for undo functionality
    }

    public void undoButton() {
        if(!acCommandHistory.isEmpty()) {
            ICommand lastCommand = acCommandHistory.pop(); // Retrieves last command
            lastCommand.undo(); // Undo the last command
        }
    }
}
