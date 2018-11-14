package com.example.hobo.mycontacts.Presenter;

import android.content.Context;

import com.example.hobo.mycontacts.db.ContactsConstructor;
import com.example.hobo.mycontacts.fragment.FragmentRecyclerView;
import com.example.hobo.mycontacts.fragment.IFragmentRecyclerViewView;
import com.example.hobo.mycontacts.pojo.Contact;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/17/2017.
 */

public class FragmentRecycleViewPresenter implements IFragmentRecyclerViewPresenter {

    private IFragmentRecyclerViewView iFragmentRecyclerViewView;
    private Context context;
    private ContactsConstructor contactsConstructor;
    private ArrayList<Contact> contacts;

    public FragmentRecycleViewPresenter(IFragmentRecyclerViewView iFragmentRecyclerView, Context context) {
        this.iFragmentRecyclerViewView = iFragmentRecyclerView;
        this.context = context;
        getContacts();
    }


    @Override
    public void getContacts() {
        contactsConstructor = new ContactsConstructor(context);
        contacts = contactsConstructor.getData();
        showContacts();
    }

    @Override
    public void showContacts() {
        iFragmentRecyclerViewView.startAdapter(iFragmentRecyclerViewView.createAdapter(contacts));
        iFragmentRecyclerViewView.generateLinerLayoutVertical();
    }
}
