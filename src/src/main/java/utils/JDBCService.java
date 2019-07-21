package utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCService {
    private static final Logger logger = Logger.getLogger(JDBCService.class);
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "UnitOmega13";
    private static final String PASSWORD = "";

    public JDBCService() {
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            logger.error("driver error");
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.error("Error connecting to DB", e);
        }
        return null;
    }
}
