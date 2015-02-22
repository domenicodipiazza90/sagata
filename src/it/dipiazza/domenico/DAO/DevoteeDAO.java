package it.dipiazza.domenico.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.dipiazza.domenico.model.Devotee;

public class DevoteeDAO {
	private static final String URL = "jdbc:oracl:thin:@localhost:1521:ORCL";
	private static final String USER = "santagata";
	private static final String PASSW = "santagata";
	private static final String SELECT_ALL = "SELECT name, surname, email FROM devotee";
	private static final String ADD = "INSERT INTO devotee (name, surname, email) VALUES (?,?,?)";

	public List<Devotee> allDevotee() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection con = DriverManager.getConnection(URL, USER, PASSW);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SELECT_ALL);) {
			return marshallDevotee(rs);
		}
	}

	public boolean addDevotee(Devotee d) throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(URL, USER, PASSW);
				PreparedStatement ps = con.prepareStatement(ADD);) {
			ps.setString(1, d.getName());
			ps.setString(2, d.getSurname());
			ps.setString(3, d.getEmail());

			ps.executeQuery();
			return true;
		}

	}

	private List<Devotee> marshallDevotee(ResultSet rs) throws SQLException {
		List<Devotee> devoteeFullList = new ArrayList<>();
		while (rs.next()) {
			Devotee d = new Devotee();
			d.setName(rs.getString("name"));
			d.setSurname(rs.getString("surname"));
			d.setEmail(rs.getString("email"));
			devoteeFullList.add(d);
		}
		return devoteeFullList;
	}
}
