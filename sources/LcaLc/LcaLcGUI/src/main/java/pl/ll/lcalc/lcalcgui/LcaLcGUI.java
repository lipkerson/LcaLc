/*
 * DesktopApplication1.java
 */

package pl.ll.lcalc.lcalcgui;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import pl.ll.lcalc.exprparser.CalcWorker;
import pl.ll.lcalcmath.ExprAble;
import pl.ll.lcalcmath.ExprOperator;

/**
 * The main class of the application.
 */
public class LcaLcGUI extends SingleFrameApplication {

    private  CalcWorker CalcWorker;
    private ExprAble ExprAble;


    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        ExprAble = new ExprOperator();
        CalcWorker = new CalcWorker(ExprAble);
        show(new LcaLcGUIView(this, CalcWorker));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of DesktopApplication1
     */
    public static LcaLcGUI getApplication() {
        return Application.getInstance(LcaLcGUI.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(LcaLcGUI.class, args);
    }
}
