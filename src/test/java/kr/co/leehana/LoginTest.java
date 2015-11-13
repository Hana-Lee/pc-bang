package kr.co.leehana;

import kr.co.leehana.Utils.DBConnectionManager;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Hana Lee
 * @since 2015-11-13 14-19
 */
public class LoginTest {

	@Test
	public void testLogin() {
		final String id = "voyaging";
		final String password = "1234";

		final DBConnectionManager manager = DBConnectionManager.getInstance();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = null;
		String userPassword = null;

		try {
			connection = manager.getConnection();

			sql = "select password from member where user_id=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userPassword = resultSet.getString("password");

				if (password.equals(userPassword)) {
					System.out.println("비밀번호가 같습니다.");
				} else {
					System.out.println("비밀번호가 다릅니다.");
				}
			}
		} catch (SQLException e) {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.freeConnection(connection, preparedStatement, resultSet);
		}
	}
}
