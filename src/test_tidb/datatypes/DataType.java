package test_tidb.datatypes;

public interface DataType {
    
    public String getDataTypeName();
    
    public String nextValue();
    
    public boolean isQuoteFree();
}