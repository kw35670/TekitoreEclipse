package dao;

import java.sql.SQLException;

import exception.CampusException;
import model.User;

public class userDao extends BaseDao{
	
	// DBに接続
	public userDao() throws CampusException {
		super();
	}
	
	// ログイン処理
	public User doLogin(String studentNumber, String pass) throws CampusException {
		User loginUser = null;
		try {
			// 検索実行
			String sql = "SELECT * FROM users WHERE student_number = ? AND pass = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, studentNumber);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String tel = rs.getString("tel");
				String mailAddress = rs.getString("mail_address");
				loginUser = new User(studentNumber, pass, firstName, lastName, tel, mailAddress);
			}

			// ログイン結果を確認
			if(loginUser == null) {
				throw new CampusException("ログインできませんでした。");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("SQL実行中に例外が発生しました");
		}
	// ユーザー情報を返却
	return loginUser;
	}

	// 新規登録処理
	public void signUp(User user) throws CampusException {
		String sn = user.getStudentNumber();
		String pass = user.getPass();
		String fn = user.getFirstName();
		String ln = user.getLastName();
		String tel = user.getTel();
		String ma = user.getMailAddress();
		
		try {
			String sql = "INSERT INTO users(student_number, pass,"
					+ "first_name, last_name, tel, mail_address) VALUE(?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, sn);
			ps.setString(2, pass);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setString(5, tel);
			ps.setString(6, ma);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CampusException("SQL実行中に例外が発生しました");
		}
	}
}
