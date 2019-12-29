package test_tidb;

import java.util.ArrayList;
import java.util.List;

import test_tidb.datatypes.DataType;

public class SQLGenerator {
    
    public static final int COLUMN_COUNT = DataTypeDictionary.dataTypeList.size();//5;
    public static final int INSERT_COUNT = 10;
    private final List<ATuple> fewData = new ArrayList<ATuple>();
    private final List<AField> fieldsDefine = new ArrayList<AField>();
    private final String TABLE_NAME = "test.test_tidb_table";

    public String generateCreateTables() {
        StringBuilder createSB = new StringBuilder();
        createSB.append("CREATE TABLE ").append(TABLE_NAME).append("(").append("\r\n");
        
        for(int i = 1; i <= COLUMN_COUNT; i++) {
            DataType dt = DataTypeDictionary.dataTypeList.get(Util.getRndIntAbs(DataTypeDictionary.dataTypeList.size()));
            AField aField = new AField(dt);
            fieldsDefine.add(aField);
            createSB.append("col").append(i).append(" ").append(dt.getDataTypeName());
            if (i != COLUMN_COUNT) {
                createSB.append(",");
            } 
            createSB.append("\r\n");
        }

//        System.out.println(dt.getDataTypeName());
//        System.out.println(dt.nextValue());
        
        createSB.append(");").append("\r\n");
        return createSB.toString();
    }
    
    public String generateInsert() {
        StringBuilder insertSB = new StringBuilder();
        insertSB.append("INSERT INTO ").append(TABLE_NAME).append(" VALUES ").append("\r\n");
        
        for(int i = 1; i <= INSERT_COUNT; i++) {
            ATuple aTuple = new ATuple();
            int j = 1;
            insertSB.append("(");
            for(AField aField : fieldsDefine) {
                AField aNewField = new AField(aField.getDataType());
                aNewField.setValue(aField.getDataType().nextValue());
                aTuple.getFieldList().add(aNewField);
                if (j != 1) {
                    insertSB.append(",");
                }
                if (aNewField.getDataType().isQuoteFree()) {
                    insertSB.append(aNewField.getValue());
                } else {
                    insertSB.append("\'").append(aNewField.getValue()).append("\'");
                }
                j++;
            }
            insertSB.append(")");
            if (i != INSERT_COUNT) {
                insertSB.append(",");
            }
            insertSB.append("\r\n");
            fewData.add(aTuple);
        }
        
        insertSB.append(";").append("\r\n");
        return insertSB.toString();
    }
    
    public String generateDropTables() {
        StringBuilder dropSB = new StringBuilder();
        dropSB.append("DROP TABLE IF EXISTS ").append(TABLE_NAME).append("\r\n");
        return dropSB.toString();
    }
    
    public static void main(String[] args) {
        SQLGenerator dmlGene = new SQLGenerator();
        System.out.println(dmlGene.generateCreateTables());
        
        System.out.println(dmlGene.generateInsert());
    }

}
