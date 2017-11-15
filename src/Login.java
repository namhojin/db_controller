import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
	JTextField host_field = new JTextField(20);
	JTextField port_field = new JTextField(20);
	JTextField dname_field = new JTextField(20);
	JTextField id_field = new JTextField(20);
	JPasswordField pw_field = new JPasswordField(20);
	JComboBox<Object> combo = new JComboBox<Object>();
	
	UI ui = new UI();
	
	public Login() {
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		
		JLabel host_label = new JLabel("host");
		panel1.add(host_label);
		panel1.add(host_field);
		JLabel port_label = new JLabel("port");
		panel2.add(port_label);
		port_field.setText("3306");
		panel2.add(port_field);
		JLabel dname_label = new JLabel("dbname");
		panel3.add(dname_label);
		panel3.add(dname_field);
		JLabel id_label = new JLabel("id");
		panel4.add(id_label);
		panel4.add(id_field);
		JLabel pw_label = new JLabel("pw");
		panel5.add(pw_label);
		panel5.add(pw_field);
		
		panel6.add(combo);
		
		JButton select = new JButton("select");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				select.setText((String) combo.getSelectedItem());
				select_db();
			}
		});
		panel6.add(select);
		
		host_field.setText("52.78.179.6");
		dname_field.setText("myhome");
		id_field.setText("howard");
		pw_field.setText("hdi2cdi");
		
		
		
		JButton login = new JButton("login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start_login();
			}
		});
		panel7.add(login);
		
		ui.set_panel(panel1);
		ui.set_panel(panel2);
		ui.set_panel(panel3);
		ui.set_panel(panel4);
		ui.set_panel(panel5);
		ui.set_panel(panel6);
		ui.set_panel(panel7);
		
		ui.start_UI("login");
	}
	void start_login() {
		System.out.println("start_login");
		DB db = new DB(this);
		if(db.isLogin(combo)) {
			System.out.println("login_good");
		}
	}
	void select_db() {
		System.out.println("select_db");
		DB db = new DB(this);
		List list = new List();
		list = db.getQuery1("select * from user;");
		UI ui = new UI();
		ui.start_UI(list.getItem(0));
		/*
		for(int i=0; i < list.getItemCount();i++) {
			combo.addItem(list.getItem(i));
		}
		*/
		
//		db.getQuery1("SHOW TABLES;");
	}
}
