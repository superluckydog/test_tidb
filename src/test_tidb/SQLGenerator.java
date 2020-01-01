package test_tidb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import test_tidb.datatypes.DataType;

public class SQLGenerator {
    
    public static final int COLUMN_COUNT = 5;//DataTypeDictionary.dataTypeList.size();
    public static final int INSERT_COUNT = 10;
    private static final List<AField> fieldsDefine = new ArrayList<AField>();
    private static final String TABLE_NAME = "test.test_tidb_table";
    private static final String SELECT = "SELECT * FROM " + TABLE_NAME + " ORDER BY col_key";
    
    private String dropDdl;
    private String createDdl;
    private List<ATuple> aTupleList;
    private String insert;
    private String delete;
    
    private List<ATuple> aTupleDeleteList;
    private List<ATuple> aTupleUpdateList;
    
    public SQLGenerator(boolean checkAllTypes) {
        dropDdl = generateDropTables();
        createDdl = generateCreateTables(checkAllTypes);
        aTupleList = generateInsertValues();
        insert = generateInsertSQL(aTupleList);
        aTupleDeleteList = generateDeleteValues();
        delete = generateDeleteSQL(aTupleDeleteList);
    }
    
    public List<ATuple> getDeleteTupleList() {
        return aTupleDeleteList;
    }
    
    public List<ATuple> getTupleList() {
        return aTupleList;
    }
    
    public String generateCreateTables(boolean checkAllDt) {
        StringBuilder createSB = new StringBuilder();
        createSB.append("CREATE TABLE ").append(TABLE_NAME).append("(").append("\r\n");
        createSB.append("col_key int NOT NULL AUTO_INCREMENT primary key,");
        
        if (checkAllDt) {
            for(int i = 0; i < DataTypeDictionary.dataTypeList.size(); i++) {
                DataType dt = DataTypeDictionary.dataTypeList.get(i);
                AField aField = new AField(dt);
                fieldsDefine.add(aField);
                createSB.append("col").append(i).append(" ").append(dt.getDataTypeName());
                if (i != (DataTypeDictionary.dataTypeList.size() - 1)) {
                    createSB.append(",");
                } 
                createSB.append("\r\n");
            }
        } else {
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
        }
        
        createSB.append(");").append("\r\n");
        return createSB.toString();
    }
    
    public List<ATuple> generateInsertValues() { 
        List<ATuple> fewData = new ArrayList<ATuple>();
        for(int i = 1; i <= INSERT_COUNT; i++) {
            ATuple aTuple = new ATuple();
            for(AField aField : fieldsDefine) {
                AField aNewField = new AField(aField.getDataType());
                aNewField.setValue(aField.getDataType().nextValue());
                aTuple.getFieldList().add(aNewField);
            }
            fewData.add(aTuple);
        }
        return fewData;
    }
    
    
    public List<ATuple> generateDeleteValues() { 
        if (aTupleList.size() == 0) {
            return null;
        }
        List<ATuple> data2Delete = new ArrayList<ATuple>();
        Random rnd = new Random();
        int DELETE_COUNT = rnd.nextInt(INSERT_COUNT);
        for(int i = 1; i <= DELETE_COUNT; i++) {
            int id = rnd.nextInt(INSERT_COUNT - i);
            data2Delete.add(aTupleList.get(id));
            aTupleList.remove(id);
        }
        return data2Delete;
    }
    
    
    public String generateDeleteSQL(List<ATuple> deleteData) {
        StringBuilder deleteSB = new StringBuilder();
        deleteSB.append("DELETE FROM ").append(TABLE_NAME);
        deleteSB.append(" WHERE ");
        int i = 1;
        Random rnd = new Random();
        for (ATuple aTuple : deleteData) {
            int columnNumber = rnd.nextInt(aTuple.getFieldList().size()-1);
            AField aField = aTuple.getFieldList().get(columnNumber);

            if (aField.getDataType().isQuoteFree()) {
                deleteSB.append("c" + columnNumber + " = ").append(aField.getValue());
            } else {
                deleteSB.append("c" + columnNumber + " = ").append("\'").append(aField.getValue()).append("\'");
            }
            
            if (i != deleteData.size()) {
                deleteSB.append(" OR ");
            }
            deleteSB.append("\r\n");
            i++;
        }
        
        return deleteSB.toString();
    }
    
    public String generateInsertSQL(List<ATuple> fewData) {
        StringBuilder insertSB = new StringBuilder();
        insertSB.append("INSERT INTO ").append(TABLE_NAME);
        insertSB.append("( ");
        for(int i = 1; i <= fieldsDefine.size(); i++) {
            insertSB.append("col" + i);
            if (i != fieldsDefine.size()) {
                insertSB.append(",");
            }
        }
        insertSB.append(") ").append(" VALUES ").append("\r\n");
        
        int i = 1;
        for (ATuple aTuple : fewData) {
            int j = 1;
            insertSB.append("(");
            for(AField aField : aTuple.getFieldList()) {
                if (j != 1) {
                    insertSB.append(",");
                }
                if (aField.getDataType().isQuoteFree()) {
                    insertSB.append(aField.getValue());
                } else {
                    insertSB.append("\'").append(aField.getValue()).append("\'");
                }
                j++;
            }
            insertSB.append(")");
            if (i != fewData.size()) {
                insertSB.append(",");
            }
            insertSB.append("\r\n");
            i++;
        }
        
        return insertSB.toString();
    }
    
    public String generateDropTables() {
        StringBuilder dropSB = new StringBuilder();
        dropSB.append("DROP TABLE IF EXISTS ").append(TABLE_NAME).append("\r\n");
        return dropSB.toString();
    }

    public String getSELECT() {
        return SELECT;
    }

    public String getDropDdl() {
        return dropDdl;
    }

    public String getCreateDdl() {
        return createDdl;
    }

    public String getInsert() {
        return insert;
    }
    
    public String getDelete() {
        return delete;
    }
    
    public static void main(String[] args) {
        boolean checkAllDT = false;
        SQLGenerator dmlGene = new SQLGenerator(checkAllDT);
        System.out.println(dmlGene.generateCreateTables(checkAllDT));
        List<ATuple> aTupleList = dmlGene.generateInsertValues();
        System.out.println(dmlGene.generateInsertSQL(aTupleList));
    }
}
