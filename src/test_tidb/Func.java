package test_tidb;

import java.util.HashMap;
import java.util.Map;

public class Func {

    public static Map<String, String> dt2Func = new HashMap<String, String>();
    
    static {
        dt2Func.put("CHAR", "CONCAT");
        dt2Func.put("VARCHAR(100)", "CONCAT");
        dt2Func.put("VARBINARY(10)", "CONCAT");
        dt2Func.put("LONGTEXT", "CONCAT");
        dt2Func.put("LONGBLOB", "CONCAT");
        
        dt2Func.put("BIGINT", "+");
        dt2Func.put("FLOAT", "+");
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
