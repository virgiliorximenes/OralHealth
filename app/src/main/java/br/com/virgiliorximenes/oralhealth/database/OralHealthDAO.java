package br.com.virgiliorximenes.oralhealth.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by virgilio on 25/09/16.
 */
public class OralHealthDAO {

    private static OralHealthDAO instance;

    private final Context context;
    private OralHealthHelper helper;

    private OralHealthDAO(Context context) {
        this.context = context;

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

    public long insertParent(String cpf) {

        ContentValues values = new ContentValues();
        values.put(OralHealthContract.ParentMetaData._ID, System.currentTimeMillis());
        values.put(OralHealthContract.ParentMetaData.COLUMN_CPF, cpf);

        try (SQLiteDatabase connection = helper.getWritableDatabase()) {
            return connection.insert(OralHealthContract.ParentMetaData.TABLE_NAME, null, values);

        }
    }

    public boolean hasParent() {
        try (SQLiteDatabase connection = helper.getReadableDatabase()) {
            Cursor cursor = connection.rawQuery("SELECT COUNT(*) FROM " + OralHealthContract.ParentMetaData.TABLE_NAME, null);
            cursor.moveToFirst();
            return cursor.getInt(0) != 0;

        }
    }

    public long insertChild(String name) {
        ContentValues values = new ContentValues();
        values.put(OralHealthContract.ChildMetaData._ID, System.currentTimeMillis());
        values.put(OralHealthContract.ChildMetaData.COLUMN_NAME, name);
        values.put(OralHealthContract.ChildMetaData.COLUMN_SCORE, 0);

        try (SQLiteDatabase connection = helper.getWritableDatabase()) {
            return connection.insert(OralHealthContract.ChildMetaData.TABLE_NAME, null, values);

        }
    }
}
