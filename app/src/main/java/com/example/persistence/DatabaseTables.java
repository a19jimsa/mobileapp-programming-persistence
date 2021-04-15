package com.example.persistence;

class DatabaseTables {

    static class Fish {

        static final String TABLE_NAME = "fish";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_WIDTH = "width";
        static final String COLUMN_NAME_LOCATION = "location";
    }

    static final String SQL_CREATE_TABLE_FISH =
            // "CREATE TABLE mountain (id INTEGER PRIMARY KEY, name TEXT, height INT)"
            "CREATE TABLE " + Fish.TABLE_NAME + " (" +
                    Fish.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Fish.COLUMN_NAME_NAME + " TEXT," +
                    Fish.COLUMN_NAME_WIDTH + " INT," +
                    Fish.COLUMN_NAME_LOCATION + " TEXT)";

    static final String SQL_DELETE_TABLE_FISH =
            // "DROP TABLE IF EXISTS mountain"
            "DROP TABLE IF EXISTS " + Fish.TABLE_NAME;

}
