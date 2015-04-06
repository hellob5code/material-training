package fr.erictruong.training.material.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {

    private int id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private Long fromDate;
    private Long toDate;

    public Event(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {

        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
