package com.example.yogurt.sqllitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MyDatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper=new MyDatabaseHelper(this,"BookStore.db",null,4);
        Button create_database= (Button) findViewById(R.id.create_table);
        Button add_data= (Button) findViewById(R.id.add_data);
        Button select_data= (Button) findViewById(R.id.select_data);
        Button update_data= (Button) findViewById(R.id.update_data);
        Button delete_data= (Button) findViewById(R.id.delete_data);

        create_database.setOnClickListener(this);
        add_data.setOnClickListener(this);
        select_data.setOnClickListener(this);
        update_data.setOnClickListener(this);
        delete_data.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final String TAG="MainActivity";
        SQLiteDatabase database=databaseHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        switch (v.getId()){
            case  R.id.create_table:
                databaseHelper.getWritableDatabase();
                break;
            case R.id.add_data:

                values.clear();
                values.put("name","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",454);
                values.put("price",19.95);
                database.insert("Book",null,values);

                values.clear();
                values.put("name","The Lost Symbol");
                values.put("author","Dan Brown");
                values.put("pages",510);
                values.put("price",19.95);
                database.insert("Book",null,values);


                values.clear();
                values.put("id","1");
                values.put("category_name","ABC");
                values.put("category_code",510);
                database.insert("Category",null,values);
                break;
            case R.id.select_data:

                Cursor cursor=database.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("name"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        int pages=cursor.getInt(cursor.getColumnIndex("pages"));
                        double price=cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d(TAG,"book name is "+name);
                        Log.d(TAG,"book author is "+author);
                        Log.d(TAG,"book page is "+pages);
                        Log.d(TAG,"book price is "+price);
                    }while (cursor.moveToNext());
                }

                cursor=database.query("Category",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        String name=cursor.getString(cursor.getColumnIndex("category_name"));
                        int code=cursor.getInt(cursor.getColumnIndex("category_code"));
                        int id=cursor.getInt(cursor.getColumnIndex("id"));
                        Log.d(TAG,"Category id is "+id);
                        Log.d(TAG,"Category name is "+name);
                        Log.d(TAG,"Category code is "+code);
                    }while (cursor.moveToNext());
                }

                break;
            case R.id.update_data:

                values.clear();
                values.put("price",19.00);
                database.update("Book",values,"name=?",new String[]{"The Da Vinci Code"});
                break;

            case R.id.delete_data:
                database.delete("Book","pages>?",new String[]{"500"});
                break;
        }
    }
}
