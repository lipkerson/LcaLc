package pl.ll.lcalc.lcalcgui.components;

/**
 *
 * @author lucjan
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;


public class GradientPanel extends JPanel {

    private Color panObwCol = new Color(11, 0, 120);
    private Color panWewnCol = new Color(0, 0, 210);

    private int pozycjaXprostakatu = 34;
    private int pozycjaYprostakatuUp = 0;
    private int pozycjaYprostakatuDown = 22;
    private int katZaokraglenia = 45;


    public GradientPanel() {
        setOpaque(false);

    }

    public int getKatZaokraglenia() {
        return katZaokraglenia;
    }

    public void setKatZaokraglenia(int katZaokraglenia) {
        this.katZaokraglenia = katZaokraglenia;
    }

    public Color getPanObwCol() {
        return panObwCol;
    }

    public void setPanObwCol(Color panObwCol) {
        this.panObwCol = panObwCol;
    }

    public Color getPanWewnCol() {
        return panWewnCol;
    }

    public void setPanWewnCol(Color panWewnCol) {
        this.panWewnCol = panWewnCol;
    }

    public int getPozycjaXprostakatu() {
        return pozycjaXprostakatu;
    }

    public void setPozycjaXprostakatu(int pozycjaXprostakatu) {
        this.pozycjaXprostakatu = pozycjaXprostakatu;
    }

    public int getPozycjaYprostakatuDown() {
        return pozycjaYprostakatuDown;
    }

    public void setPozycjaYprostakatuDown(int pozycjaYprostakatuDown) {
        this.pozycjaYprostakatuDown = pozycjaYprostakatuDown;
    }

    public int getPozycjaYprostakatuUp() {
        return pozycjaYprostakatuUp;
    }

    public void setPozycjaYprostakatuUp(int pozycjaYprostakatuUp) {
        this.pozycjaYprostakatuUp = pozycjaYprostakatuUp;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintChildren(g);

        int w = getWidth() - 2 * pozycjaXprostakatu;
        int h = getHeight() - (pozycjaYprostakatuUp + pozycjaYprostakatuDown);


        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint gp = new GradientPaint(
                0, 70, panWewnCol,
                0, h, panObwCol);

        g2.setPaint(gp);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.fillRoundRect(pozycjaXprostakatu, pozycjaYprostakatuUp, w, h, katZaokraglenia, katZaokraglenia);
        g2.setStroke(new BasicStroke(1f));
        g2.setColor(panObwCol);
        g2.drawRoundRect(pozycjaXprostakatu, pozycjaYprostakatuUp, w, h, katZaokraglenia, katZaokraglenia);

        g2.dispose();
    }
}