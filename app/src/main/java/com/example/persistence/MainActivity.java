package com.example.persistence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;
    private List<Fish> fishList;
    private String fishString;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();
        fishList = new ArrayList<>();
        editText = findViewById(R.id.editText);

        Button writeButton = findViewById(R.id.writeButton);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                writeToDatabase();
            }
        });
        Button readButton = findViewById(R.id.readButton);
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readFromDatabase();
            }
        });
    }

    private void readFromDatabase() {
        fishString = "";
        fishList = getFish();
        for(int i = 0; i < fishList.size(); i++){
            fishString += fishList.get(i).toString() +"\n";
        }
        TextView textView = findViewById(R.id.textView);
        textView.setText(fishString);
    }

    private void writeToDatabase(){

    }

    private int deleteMountain(long id) {
        String selection = DatabaseTables.Fish.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        return database.delete(DatabaseTables.Fish.TABLE_NAME, selection, selectionArgs);
    }

    private long addFish(String name, int width, String location) {
        ContentValues values = new ContentValues();
        values.put(DatabaseTables.Fish.COLUMN_NAME_NAME, name);
        values.put(DatabaseTables.Fish.COLUMN_NAME_WIDTH, width);
        values.put(DatabaseTables.Fish.COLUMN_NAME_LOCATION, location);
        return database.insert(DatabaseTables.Fish.TABLE_NAME, null, values);
    }

    private List<Fish> getFish() {
        Cursor cursor = database.query(DatabaseTables.Fish.TABLE_NAME, null, null, null, null, null, null);
        List<Fish> fishList = new ArrayList<>();
        while (cursor.moveToNext()) {
            Fish fish = new Fish(
                    cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseTables.Fish.COLUMN_NAME_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Fish.COLUMN_NAME_NAME)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseTables.Fish.COLUMN_NAME_WIDTH)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseTables.Fish.COLUMN_NAME_LOCATION))
            );
            fishList.add(fish);
        }
        cursor.close();
        return fishList;
    }
}
