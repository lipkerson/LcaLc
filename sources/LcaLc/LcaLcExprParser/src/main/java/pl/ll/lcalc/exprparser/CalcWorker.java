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

    public static final String EXAMPLE_EXPR = "2+3-4";
    private Exception lastExc;
    
    
    public CalcWorker(ExprAble exprAble) {
        super(exprAble);
    }    

    public void calcProperChar(String s, CharActionInfo charActionInfo) {
        charActionInfo.clear();        
        if (s.equals("\n")) {
            charActionInfo.setStart(true);
            return;
        }

        if (s.equals("(")) {
            charActionInfo.setLeft(true);
            return;
        }

        if (s.equals(")")) {
            charActionInfo.setRight(true);
            return;
        }

        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return;
        }

        String newS = Utils.onlyNumbers(s);
        if (!s.equals(newS)) {
            charActionInfo.setIncorrect(true);
        }
    }



    public void calcProc(boolean showGrapg, ExprLexer lexer) throws RecognitionException {
        resetOutCome();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        parser.setBuildParseTree(true);

        ExprParser.CalcexptContext tree = parser.calcexpt();
        if (showGrapg) {
            tree.inspect(parser);
        }
        visit(tree);
    }

    public Double calcString(String s) {
        ExprLexer lexer = new ExprLexer(new ANTLRInputStream(s));
        try {
            calcProc(true, lexer);
        } catch (Exception e) {
            lastExc = e;
        }
        return getOutcome();
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
