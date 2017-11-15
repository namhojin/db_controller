import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class UI {
	JFrame frame = new JFrame();
	
	public UI() {}
	
	void set_panel(JPanel panel) {
		this.frame.add(panel);
	}
	
	void start_UI(String title){
	
		System.out.println("start_UI");
		
		this.frame.setTitle(title);
		this.frame.setBounds(0, 0, 400, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.frame.setLayout(new GridLayout(7,1));
		this.frame.setVisible(true);
	}
}
