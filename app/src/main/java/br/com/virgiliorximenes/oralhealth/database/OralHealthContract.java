package br.com.virgiliorximenes.oralhealth.database;

import android.provider.BaseColumns;

class OralHealthContract {

    private static final String TEXT_DATA_TYPE = "TEXT";
    private static final String INTEGER_DATA_TYPE = "INTEGER";

    private OralHealthContract() {
    }

    static class ParentMetaData implements BaseColumns {
        static final String TABLE_NAME = "RESPONSAVEL";

        static final String COLUMN_CPF = "CPF";

        static final String SQL_CREATE_TABLE = "CREATE TABLE " + ParentMetaData.TABLE_NAME + " ("
                + ParentMetaData._ID + " " + INTEGER_DATA_TYPE + " PRIMARY KEY, "
                + ParentMetaData.COLUMN_CPF + " " + TEXT_DATA_TYPE + ")";

        static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ParentMetaData.TABLE_NAME;
    }

    static class ChildMetaData implements BaseColumns {
        static final String TABLE_NAME = "FILHO";

        static final String COLUMN_NAME = "NOME";
        static final String COLUMN_GENDER = "GENERO";
        static final String COLUMN_PHASE = "FASE";
        static final String COLUMN_SCORE = "PONTOS";
        static final String COLUMN_DAYS_LEFT = "DIAS_REST";

        static final String SQL_CREATE_TABLE = "CREATE TABLE " + ChildMetaData.TABLE_NAME + " ("
                + ChildMetaData._ID + " " + INTEGER_DATA_TYPE + " PRIMARY KEY, "
                + ChildMetaData.COLUMN_NAME + " " + TEXT_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_GENDER + " " + TEXT_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_SCORE + " " + INTEGER_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_PHASE + " " + INTEGER_DATA_TYPE + ", "
                + ChildMetaData.COLUMN_DAYS_LEFT + " " + INTEGER_DATA_TYPE + ")";

        static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ChildMetaData.TABLE_NAME;
    }

}
