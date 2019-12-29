package test_tidb;

import test_tidb.datatypes.DataType;

public class AField {

    private DataType dataType;
    private String value;
    
    public AField(DataType dataType) {
        this.dataType = dataType;
    }
    
    public DataType getDataType() {
        return dataType;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}