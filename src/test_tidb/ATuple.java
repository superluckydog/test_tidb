package test_tidb;

import java.util.ArrayList;
import java.util.List;

public class ATuple {

    private List<AField> fieldList = new ArrayList<AField>();

    public List<AField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<AField> fieldList) {
        this.fieldList = fieldList;
    }
}