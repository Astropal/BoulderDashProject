package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The Class DAOConnection.
 *
 * @author Bastien Dupont
 */
public class DBConnection {

	private static String URL = "jdbc:mysql://localhost/boulderdashproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	private static String USER = "root";
	private static String PASSWD = "";

	private Connection connection = null;

	private DBConnection INSTANCE;

	/**
	 * Get the instance.
	 * @return the Instance
	 */
	public DBConnection getInstance() {
		if (INSTANCE != null) {
			INSTANCE = new DBConnection();
		}
		return INSTANCE;
	}

	/**
	 * Connect to the data base.
	 */
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Connexion etablished !");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Get connection.
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}
}