package pandey.abidha.sqlliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by achintyadwivedi on 11/25/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {



    public static  final  String DATABASE_NAME="FirstResponder.db";
    public static final String TABLE_NAME = "Volunteer_Details_Data";
    public static final String TABLE_NAME_USER = "Volunteer_User_Data";
    public static final String TABLE_NAME_MEDICAL = "Medical_Data";
    public static final String TABLE_NAME_VOLUNTEER_RECORDS = "Volunteer_Records";
    public static final String ID = "ID";
    public static final String USERID= "ID";
    public static final String EMAIL = "EMAIL";
    public static final String PASSWORD = "PASSWORD";
    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String SECONDNAME = "SECONDNAME";
    public static final String PHONENUMBER = "PHONENUMBER";
    public static final String ADDRESS = "ADDRESS";
    public static final String VOLUNTEEREXP = "VOLUNTEEREXP";
    public static final String MEDICAL_ISSUE = "MEDICAL_ISSUE";
    public static final String MEDICAL_DATA = "MEDICAL_DATA";
    public static final String DATE = "DATE";
    public static final String EVENTNAME = "EVENTNAME";
    public static final String EVENTPLACE = "EVENTPLACE";
    public String storedEmail=null;
    static final int DATABASE_VERSION = 2;
    public Integer medData;
    public Integer dateData;
    public String medDataValue;
    public String dateDataValue;
    public Integer eventNameData;
    public String eventNameValue;
    public Integer eventPlaceData;
    public String eventPlaceValue;
    PopulateTable populateTable;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 6);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,EMAIL TEXT,PASSWORD TEXT)");
        db.execSQL("create table " + TABLE_NAME_USER +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,SECONDNAME TEXT,PHONENUMBER TEXT,ADDRESS TEXT,VOLUNTEEREXP TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
       // db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_USER);
       // newVersion=DATABASE_VERSION;

         //   db.execSQL("ALTER TABLE "+TABLE_NAME_USER+" ADD COLUMN EMAIL TEXT");

   //     db.execSQL("create table " + TABLE_NAME_MEDICAL +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,MEDICAL_ISSUE TEXT,MEDICAL_DATA TEXT)");
      //  db.execSQL("create table " + TABLE_NAME_USER +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,SECONDNAME TEXT,PHONENUMBER TEXT,ADDRESS TEXT,VOLUNTEEREXP TEXT,EMAIL TEXT)");

      //  onCreate(db);
/*

        long result=0;
        ContentValues contentValues = new ContentValues();
       String  medicalIssue = "Seasonal Allergy";
       StringBuffer medicalData=new StringBuffer();

         medicalData.append("While the timing and severity of an allergy season vary across the country, the following climate factors also can influence how bad your symptoms might be:");
        medicalData.append("Tree, grass and ragweed pollens thrive during cool nights and warm days.");
        medicalData.append("Molds grow quickly in heat and high humidity.");
        medicalData.append("Pollen levels tend to peak in the morning hours.");
        medicalData.append("Rain washes pollen away, but pollen counts can soar after rainfall.");
        medicalData.append("On a day with no wind, airborne allergens are grounded.");
        medicalData.append("When the day is windy and warm, pollen counts surge.");
        medicalData.append("Moving to another climate to avoid allergies is usually not successful — allergens are virtually everywhere.");
        medicalData.append("contentValues.put(MEDICAL_ISSUE,medicalIssue");
        contentValues.put(MEDICAL_ISSUE,"Seasonal Allergy");
        contentValues.put(MEDICAL_DATA,medicalData.toString());
        result = db.insert(TABLE_NAME_MEDICAL,null,contentValues);
*/

      //  db.execSQL("create table " + TABLE_NAME_VOLUNTEER_RECORDS +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,EMAIL TEXT,EVENTNAME TEXT,EVENTPLACE TEXT)");

      /*  ContentValues contentValues = new ContentValues();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Date date=new Date();
       String newDate=dateFormat.format(date).toString();*/

    }

   public Boolean insertDetails(String email,String password){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=null;
        try{
            res=db.rawQuery("select * from "+ TABLE_NAME + " where "+ EMAIL +" = "+"'" +email+ "'"+"", null);
            storedEmail=email;

        }catch (Exception e){
            e.printStackTrace();
        }

       if(res.getCount() == 0){
           ContentValues contentValues=new ContentValues();
           contentValues.put(EMAIL,email);
           contentValues.put(PASSWORD,password);
           long result = db.insert(TABLE_NAME,null,contentValues);
           if(result == -1){
               return false;
           }else
           {
               return true;
           }

       }else{
           return false;
       }



   }

    public Boolean updateDetails(String nameFirst,String nameLast,String phone,String address,String volExpp,String email){

        SQLiteDatabase db = this.getWritableDatabase();
        long result='0';
      //  db.execSQL("create table " + TABLE_NAME_USER +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,SECONDNAME TEXT,PHONENUMBER TEXT,ADDRESS TEXT, VOLUNTEEREXP TEXT)");
        ContentValues contentValues = new ContentValues();

        contentValues.put(FIRSTNAME,nameFirst);
        contentValues.put(SECONDNAME,nameLast);
        contentValues.put(PHONENUMBER,phone);
        contentValues.put(ADDRESS,address);
        contentValues.put(VOLUNTEEREXP,volExpp);
        contentValues.put(EMAIL,email);

        try{
             result = db.insert(TABLE_NAME_USER,null,contentValues);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result == -1){
            return false;
        }else
        {
            return true;
        }


    }
