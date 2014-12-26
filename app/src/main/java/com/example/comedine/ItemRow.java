package com.example.comedine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abhinavgupta on 20/12/14.
 */
public class ItemRow implements Parcelable {
    private String name;
    private String price;

    public ItemRow(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    protected ItemRow(Parcel in) {
        name = in.readString();
        price = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(price);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ItemRow> CREATOR = new Parcelable.Creator<ItemRow>() {
        @Override
        public ItemRow createFromParcel(Parcel in) {
            return new ItemRow(in);
        }

        @Override
        public ItemRow[] newArray(int size) {
            return new ItemRow[size];
        }
    };
}
