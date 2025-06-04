package com.example.book_app_athul.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String id;
    private String title;
    private String author;
    private String description;
    private float rating;
    private String thumbnailUrl; // For placeholder, could be a local drawable name

    public Book(String id, String title, String author, String description, float rating, String thumbnailUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.rating = rating;
        this.thumbnailUrl = thumbnailUrl;
    }

    protected Book(Parcel in) {
        id = in.readString();
        title = in.readString();
        author = in.readString();
        description = in.readString();
        rating = in.readFloat();
        thumbnailUrl = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(description);
        dest.writeFloat(rating);
        dest.writeString(thumbnailUrl);
    }
}