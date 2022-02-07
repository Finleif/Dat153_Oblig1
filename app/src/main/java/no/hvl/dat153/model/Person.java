package no.hvl.dat153.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String name;
    private Uri path;


    public Person() {
    }

    public Person(String name, Uri path) {
        this.name = name;
        this.path = path;
    }

    protected Person(Parcel in) {
        name = in.readString();
        path = Uri.parse(in.readString());
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getPath() {
        return path;
    }

    public void setPath(Uri path) {
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(String.valueOf(path));
    }
}
