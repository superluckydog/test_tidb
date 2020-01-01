package test_tidb;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;

public class CompareWithMysql {
    
    public void runCreate(Statement stmt, SQLGenerator sqlGene) throws SQLException, IOException {
        String dropDDL = sqlGene.getDropDdl();
        System.out.println(dropDDL);
        stmt.execute(dropDDL);
        String createDDL = sqlGene.getCreateDdl();
        System.out.println(createDDL);
        stmt.execute(createDDL);
        String insert = sqlGene.getInsert();
        System.out.println(insert);
        stmt.execute(insert);
    }
    
    public ResultSet runSelect(Statement stmt, SQLGenerator sqlGene) throws SQLException, IOException {
        ResultSet rs = stmt.executeQuery(sqlGene.getSELECT());
        return rs;
    }
    
    public void runDelete(Statement stmt, SQLGenerator sqlGene) throws SQLException, IOException {
        String delete = sqlGene.getDelete();
        System.out.println(delete);
        //stmt.execute(delete);
    }
    
    public void printResultSet(ResultSet rs) throws SQLException, IOException {
        ResultSetMetaData meta = rs.getMetaData();
        //System.out.println("meta.getColumnCount() " + meta.getColumnCount());
        while (rs.next()) {
            for(int i = 1; i <= meta.getColumnCount(); i++) {
                //System.out.println("Column Type Name : " + meta.getColumnTypeName(i));
                if (meta.getColumnTypeName(i).equals("VARBINARY")
                        || meta.getColumnTypeName(i).equals("BINARY")) {
                    InputStream inputStream = rs.getBinaryStream(i);
                    byte b[] = new byte[1024] ;
                    inputStream.read(b);
                    System.out.print(new String(b));
                    inputStream.close();
                } else if (meta.getColumnTypeName(i).equals("BLOB")
                        || meta.getColumnTypeName(i).equals("LONGBLOB")
                        || meta.getColumnTypeName(i).equals("TINYBLOB")
                        || meta.getColumnTypeName(i).equals("MEDIUMBLOB")) {
                    Blob blob = rs.getBlob(i);
                    InputStream inputStream = blob.getBinaryStream();
                    byte b[] = new byte[1024] ;
                    inputStream.read(b);
                    System.out.println(new String(b));
                    inputStream.close();
                } else if (meta.getColumnTypeName(i).equals("BIGINT UNSIGNED")) {
                    BigDecimal bigDecimal = rs.getBigDecimal(i);
                    System.out.println(bigDecimal.toString());
                } else if (meta.getColumnTypeName(i).equals("BIGINT")) {
                    Long l = rs.getLong(i);
                    System.out.println(l);
                } else if (meta.getColumnTypeName(i).equals("DATETIME")
                        || meta.getColumnTypeName(i).equals("DATE")
                        || meta.getColumnTypeName(i).equals("TIME")
                       // || meta.getColumnTypeName(i).equals("TIMESTAMP")
                        ) {
                    Date d = rs.getDate(i);
                    System.out.println(d);
                } else if (meta.getColumnTypeName(i).equals("UNKOWN")) {
                    InputStream inputStream = rs.getBinaryStream(i);
                    String json = Util.getStrFromInsByCode(inputStream, "utf-8");
                    System.out.println(json);
                    inputStream.close();
                } else {
                    System.out.println(rs.getString(i));
                }
            }
            System.out.println("--------------------------------------------------");
        }
        rs.close();
    }
    
