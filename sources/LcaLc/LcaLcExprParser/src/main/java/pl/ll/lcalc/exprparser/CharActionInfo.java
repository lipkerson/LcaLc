package pl.ll.lcalc.exprparser;

/**
 *
 * @author lucjan
 */
public class CharActionInfo {

    private boolean start;
    private boolean left;
    private boolean right;
    private boolean incorrect;

    public CharActionInfo() {
    }

    public CharActionInfo(boolean start, boolean left, boolean right) {
        this.start = start;
        this.left = left;
        this.right = right;
    }

    public void clear() {
        start = false;
        left = false;
        right = false;
        incorrect = false;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isIncorrect() {
        return incorrect;
    }

    public void setIncorrect(boolean incorrect) {
        this.incorrect = incorrect;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    

}
