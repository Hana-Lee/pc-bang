package kr.co.leehana.service;

import kr.co.leehana.Utils.DBConnectionManager;
import kr.co.leehana.model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Hana Lee
 * @since 2015-11-14 04-10
 */
public class MemberServiceImpl implements MemberService {

	private DBConnectionManager dbConnectionManager = DBConnectionManager.getInstance();

	public MemberServiceImpl() {
	}

	@Override
	public Member getMember(String userId) throws Exception {
		Connection connection = dbConnectionManager.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from member where user_id = ?");
		preparedStatement.setString(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();
		Member member = null;
		if (resultSet.next()) {
			member = new Member();
			member.setId(resultSet.getLong("id"));
			member.setUserId(resultSet.getString("user_id"));
			member.setPassword(resultSet.getString("password"));
			member.setFullName(resultSet.getString("full_name"));
		}
		dbConnectionManager.freeConnection(connection, preparedStatement, resultSet);
		return member;
	}
}
