package br.com.virgiliorximenes.oralhealth.database;

import android.provider.BaseColumns;

/**
 * Created by virgilio on 25/09/16.
 */
public class OralHealthContract {

    private static final String TEXT_DATATYPE = "TEXT";
    private static final String INTEGER_DATATYPE = "INTEGER";

    private OralHealthContract() {
    }

    public static class ParentMetaData implements BaseColumns {
        public static final String TABLE_NAME = "RESPONSAVEL";

        public static final String COLUMN_CPF = "CPF";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + ParentMetaData.TABLE_NAME + " ("
                + ParentMetaData._ID + " " + INTEGER_DATATYPE + " PRIMARY KEY, "
                + ParentMetaData.COLUMN_CPF + " " + TEXT_DATATYPE + ")";

        public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ParentMetaData.TABLE_NAME;
    }

    public static class ChildMetaData implements BaseColumns {
        public static final String TABLE_NAME = "FILHO";

        public static final String COLUMN_NAME = "NOME";
        public static final String COLUMN_PHASE = "FASE";
        public static final String COLUMN_SCORE = "PONTOS";

        public static final String SQL_CREATE_TABLE = "CREATE TABLE " + ChildMetaData.TABLE_NAME + " ("
                + ChildMetaData._ID + " " + INTEGER_DATATYPE + " PRIMARY KEY, "
                + ChildMetaData.COLUMN_NAME + " " + TEXT_DATATYPE + ", "
                + ChildMetaData.COLUMN_SCORE + " " + INTEGER_DATATYPE + ", "
                + ChildMetaData.COLUMN_PHASE + " " + INTEGER_DATATYPE + ")";

        public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ChildMetaData.TABLE_NAME;
    }

}
