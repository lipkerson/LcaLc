
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author lucjan
 */
public class TextAreaBottom extends JFrame
{
	public TextAreaBottom()
	{
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap( true );
		textArea.setWrapStyleWord( true );
		JPanel panel = new JPanel( new BorderLayout() );
		panel.setBackground( textArea.getBackground() );
		panel.setBorder( textArea.getBorder() );
		textArea.setBorder( null );
		panel.add(textArea, BorderLayout.SOUTH);
		add(new JScrollPane(panel));
	}

	public static void main(String[] args)
	{
		TextAreaBottom frame = new TextAreaBottom();
		frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
  		frame.setSize(100, 200);
  		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
	}
}