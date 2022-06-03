package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Login;

public class LoginDAO extends DAO {
	public Login search(String id, String password)
	throws Exception {
		Login login = null;

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement("select * from login where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			login = new Login();
			login.setNum(rs.getInt("num"));
			login.setId(rs.getString("id"));
			login.setPassword(rs.getString("password"));

		}

		st.close();
		con.close();

		return login;
	}

}