    public boolean cmpResultSet(ResultSet myRs, ResultSet tiRs) throws SQLException, IOException {
        ResultSetMetaData myMeta = myRs.getMetaData();
        ResultSetMetaData tiMeta = tiRs.getMetaData();
        
        if (myMeta.getColumnCount() != tiMeta.getColumnCount()) {
            return false;
        }
        
        while (myRs.next() && tiRs.next()) {
            for(int i = 1; i <= myMeta.getColumnCount(); i++) {
                //System.out.println("Column Type Name : " + meta.getColumnTypeName(i));
                if (tiMeta.getColumnTypeName(i).equals("VARBINARY")
                        || tiMeta.getColumnTypeName(i).equals("BINARY")) {
                    InputStream tiInputStream = tiRs.getBinaryStream(i);
                    byte tiB[] = new byte[1024] ;
                    tiInputStream.read(tiB);
                    String tiStr = new String(tiB);
                    tiInputStream.close();
                    
                    InputStream myInputStream = myRs.getBinaryStream(i);
                    byte myB[] = new byte[1024] ;
                    myInputStream.read(myB);
                    String myStr = new String(myB);
                    myInputStream.close();
                    
                    Assert.assertTrue(tiStr + "" + myStr, tiStr.equals(myStr));
                } else if (tiMeta.getColumnTypeName(i).equals("BLOB")
                        || tiMeta.getColumnTypeName(i).equals("LONGBLOB")
                        || tiMeta.getColumnTypeName(i).equals("TINYBLOB")
                        || tiMeta.getColumnTypeName(i).equals("MEDIUMBLOB")) {
                    Blob tiBlob = tiRs.getBlob(i);
                    InputStream tiInputStream = tiBlob.getBinaryStream();
                    byte tiB[] = new byte[1024] ;
                    tiInputStream.read(tiB);
                    String tiStr = new String(tiB);
                    tiInputStream.close();
                    
                    Blob myBlob = tiRs.getBlob(i);
                    InputStream myInputStream = myBlob.getBinaryStream();
                    byte myB[] = new byte[1024] ;
                    myInputStream.read(myB);
                    String myStr = new String(myB);
                    myInputStream.close();
                    
                    Assert.assertTrue(tiStr + "" + myStr, tiStr.equals(myStr));
                } else if (tiMeta.getColumnTypeName(i).equals("BIGINT UNSIGNED")) {
                    BigDecimal tiBigDecimal = tiRs.getBigDecimal(i);
                    BigDecimal myBigDecimal = myRs.getBigDecimal(i);
                    Assert.assertTrue(tiBigDecimal.toString() + "" + myBigDecimal.toString(), tiBigDecimal.toString().equals(myBigDecimal.toString()));
                } else if (tiMeta.getColumnTypeName(i).equals("BIGINT")) {
                    Long tiL = tiRs.getLong(i);
                    Long myL = myRs.getLong(i);
                    Assert.assertTrue(tiL + "" + myL, tiL.equals(myL));
                } else if (tiMeta.getColumnTypeName(i).equals("DATETIME")
                        || tiMeta.getColumnTypeName(i).equals("DATE")
                        || tiMeta.getColumnTypeName(i).equals("TIME")
                       // || meta.getColumnTypeName(i).equals("TIMESTAMP")
                        ) {
                    Date tiD = tiRs.getDate(i);
                    Date myD = tiRs.getDate(i);
                    Assert.assertTrue(tiD.toString() + "" + myD.toString(), tiD.toString().equals(myD.toString()));
                    
                } else if (tiMeta.getColumnTypeName(i).equals("UNKOWN")) {
                    InputStream tiInputStream = tiRs.getBinaryStream(i);
                    String jsonTi = Util.getStrFromInsByCode(tiInputStream, "utf-8");
                    tiInputStream.close();
                    
                    InputStream myInputStream = myRs.getBinaryStream(i);
                    String jsonMy = Util.getStrFromInsByCode(myInputStream, "utf-8");
                    myInputStream.close();
                    
                    Assert.assertTrue(jsonTi + "" + jsonMy, jsonTi.equals(jsonMy));
                } else {
                    Assert.assertTrue(tiRs.getString(i) + "" + myRs.getString(i), tiRs.getString(i).equals(myRs.getString(i)));
                }
            }
            System.out.println("--------------------------------------------------");
        }
        myRs.close();
        tiRs.close();
        
        return true;
    }
    
