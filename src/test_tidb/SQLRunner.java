package test_tidb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import test_tidb.datatypes.DataType;

public class SQLRunner {

    public void runSQLs() throws SQLException {
//        Connection connection = Connector.getTidbConnection();
//        Statement stmt = connection.createStatement();
        SQLGenerator sqlGene = new SQLGenerator();
       // stmt.execute(sqlGene.generateDropTables());
        String ddl = sqlGene.generateCreateTables();
        System.out.println(ddl);
      //  stmt.execute(ddl);
        String insert = sqlGene.generateInsert();
        System.out.println(insert);
        //stmt.execute(insert);
//        ResultSet rs = stmt.executeQuery();
//        while (rs.next()) {
//            System.out.println(rs.getString(1));
////        }
//        stmt.execute(sqlGene.generateDropTables());
    }
    
    public static void main(String[] args) throws SQLException {
        SQLRunner sqlRunner = new SQLRunner();
        sqlRunner.runSQLs();
    }

}
