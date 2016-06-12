package com.example.yogurt.databaseprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Yogurt on 4/23/16.
 */
public class DatabaseProvider extends ContentProvider {
    public static final int BOOK_DIR=0;
    public static final int BOOK_ITEM=1;
    public static final int CATEGORY_DIR=2;
    public static final int CATEGORY_ITEM=3;
    public static final String AUTHORITY="com.example.yogurt.sqllitetest.provider";
    private static UriMatcher uriMatcher;
    private static MyDatabaseHelper databaseHelper;

    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"Book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"Book/#",BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY,"Category",CATEGORY_DIR);
        uriMatcher.addURI(AUTHORITY,"Category/#",CATEGORY_ITEM);
    }
    @Override
    public boolean onCreate() {
        databaseHelper=new MyDatabaseHelper(getContext(),"BookStore.db",null,6);
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase database=databaseHelper.getWritableDatabase();
        Cursor cursor=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                cursor=database.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                cursor=database.query("Book",projection,"id=?",new String[]{bookId},null,null,sortOrder);
                break;
            case CATEGORY_DIR:
                cursor=database.query("Category",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case CATEGORY_ITEM:
                String categoryId=uri.getPathSegments().get(1);
                cursor=database.query("Category",projection,"id=?",new String[]{categoryId},null,null,sortOrder);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR: return "vnd.android.cursor.id/com.example.yogurt.sqllitetest.provider.book";
            case BOOK_ITEM:return "vnd.android.cursor.item/com.example.yogurt.sqllitetest.provider.book";
            case CATEGORY_DIR:return "vnd.android.cursor.id/com.example.yogurt.sqllitetest.provider.category";
            case CATEGORY_ITEM:return "vnd.android.cursor.item/com.example.yogurt.sqllitetest.provider.category";
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database=databaseHelper.getWritableDatabase();
        Uri uriReturn=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookId=database.insert("Book",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/book"+newBookId);
                break;
            case CATEGORY_DIR:
            case CATEGORY_ITEM:
                long newCategoryId=database.insert("Category",null,values);
                uriReturn=Uri.parse("content://"+AUTHORITY+"/category"+newCategoryId);
                break;
            default:
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        int deleteRows=0;
        SQLiteDatabase database=databaseHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deleteRows=database.delete("Book",selection,selectionArgs);
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
            case CATEGORY_DIR:
            case CATEGORY_ITEM:

        }
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        SQLiteDatabase database=databaseHelper.getWritableDatabase();
        int updateRows=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updateRows=database.update("Book",values,selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                updateRows=database.update("Book",values,"id=?",new String[]{bookId});
                break;
            case CATEGORY_DIR:
                updateRows=database.update("Category",values,selection,selectionArgs);
                break;
            case CATEGORY_ITEM:
                String categoryId=uri.getPathSegments().get(1);
                updateRows=database.update("Category",values,"id=?",new String[]{categoryId});
                break;
        }
        return updateRows;
    }
}
