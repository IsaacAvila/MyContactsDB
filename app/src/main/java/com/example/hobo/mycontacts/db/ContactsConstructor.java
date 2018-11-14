package com.example.hobo.mycontacts.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.hobo.mycontacts.R;
import com.example.hobo.mycontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/17/2017.
 */

public class ContactsConstructor {

    private static final int LIKE = 1;
    private Context context;
    public ContactsConstructor(Context context) {
        this.context = context;
    }

    public ArrayList<Contact> getData() {

        DataBase db = new DataBase(context);
        insertContacts(db);
        return db.getContacts();
    }

    public void insertContacts(DataBase db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseConstants.TABLE_CONTACTS_NAME, "Jochos");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHONE, "3121221212");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_EMAIL, "jsho@blbbl.com");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHOTO, R.drawable.profile);
        db.insertContact(contentValues);
        contentValues.clear();

        contentValues.put(DataBaseConstants.TABLE_CONTACTS_NAME, "Juan");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHONE, "3121221212");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_EMAIL, "jsho@blbbl.com");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHOTO, R.drawable.profile2);
        db.insertContact(contentValues);
        contentValues.clear();

        contentValues.put(DataBaseConstants.TABLE_CONTACTS_NAME, "Salcedo");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHONE, "3121221212");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_EMAIL, "jsho@blbbl.com");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHOTO, R.drawable.profile3);
        db.insertContact(contentValues);
        contentValues.clear();

        contentValues.put(DataBaseConstants.TABLE_CONTACTS_NAME, "Maria");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHONE, "3121221212");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_EMAIL, "jsho@blbbl.com");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHOTO, R.drawable.profile4);
        db.insertContact(contentValues);
        contentValues.clear();

        contentValues.put(DataBaseConstants.TABLE_CONTACTS_NAME, "Gpe");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHONE, "3121221212");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_EMAIL, "jsho@blbbl.com");
        contentValues.put(DataBaseConstants.TABLE_CONTACTS_PHOTO, R.drawable.profile5);
        db.insertContact(contentValues);
        contentValues.clear();
    }

    public void likeToContact(Contact contact) {
        DataBase db = new DataBase(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseConstants.TABLE_LIKES_ID_CONTACT, contact.getId());
        contentValues.put(DataBaseConstants.TABLE_LIKES_QUANTITY, LIKE);
        db.insertLike(contentValues);
    }

    public int likesFromContact(Contact contact) {
        DataBase db = new DataBase(context);
        return db.getQuantityLikesFromContact(contact);
    }
}
