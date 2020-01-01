package test_tidb;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Connector {

    public static Connection getConnection(String host, String port, String dbName, String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://" + host + ":" + port + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true", user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        String host = "62.234.178.215";
        String port = "4000";
        String dbName = "test";
        String user = "test";
        String password = "tidb_learner";      
        getConnection(host, port, dbName, user, password);
    }

}
