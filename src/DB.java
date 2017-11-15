import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;


public class DB {
	private static String ip,port,id,pw,sql,dname;
	//public String port = "3306";
	@SuppressWarnings("deprecation")
	public DB(Login login) {
		DB.ip = login.host_field.getText();
		DB.port = login.port_field.getText();
		DB.dname = login.dname_field.getText();
		DB.id = login.id_field.getText();
		DB.pw = login.pw_field.getText();
	}
	boolean isLogin(JComboBox combo) {
		combo.removeAllItems();
		
		List list = new List();
		//list = getQuery1("SHOW DATABASES;");
		list = getQuery1("SELECT * FROM user;");
		
		for(int i=0; i < list.getItemCount();i++) {
			combo.addItem(list.getItem(i));
		}
		return true;
	}
	List getQuery1(String sql) {
	//	ResultSet rs = null;
		List list = new List();
		try {
			Connection con = null;

			con = DriverManager.getConnection("jdbc:mysql://"+DB.ip+":"+DB.port+"/"+DB.dname, this.id, this.pw);
			
			java.sql.Statement st = null;

			st = con.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);

			if (st.execute(sql)) {
				rs = st.getResultSet();
			}
			while (rs.next()) {
				System.out.println(rs.getNString(1));
				list.add(rs.getNString(1));
			}
			
		} catch (SQLException sqex) {

			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
		return list;
	}
	void getVectorQuery() {}
}
