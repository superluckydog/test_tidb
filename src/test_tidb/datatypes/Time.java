package test_tidb.datatypes;

import test_tidb.Util;

public class Time implements DataType {

    //TIME(0-6)  '-838:59:59.000000'-'838:59:59.000000'
    private int precision = 2;
    public Time(int precision) {
        this.precision = precision;
    }
    
    public String nextValue() {
        StringBuilder sb = new StringBuilder();
        if (Util.getRndBoolen()) {
            sb.append("-");
        }
        sb.append(Util.getRndInt(1, 838)).append(":")
        .append(Util.getRndInt(10, 59)).append(":")
        .append(Util.getRndInt(10, 59)).append(".");
        for(int i = 1; i <= this.precision; i++) {
            sb.append(Util.getRndInt(0,9));
        }
        return sb.toString();
    }

    @Override
    public String getDataTypeName() {
        return "TIME(" + String.valueOf(precision) + ")";
    }
    
    public boolean isQuoteFree() {
        return false;
    }
}