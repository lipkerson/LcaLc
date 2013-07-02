package pl.ll.lcalc.exprparser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import pl.ll.datacontainers.Values;
import pl.ll.lcalc.exprparser.autogenerated.ExprLexer;
import pl.ll.lcalc.exprparser.autogenerated.ExprParser;
import pl.ll.lcalcmath.ExprAble;
import pl.ll.lcalcmath.ExprOperator;

/**
 *
 * @author lucjan
 * 
 */

public class CalcWorker extends CalcVisitor{

    public static final String EXAMPLE_EXPR = "-2+3-4";
    
    
    public CalcWorker(ExprAble exprAble) {
        super(exprAble);
    }    
    
    public boolean calcProc(boolean showGrapg, ExprLexer lexer) {
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.setBuildParseTree(true);
        try {
            ExprParser.CalcexptContext tree = parser.calcexpt();
            if (showGrapg) {
                tree.inspect(parser);
            }
            Values v = visit(tree);
            System.out.println("Empty");
            return true;
        } catch (RecognitionException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    public static void main(String[] args) {
        try {
            ExprLexer lexer = new ExprLexer(new ANTLRInputStream(EXAMPLE_EXPR));  
            new CalcWorker(new ExprOperator()).calcProc(true, lexer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            
    }
}