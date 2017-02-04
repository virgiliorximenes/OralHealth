package br.com.virgiliorximenes.oralhealth.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class OralHealthDAO {

    private static OralHealthDAO instance;

    private final OralHealthHelper helper;

    private OralHealthDAO(Context context) {
        helper = new OralHealthHelper(context);
    }

    public static OralHealthDAO getInstance(Context context) {
        if (instance == null) {
            instance = new OralHealthDAO(context);
        }
        return instance;
    }

    public void close() {
        helper.close();
    }

    public void insertParent(String cpf) {

        ContentValues values = new ContentValues();
        values.put(OralHealthContract.ParentMetaData._ID, System.currentTimeMillis());
        values.put(OralHealthContract.ParentMetaData.COLUMN_CPF, cpf);

        try (SQLiteDatabase connection = helper.getWritableDatabase()) {
            connection.insert(OralHealthContract.ParentMetaData.TABLE_NAME, null, values);
        }
    }

    public boolean hasParent() {
        try (SQLiteDatabase connection = helper.getReadableDatabase();
             Cursor cursor = connection.rawQuery("SELECT COUNT(*) FROM " + OralHealthContract.ParentMetaData.TABLE_NAME, null)) {
            cursor.moveToFirst();
            return cursor.getInt(0) != 0;
        }
    }

    public boolean hasChild() {
        try (SQLiteDatabase connection = helper.getReadableDatabase();
             Cursor cursor = connection.rawQuery("SELECT COUNT(*) FROM " + OralHealthContract.ChildMetaData.TABLE_NAME, null)) {
            cursor.moveToFirst();
            return cursor.getInt(0) != 0;
        }
    }

    public int getActualPhase() {
        String sql = "SELECT " + OralHealthContract.ChildMetaData.COLUMN_PHASE + " FROM " + OralHealthContract.ChildMetaData.TABLE_NAME;

        try (SQLiteDatabase connection = helper.getReadableDatabase();
             Cursor cursor = connection.rawQuery(sql, null)) {

            return cursor.moveToFirst() ? cursor.getInt(0) : 0;
        }
    }

    public void insertChild(String name, String gender) {

        ContentValues values = new ContentValues();
        values.put(OralHealthContract.ChildMetaData._ID, System.currentTimeMillis());
        values.put(OralHealthContract.ChildMetaData.COLUMN_NAME, name);
        values.put(OralHealthContract.ChildMetaData.COLUMN_SCORE, 0);
        values.put(OralHealthContract.ChildMetaData.COLUMN_GENDER, gender);
        values.put(OralHealthContract.ChildMetaData.COLUMN_DAYS_LEFT, 0);
        values.put(OralHealthContract.ChildMetaData.COLUMN_PHASE, 0);

        try (SQLiteDatabase connection = helper.getWritableDatabase()) {
            connection.insert(OralHealthContract.ChildMetaData.TABLE_NAME, null, values);
        }
    }
}
