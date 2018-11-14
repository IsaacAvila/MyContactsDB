package com.example.hobo.mycontacts.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hobo.mycontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/17/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, DataBaseConstants.DATABASE_NAME, null, DataBaseConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE " + DataBaseConstants.TABLE_CONTACTS + "(" +
                DataBaseConstants.TABLE_CONTACTS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataBaseConstants.TABLE_CONTACTS_NAME    + " TEXT, " +
                DataBaseConstants.TABLE_CONTACTS_PHONE   + " TEXT, " +
                DataBaseConstants.TABLE_CONTACTS_EMAIL   + " TEXT, " +
                DataBaseConstants.TABLE_CONTACTS_PHOTO   + ");"
        );

        db.execSQL(
                "CREATE TABLE " + DataBaseConstants.TABLE_LIKES + "(" +
                DataBaseConstants.TABLE_LIKES_ID         + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataBaseConstants.TABLE_LIKES_ID_CONTACT + " INTEGER, " +
                DataBaseConstants.TABLE_LIKES_QUANTITY   + " INTEGER, " +
                "FOREIGN KEY (" + DataBaseConstants.TABLE_LIKES_ID_CONTACT + ") " +
                "REFERENCES " + DataBaseConstants.TABLE_CONTACTS + " (" + DataBaseConstants.TABLE_CONTACTS_ID + ")" + ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + DataBaseConstants.TABLE_LIKES);
        db.execSQL("DROP TABLE IF EXIST " + DataBaseConstants.TABLE_CONTACTS);
        onCreate(db);
    }

    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor records = db.rawQuery("SELECT * FROM " + DataBaseConstants.TABLE_CONTACTS, null);

        while (records.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(records.getInt(0));
            contact.setName(records.getString(1));
            contact.setPhone(records.getString(2));
            contact.setEmail(records.getString(3));
            contact.setPhoto(records.getInt(4));

            contacts.add(contact);
        }
        db.close();
        return contacts;
    }

    public void insertContact(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DataBaseConstants.TABLE_CONTACTS, null, contentValues);
        db.close();
    }

    public void insertLike(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DataBaseConstants.TABLE_LIKES, null, contentValues);
        db.close();
    }

    public int getQuantityLikesFromContact(Contact contact) {
        int likes = 0;

        String query = "SELECT COUNT("+ DataBaseConstants.TABLE_LIKES_QUANTITY + ")" +
                " FROM " + DataBaseConstants.TABLE_LIKES +
                " WHERE " + DataBaseConstants.TABLE_LIKES_ID_CONTACT + " = " + contact.getId();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToNext())
            likes = cursor.getInt(0);

        db.close();
        return likes;
    }

}
