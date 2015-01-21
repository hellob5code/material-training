package com.training.android.material.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Application implements Parcelable {

    private int id;
    private String title;
    private String formattedPrice;
    private String formattedLocation;
    private String description;

    private int price;
    private double latitude;
    private double longitude;

    public Application(Parcel in) {
        this.title = in.readString();
        this.price = in.readInt();
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
        this.description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeInt(this.price);
        dest.writeDouble(this.latitude);
        dest.writeDouble(this.longitude);
        dest.writeString(this.description);
    }

    public static final Parcelable.Creator<Application> CREATOR = new Parcelable.Creator<Application>() {

        @Override
        public Application createFromParcel(Parcel source) {
            return new Application(source);
        }

        @Override
        public Application[] newArray(int size) {
            return new Application[size];
        }
    };
}
