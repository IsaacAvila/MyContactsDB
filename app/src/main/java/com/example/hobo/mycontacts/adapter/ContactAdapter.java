package com.example.hobo.mycontacts.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hobo.mycontacts.db.ContactsConstructor;
import com.example.hobo.mycontacts.pojo.Contact;
import com.example.hobo.mycontacts.ContactDetail;
import com.example.hobo.mycontacts.R;

import java.util.ArrayList;

/**
 * Created by Caleb on 7/7/2017.
 */

public class ContactAdapter extends  RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    ArrayList<Contact> contacts;
    Activity activity;

    public ContactAdapter(ArrayList<Contact> contacts, Activity activity) {
        this.contacts = contacts;
        this.activity = activity;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contact, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position) {
        final ContactsConstructor contactsConstructor = new ContactsConstructor(activity);
        final Contact contact = contacts.get(position);
        holder.ivPhotoCV.setImageResource(contact.getPhoto());
        holder.tvNameCV.setText(contact.getName());
        holder.tvPhoneCV.setText(contact.getPhone());
        String likesText = contactsConstructor.likesFromContact(contact) + " Likes";
        holder.tvLikes.setText(likesText);

        holder.ivPhotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show = new Intent(activity, ContactDetail.class);
                show.putExtra("name", contact.getName());
                show.putExtra("phone", contact.getPhone());
                show.putExtra("email", contact.getEmail());
                activity.startActivity(show);
            }
        });

        holder.ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "You like " + contact.getName(), Toast.LENGTH_SHORT).show();
                contactsConstructor.likeToContact(contact);
                String likes = contactsConstructor.likesFromContact(contact) + " Likes";
                holder.tvLikes.setText(likes);
            }
        });

        //For set a context menu
        activity.registerForContextMenu(holder.ivPhotoCV);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView   ivPhotoCV;
        private TextView    tvNameCV, tvPhoneCV, tvLikes;
        private ImageButton ibLike;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivPhotoCV = (ImageView)   itemView.findViewById(R.id.ivPhotoCV);
            tvNameCV  = (TextView)    itemView.findViewById(R.id.tvNameCV);
            tvPhoneCV = (TextView)    itemView.findViewById(R.id.tvPhoneCV);
            ibLike    = (ImageButton) itemView.findViewById(R.id.ibLike);
            tvLikes   = (TextView)    itemView.findViewById(R.id.tvLikes);
        }
    }
}
