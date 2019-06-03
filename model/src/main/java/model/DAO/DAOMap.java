package model.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The Class DAOMap.
 *
 * @author Bastien Dupont
 */
public class DAOMap {

	private DBConnection MyConnection;
	private String txt = "C:\\PC\\Travail\\A1\\Projets\\Projet 5\\SujetPOO2019\\JPU-BlankProject\\main\\road.txt";

	/**
	 * Instantiate the DAOMap.
	 */
	public DAOMap() {
		this.MyConnection = new DBConnection();
		this.MyConnection.connect();
	}

	/**
	 * Load the level.
	 * @param id
	 * @throws IOException
	 */
	public void loadlevel(int id) throws IOException {

		try {

			String sql = "{call maplevel(?)}";
			CallableStatement call = MyConnection.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			while (resultSet.next()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(txt));
				writer.write(resultSet.getString(1));
				writer.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}