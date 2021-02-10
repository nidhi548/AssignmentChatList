package com.example.assignment.models;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Contact implements Comparable<Contact> {
    private final long mId;
    private int mInVisibleGroup;
    @Nullable
    private String mDisplayName;
    private boolean mStarred;
    @Nullable
    private Uri mPhoto;
    @Nullable
    private Uri mThumbnail;
    @NonNull
    private Set<String> mEmails = new HashSet<>();
    @NonNull
    private Set<String> mPhoneNumbers = new HashSet<>();

    Contact(long id) {
        this.mId = id;
    }

    public long getId() {
        return mId;
    }

    public int getInVisibleGroup() {
        return mInVisibleGroup;
    }

    public void setInVisibleGroup(int inVisibleGroup) {
        mInVisibleGroup = inVisibleGroup;
    }

    @Nullable
    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(@Nullable String displayName) {
        mDisplayName = displayName;
    }

    public boolean isStarred() {
        return mStarred;
    }

    public void setStarred(boolean starred) {
        mStarred = starred;
    }

    @Nullable
    public Uri getPhoto() {
        return mPhoto;
    }

    public void setPhoto(@Nullable Uri photo) {
        mPhoto = photo;
    }

    @Nullable
    public Uri getThumbnail() {
        return mThumbnail;
    }


    public void setThumbnail(@Nullable Uri thumbnail) {
        mThumbnail = thumbnail;
    }

    @NonNull
    public Set<String> getEmails() {
        return mEmails;
    }

    public void setEmails(@NonNull Set<String> emails) {
        mEmails = emails;
    }

    @NonNull
    public Set<String> getPhoneNumbers() {
        return mPhoneNumbers;
    }

    public void setPhoneNumbers(@NonNull Set<String> phoneNumbers) {
        mPhoneNumbers = phoneNumbers;
    }


    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return mId == contact.mId;
    }

    public static int compareTo(ir.mirrajabi.rxcontacts.Contact contact, ir.mirrajabi.rxcontacts.Contact contact1) {
        if (contact.getDisplayName() != null && contact1.getDisplayName() != null) {
            return contact.getDisplayName().compareTo(contact1.getDisplayName());
        }

        return -1;
    }

    @Override
    public int compareTo(Contact other) {
        if (mDisplayName != null && other.mDisplayName != null) {
            return mDisplayName.compareTo(other.mDisplayName);
        }

        return -1;
//        return 0;
    }
}