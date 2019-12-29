package test_tidb.datatypes;

import test_tidb.Util;

public class Json implements DataType {
    
    //JSON  {"name": "Beijing", "population": 100}
    public Json() {
    }
    
    //private int leftBound = 0;
    private int rightBound = 20;

    public String nextValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"name\": \"").append(Util.getRndStr(rightBound)).append("\", \"population\": ").append(Util.getUnsignedRnd(rightBound)).append("}");
        return sb.toString();
    }

    @Override
    public String getDataTypeName() {
        return "JSON";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}