public Integer emailVerification(String email){
    SQLiteDatabase db=this.getWritableDatabase();
    Cursor res=null;
    int count=0;
    try{
        res=db.rawQuery("select * from "+ TABLE_NAME + " where "+ EMAIL +" = "+"'" +email+ "'"+"", null);

      count=  res.getCount();
    }catch (Exception e){
        e.printStackTrace();
    }
    if((count == -1) || (count == 0)){
        return 1;
    }else{
        return 2;
    }
}

public  Boolean volunteerExpVerification(String email){
    SQLiteDatabase db=this.getWritableDatabase();
    Cursor res=null;
    String response=null;
    try{
        res=db.rawQuery("select * from "+ TABLE_NAME_USER + " where "+ EMAIL +" = "+"'" +email+ "'"+"", null);
        while(res.moveToNext()){
            response=res.getString(5);
        }


    }catch (Exception e){
        e.printStackTrace();
    }
    if(response!=null){
        if(response.equals("Y")){
            return true;
        }else{
            return false;
        }
    }else{
        return false;
    }

}
    public Integer  emailVerificationForUpdatingDetails(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=null;
        int count=0;
        try{
            res=db.rawQuery("select * from "+ TABLE_NAME_USER + " where "+ EMAIL +" = "+"'" +email+ "'"+"", null);

            count=  res.getCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        if((count == -1) || (count == 0)){
            return 1;
        }else{
            return 2;
        }
    }

    public String getQueryResult(String searchText){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=null;
        try {
            res=db.rawQuery("select * from "+ TABLE_NAME_MEDICAL + " where  upper("+MEDICAL_ISSUE+") = "+"upper('" +searchText+ "')"+"", null);

            if(res.moveToNext()){
                medData=res.getColumnIndex("MEDICAL_DATA");
                medDataValue=res.getString(medData);
            }
            if(medDataValue==null){
                medDataValue="No Data Found";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
            return medDataValue;
    }

    public Boolean  insertVolunteerData(String input1,String input2,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        long result='0';
        ContentValues contentValues = new ContentValues();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Date date=new Date();
        String newDate=dateFormat.format(date).toString();
        contentValues.put(DATE,newDate);
        contentValues.put(EMAIL,email);
        contentValues.put(EVENTNAME,input2);
        contentValues.put(EVENTPLACE,input1);

        try{
            result = db.insert(TABLE_NAME_VOLUNTEER_RECORDS,null,contentValues);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result == -1){
            return false;
        }else
        {
            return true;
        }
    }

  public  ArrayList<PopulateTable> getAllVolunteerRecords(String email){
      ArrayList<PopulateTable>  populateTable=null;
      SQLiteDatabase db=this.getWritableDatabase();
      PopulateTable populateTable1=new PopulateTable();
      Cursor res=null;
      Integer count=0;
      TrainedUserDetails trainedUserDetails=new TrainedUserDetails();

      try {
          res=db.rawQuery("select * from "+ TABLE_NAME_VOLUNTEER_RECORDS + " where "+ EMAIL+" LIKE "+"'%" +email+ "%'"+"order by "+ID+" desc"+"", null);

          if(res.moveToNext()){
              populateTable=new ArrayList<PopulateTable>();
              dateData=res.getColumnIndex("DATE");
              dateDataValue=res.getString(dateData);
              populateTable1.setDate(dateDataValue);

              eventNameData=res.getColumnIndex("EVENTNAME");
              eventNameValue=res.getString(eventNameData);
              populateTable1.setEventName(eventNameValue);

              eventPlaceData=res.getColumnIndex("EVENTPLACE");
              eventPlaceValue=res.getString(eventPlaceData);
              populateTable1.setEventPlace(eventPlaceValue);
                populateTable.add(populateTable1);


          }
      }catch (Exception e){
          e.printStackTrace();
      }
return populateTable;

  }
}
