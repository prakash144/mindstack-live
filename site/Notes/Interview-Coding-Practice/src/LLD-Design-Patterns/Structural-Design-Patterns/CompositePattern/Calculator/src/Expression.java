public class Expression implements ArithmeticExpression{

    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operation operation){
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        int value = switch (operation) {
            case ADD -> leftExpression.evaluate() + rightExpression.evaluate();
            case SUBTRACT -> leftExpression.evaluate() - rightExpression.evaluate();
            case MULTIPLY -> leftExpression.evaluate() * rightExpression.evaluate();
            case DIVIDE -> leftExpression.evaluate() / rightExpression.evaluate();
        };

        System.out.println("Expression value is : " + value);
        return value;
    }
}
