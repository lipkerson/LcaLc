package pl.ll.lcalcmath;

import pl.ll.datacontainers.Values;

/**
 *
 * @author lucjan
 */
public class ExprOperator implements ExprAble {

    @Override
    public Values add(Values a, Values b) throws ArithmeticException {
        return new Values(a.asDouble() + b.asDouble());
    }

    @Override
    public Values div(Values a, Values b) throws ArithmeticException {
        return new Values(a.asDouble() / b.asDouble());
    }

    @Override
    public Values minus(Values a, Values b) throws ArithmeticException {
        return new Values(a.asDouble() - b.asDouble());
    }

    @Override
    public Values mult(Values a, Values b) throws ArithmeticException {
        return new Values(a.asDouble() * b.asDouble());
    }
}
