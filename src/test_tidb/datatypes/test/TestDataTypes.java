package test_tidb.datatypes.test;

import java.text.ParseException;

import test_tidb.datatypes.Bigint;
import test_tidb.datatypes.BigintUnsigned;
import test_tidb.datatypes.Binary;
import test_tidb.datatypes.Bit;
import test_tidb.datatypes.Bit5;
import test_tidb.datatypes.Blob;
import test_tidb.datatypes.Boolean;
import test_tidb.datatypes.Char;
import test_tidb.datatypes.Date;
import test_tidb.datatypes.Float;
import test_tidb.datatypes.Json;
import test_tidb.datatypes.LongBlob;
import test_tidb.datatypes.LongText;
import test_tidb.datatypes.MediumBlob;
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
import test_tidb.datatypes.Varbinary10;
import test_tidb.datatypes.Varchar;
import test_tidb.datatypes.Year;

public class TestDataTypes {
    
    public static void main(String[] args) throws ParseException {
        
        Boolean b = new Boolean();
        System.out.println("boolean : " + b.nextValue());
        Char ch = new Char();
        System.out.println("char : " + ch.nextValue());
        Binary binary = new Binary();
        System.out.println("binary : " + binary.nextValue());
        Bit bit = new Bit();
        System.out.println("bit : " + bit.nextValue());
        Bit5 bit5 = new Bit5();
        System.out.println("bit5 : " + bit5.nextValue());
        Blob blob = new Blob();
        System.out.println("blob : " + blob.nextValue());
        Json json = new Json();
        System.out.println("json : " + json.nextValue());
        LongBlob longBlob = new LongBlob();
        System.out.println("longBlob : " + longBlob.nextValue());
        LongText longText = new LongText();
        System.out.println("longText : " + longText.nextValue());
        MediumBlob mediumBlob = new MediumBlob();
        System.out.println("mediumBlob : " + mediumBlob.nextValue());
        Mediumint mediumInt = new Mediumint();
        System.out.println("mediumInt : " + mediumInt.nextValue());
        MediumintUnsigned mediumintUnsigned = new MediumintUnsigned();
        System.out.println("mediumintUnsigned : " + mediumintUnsigned.nextValue());
        Smallint smallint = new Smallint();
        System.out.println("smallint : " + smallint.nextValue());
        SmallintUnsigned smallintUnsigned = new SmallintUnsigned();
        System.out.println("smallintUnsigned : " + smallintUnsigned.nextValue());
        Text text = new Text();
        System.out.println("text : " + text.nextValue());
        Tinyblob tinyBlob = new Tinyblob();
        System.out.println("tinyBlob : " + tinyBlob.nextValue());
        Tinyint tinyint = new Tinyint();
        System.out.println("tinyint : " + tinyint.nextValue());
        Tinyint1 tinyint1 = new Tinyint1();
        System.out.println("tinyint1 : " + tinyint1.nextValue());
        TinyintUnsigned tinyintUnsigned = new TinyintUnsigned();
        System.out.println("tinyintUnsigned : " + tinyintUnsigned.nextValue());
        Varbinary10 varbinary = new Varbinary10();
        System.out.println("varbinary : " + varbinary.nextValue());
        Varchar varchar = new Varchar();
        System.out.println("varchar : " + varchar.nextValue());
        Year year = new Year();
        System.out.println("year : " + year.nextValue());
        Bigint bigint = new Bigint();
        System.out.println("bigint : " + bigint.nextValue());
        BigintUnsigned bigintUnsigned = new BigintUnsigned();
        System.out.println("bigintUnsigned : " + bigintUnsigned.nextValue());
        Date date = new Date();
        System.out.println("date : " + date.nextValue());
        Time time = new Time(6);
        System.out.println("time : " + time.nextValue());
        Timestamp timestamp = new Timestamp(6);
        System.out.println("timestamp : " + timestamp.nextValue());
        Float fl = new Float();
        System.out.println("float : " + fl.nextValue());
    }
}