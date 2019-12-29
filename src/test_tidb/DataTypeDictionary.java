package test_tidb;

import java.util.ArrayList;
import java.util.List;

import test_tidb.datatypes.Bigint;
import test_tidb.datatypes.BigintUnsigned;
import test_tidb.datatypes.Binary;
import test_tidb.datatypes.Bit;
import test_tidb.datatypes.Bit5;
import test_tidb.datatypes.Blob;
import test_tidb.datatypes.Boolean;
import test_tidb.datatypes.Char;
import test_tidb.datatypes.DataType;
import test_tidb.datatypes.Date;
import test_tidb.datatypes.Datetime;
import test_tidb.datatypes.Mediumint;
import test_tidb.datatypes.MediumintUnsigned;
import test_tidb.datatypes.Smallint;
import test_tidb.datatypes.SmallintUnsigned;
import test_tidb.datatypes.Text;
import test_tidb.datatypes.Time;
import test_tidb.datatypes.Timestamp;
import test_tidb.datatypes.Tinyblob;
import test_tidb.datatypes.Tinyint;
import test_tidb.datatypes.Tinyint1;
import test_tidb.datatypes.TinyintUnsigned;
import test_tidb.datatypes.Varbinary;
import test_tidb.datatypes.Varchar;
import test_tidb.datatypes.Year;
import test_tidb.datatypes.Float;
import test_tidb.datatypes.Json;
import test_tidb.datatypes.LongBlob;
import test_tidb.datatypes.LongText;
import test_tidb.datatypes.MediumBlob;

public class DataTypeDictionary {
    
    public static List<DataType> dataTypeList = new ArrayList<DataType>();
    
    static {
//        dataTypeList.add(new Bigint());
//        dataTypeList.add(new BigintUnsigned());
//        dataTypeList.add(new Binary());
//        dataTypeList.add(new Bit());
//        dataTypeList.add(new Bit5());
        
        
        dataTypeList.add(new Blob());
        dataTypeList.add(new Boolean());
        dataTypeList.add(new Char());
//        dataTypeList.add(new Date());
//        dataTypeList.add(new Datetime(4));
//        dataTypeList.add(new Time(4));
//        dataTypeList.add(new Timestamp(4));
        dataTypeList.add(new Float());
        dataTypeList.add(new Json());
        dataTypeList.add(new LongBlob());
        dataTypeList.add(new LongText());
//        dataTypeList.add(new MediumBlob());
//        dataTypeList.add(new Mediumint());
//        dataTypeList.add(new MediumintUnsigned());
//        dataTypeList.add(new Smallint());
//        dataTypeList.add(new SmallintUnsigned());
//        dataTypeList.add(new Tinyint());
//        dataTypeList.add(new Tinyint1());
//        dataTypeList.add(new TinyintUnsigned());
//        dataTypeList.add(new Text());
//        dataTypeList.add(new Tinyblob());
//        dataTypeList.add(new Varbinary());
//        dataTypeList.add(new Varchar());
//        dataTypeList.add(new Year());
    }

    public static void main(String[] args) {
        DataType dt = DataTypeDictionary.dataTypeList.get(Util.getRndInt(DataTypeDictionary.dataTypeList.size()));
        
        System.out.println(dt.getDataTypeName());
        System.out.println(dt.nextValue());
    }

}