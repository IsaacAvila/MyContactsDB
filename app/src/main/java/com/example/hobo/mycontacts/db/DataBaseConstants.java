package com.example.hobo.mycontacts.db;

/**
 * Created by Caleb on 7/17/2017.
 */

public final class DataBaseConstants {
    public static final String DATABASE_NAME = "contacts";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS       = "contacts";
    public static final String TABLE_CONTACTS_ID    = "id";
    public static final String TABLE_CONTACTS_NAME  = "name";
    public static final String TABLE_CONTACTS_PHONE = "phone";
    public static final String TABLE_CONTACTS_EMAIL = "email";
    public static final String TABLE_CONTACTS_PHOTO = "photo";

    public static final String TABLE_LIKES            = "likes";
    public static final String TABLE_LIKES_ID         = "id";
    public static final String TABLE_LIKES_ID_CONTACT = "id_contact";
    public static final String TABLE_LIKES_QUANTITY   = "quantity";
}
