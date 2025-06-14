public class NumberTerminalExpression implements AbstractExpression {

    String stringValue;

    NumberTerminalExpression(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public int interpret(Context context) {
        return context.get(stringValue);
    }
}
