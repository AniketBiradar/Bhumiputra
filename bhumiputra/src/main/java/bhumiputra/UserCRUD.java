package bhumiputra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCRUD {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhumiputradb", "root", "root");
		return connection;
	}

	public int signup(User user) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO USER(id,first_name,last_name,email,phone,address,password,role) VALUES(?,?,?,?,?,?,?,?)");

		statement.setInt(1, user.getId());
		statement.setString(2, user.getFirst_name());
		statement.setString(3, user.getLast_name());
		statement.setString(4, user.getEmail());
		statement.setLong(5, user.getPhone());
		statement.setString(6, user.getAddress());
		statement.setString(7, user.getPassword());
		statement.setString(8, user.getRole());

		int count = statement.executeUpdate();
		connection.close();
		return count;
	}

	public static int retrieveMaxIdFromDatabase() throws ClassNotFoundException, SQLException {
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT MAX(id) FROM USER");
				ResultSet resultSet = statement.executeQuery()) {

			if (resultSet.next()) {
				return resultSet.getInt(1);
			}

			return 0;
		}
	}

	public String login(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE email=?");

		statement.setString(1, email);
		ResultSet set = statement.executeQuery();
		String password = null;
		if (set.next()) {
			password = set.getString("password");
		}
		connection.close();
		return password;
	}

	public String getUserRole(String email) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement("SELECT role FROM USER WHERE email=?");

		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		String role = null;

		if (resultSet.next()) {
			role = resultSet.getString("role");
		}

		connection.close();
		return role;
	}

}
