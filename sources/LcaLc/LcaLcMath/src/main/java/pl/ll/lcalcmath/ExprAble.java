package pl.ll.lcalcmath;

import pl.ll.datacontainers.Values;

/**
 *
 * @author lucjan
 */
public interface ExprAble {

    Values add(Values a, Values b) throws ArithmeticException;

    Values minus(Values a, Values b) throws ArithmeticException;

    Values mult(Values a, Values b) throws ArithmeticException;

    Values div(Values a, Values b) throws ArithmeticException;
    
}
