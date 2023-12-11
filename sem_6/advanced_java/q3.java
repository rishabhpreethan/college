import java.awt.*;
import java.awt.event.*;

public class q3 extends Frame implements WindowListener,ActionListener {
	private static final long serialVersionUID = 1L;
	TextField text = new TextField(20);
	Button b;
	private int numClicks = 0;
	public static void main(String[] args) {
		q3 myWindow = new q3("Button Click Count Window");
		myWindow.setSize(350,100);
		myWindow.setVisible(true);
	}
	public q3(String title) {
		super(title);
		setLayout(new FlowLayout());
		addWindowListener(this);
		b = new Button("Click me");
		add(b);
		add(text);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		numClicks++;
		text.setText("Click count: " + numClicks);}
		public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);
	}
	public void windowOpened(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
}