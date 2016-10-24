package br.com.virgiliorximenes.oralhealth.database;

import android.provider.BaseColumns;

/**
 * Created by virgilio on 25/09/16.
 */
public class OralHealthContract {

    private static final String TEXT_DATA_TYPE = "TEXT";
    private static final String INTEGER_DATA_TYPE = "INTEGER";

    private OralHealthContract() {
    }

    public static class ParentMetaData implements BaseColumns {
        public static final String TABLE_NAME = "RESPONSAVEL";

        public static final String COLUMN_CPF = "CPF";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + ParentMetaData.TABLE_NAME + " ("
                + ParentMetaData._ID + " " + INTEGER_DATA_TYPE + " PRIMARY KEY, "
                + ParentMetaData.COLUMN_CPF + " " + TEXT_DATA_TYPE + ")";

        public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ParentMetaData.TABLE_NAME;
    }

    public static class ChildMetaData implements BaseColumns {
        public static final String TABLE_NAME = "FILHO";

        public static final String COLUMN_NAME = "NOME";
        public static final String COLUMN_GENDER = "GENERO";
        public static final String COLUMN_PHASE = "FASE";
        public static final String COLUMN_SCORE = "PONTOS";
        public static final String COLUMN_DAYS_LEFT = "DIAS_REST";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + ChildMetaData.TABLE_NAME + " ("
                + ChildMetaData._ID + " " + INTEGER_DATA_TYPE + " PRIMARY KEY, "
                + ChildMetaData.COLUMN_NAME + " " + TEXT_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_GENDER + " " + TEXT_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_SCORE + " " + INTEGER_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_PHASE + " " + INTEGER_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_DAYS_LEFT + " " + INTEGER_DATA_TYPE + ")";

        public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ChildMetaData.TABLE_NAME;
    }

}
