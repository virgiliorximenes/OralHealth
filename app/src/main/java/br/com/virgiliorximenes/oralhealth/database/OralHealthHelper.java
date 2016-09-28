package br.com.virgiliorximenes.oralhealth.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by virgilio on 25/09/16.
 */
public class OralHealthHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "OralHealth.db";

    public OralHealthHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(OralHealthContract.ParentMetaData.SQL_CREATE_TABLE);
        sqLiteDatabase.execSQL(OralHealthContract.ChildMetaData.SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(OralHealthContract.ParentMetaData.SQL_DROP_TABLE);
        sqLiteDatabase.execSQL(OralHealthContract.ChildMetaData.SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

}
