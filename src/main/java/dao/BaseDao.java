package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.CampusException;

public abstract class BaseDao {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	protected ResultSet rsF = null;

	public BaseDao() throws CampusException {
		// DBに接続
		getConnection();
	}

	// DB接続処理
	private void getConnection() throws CampusException {
		try {
			if (con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url  = "jdbc:mysql://localhost/tekitore";
				String user = "root";
				String password = "pass";
				con = DriverManager.getConnection(url, user, password);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new CampusException("JDBCドライバが見つかりません");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("SQL実行中に例外が発生しました");
		}
	}

	// DB接続解除
	protected void close() throws CampusException {
		try {
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new CampusException("close処理中に例外が発生しました");
		}
	}
}