    public boolean compareResultSetWithList(SQLGenerator sqlGene, ResultSet tiRs, List<ATuple> fewData) throws SQLException, IOException {
        ResultSetMetaData tiMeta = tiRs.getMetaData();
        
        if (fewData.get(0).getFieldList().size() != tiMeta.getColumnCount()) {
            return false;
        }
        
        int j = 0;
        while (tiRs.next()) {
            for(int i = 1; i <= tiMeta.getColumnCount(); i++) {
                //System.out.println("Column Type Name : " + meta.getColumnTypeName(i));
                if (tiMeta.getColumnTypeName(i).equals("VARBINARY")
                        || tiMeta.getColumnTypeName(i).equals("BINARY")) {
                    InputStream tiInputStream = tiRs.getBinaryStream(i);
                    byte tiB[] = new byte[1024] ;
                    tiInputStream.read(tiB);
                    String tiStr = new String(tiB);
                    tiInputStream.close();
                    
                    Assert.assertTrue(tiStr + "" + fewData.get(j).getFieldList().get(i).getValue(), tiStr.equals(fewData.get(j).getFieldList().get(i).getValue()));
                    
                } else if (tiMeta.getColumnTypeName(i).equals("BLOB")
                        || tiMeta.getColumnTypeName(i).equals("LONGBLOB")
                        || tiMeta.getColumnTypeName(i).equals("TINYBLOB")
                        || tiMeta.getColumnTypeName(i).equals("MEDIUMBLOB")) {
                    Blob tiBlob = tiRs.getBlob(i);
                    InputStream tiInputStream = tiBlob.getBinaryStream();
                    byte tiB[] = new byte[1024] ;
                    tiInputStream.read(tiB);
                    String tiStr = new String(tiB);
                    tiInputStream.close();
                    
                    Assert.assertTrue(tiStr + "" + fewData.get(j).getFieldList().get(i).getValue(), tiStr.equals(fewData.get(j).getFieldList().get(i).getValue()));
                    
                } else if (tiMeta.getColumnTypeName(i).equals("BIGINT UNSIGNED")) {
                    BigDecimal tiBigDecimal = tiRs.getBigDecimal(i);
                    
                    Assert.assertTrue(tiBigDecimal.toString() + "" + fewData.get(j).getFieldList().get(i).getValue(), tiBigDecimal.toString().equals(fewData.get(j).getFieldList().get(i).getValue()));
                } else if (tiMeta.getColumnTypeName(i).equals("BIGINT")) {
                    Long tiL = tiRs.getLong(i);
                    
                    Assert.assertTrue(tiL + "" + fewData.get(j).getFieldList().get(i).getValue(), tiL.equals(fewData.get(j).getFieldList().get(i).getValue()));
                } else if (tiMeta.getColumnTypeName(i).equals("DATETIME")
                        || tiMeta.getColumnTypeName(i).equals("DATE")
                        || tiMeta.getColumnTypeName(i).equals("TIME")
                       // || meta.getColumnTypeName(i).equals("TIMESTAMP")
                        ) {
                    Date tiD = tiRs.getDate(i);
                    
                    Assert.assertTrue(tiD.toString() + "" + fewData.get(j).getFieldList().get(i).getValue(), tiD.toString().equals(fewData.get(j).getFieldList().get(i).getValue()));
                } else if (tiMeta.getColumnTypeName(i).equals("UNKOWN")) {
                    InputStream tiInputStream = tiRs.getBinaryStream(i);
                    String jsonTi = Util.getStrFromInsByCode(tiInputStream, "utf-8");
                    tiInputStream.close();
                    
                    Assert.assertTrue(jsonTi + "" + fewData.get(j).getFieldList().get(i).getValue(), jsonTi.equals(fewData.get(j).getFieldList().get(i).getValue()));
                } else {
                    Assert.assertTrue(tiRs.getString(i) + "" + fewData.get(j).getFieldList().get(i).getValue(), tiRs.getString(i).equals(fewData.get(j).getFieldList().get(i).getValue()));
                }
            }
            System.out.println("--------------------------------------------------");
        }

        tiRs.close();
        return true;
    }
    
    public void compareTidbMysql () throws SQLException, IOException {
        String tiHost = "62.234.178.215";
        String tiPort = "4000";
        String tidbName = "test";
        String tiUser = "test";
        String tiPassword = "tidb_learner";
        
        String myHost = "62.234.178.215";
        String myPort = "4000";
        String mydbName = "test";
        String myUser = "test";
        String myPassword = "tidb_learner";
        
        //true to test all data types
        //false to test only five data types
        boolean checkAllTypes = false;
        
        SQLGenerator sqlGene = new SQLGenerator(checkAllTypes);
        Connection tidbConnection = Connector.getConnection(tiHost, tiPort, tidbName, tiUser, tiPassword);
        Statement tiStmt = tidbConnection.createStatement();
        CompareWithMysql sqlRunner = new CompareWithMysql();
        ResultSet tiRs = sqlRunner.runSelect(tiStmt, sqlGene);
        Connection myConnection = Connector.getConnection(myHost, myPort, mydbName, myUser, myPassword);
        Statement myStmt = myConnection.createStatement();
        ResultSet myRs = sqlRunner.runSelect(myStmt, sqlGene);
        
//        if (false) {
//            sqlRunner.printResultSet(tiRs);
//        }
        
        if (cmpResultSet(myRs, tiRs)) {
            System.out.println("Same with mysql");
        } else {
            System.out.println("Diff with mysql");
        }
    }
        
        
        public void compareTidbMem () throws SQLException, IOException {
            String tiHost = "62.234.178.215";
            String tiPort = "4000";
            String tidbName = "test";
            String tiUser = "test";
            String tiPassword = "tidb_learner";
            
            //true to test all data types
            //false to test only five data types
            boolean checkAllTypes = false;
            
            SQLGenerator sqlGene = new SQLGenerator(checkAllTypes);
            Connection tidbConnection = Connector.getConnection(tiHost, tiPort, tidbName, tiUser, tiPassword);
            Statement tiStmt = tidbConnection.createStatement();
            CompareWithMysql sqlRunner = new CompareWithMysql();
            sqlRunner.runCreate(tiStmt, sqlGene);
            ResultSet tiRs = sqlRunner.runSelect(tiStmt, sqlGene);
            List<ATuple> fewData = sqlGene.getTupleList();
            compareResultSetWithList(sqlGene, tiRs, fewData);
            
            runDelete(tiStmt, sqlGene);
            List<ATuple> deleteData = sqlGene.getDeleteTupleList();
            fewData.removeAll(deleteData);
            compareResultSetWithList(sqlGene, tiRs, deleteData);
            
            
//            if (false) {
//                sqlRunner.printResultSet(tiRs);
//            }
            

    }
    public static void main(String[] args) throws SQLException, IOException {
        CompareWithMysql compare = new CompareWithMysql();
        //compare.compareTidbMysql();
        compare.compareTidbMem();
    }

}
