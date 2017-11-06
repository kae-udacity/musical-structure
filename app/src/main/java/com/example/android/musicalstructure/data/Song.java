package com.example.android.musicalstructure.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.musicalstructure.NowPlayingActivity;

/**
 * Stores the data for a Song object i.e. the name, artist and album art of the song.
 * Implements parcelable to allow it to be stored in the intent when a
 * {@link NowPlayingActivity} is started.
 */
public class Song implements Parcelable {

    private String mName;
    private String mArtist;
    private int mAlbumImageId;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel parcel) {
            return new Song(parcel);
        }

        @Override
        public Object[] newArray(int i) {
            return new Song[i];
        }
    };

    public Song(String name, String artist, int albumImageId) {
        mName = name;
        mArtist = artist;
        mAlbumImageId = albumImageId;
    }

    public Song(Parcel parcel) {
        mName = parcel.readString();
        mArtist = parcel.readString();
        mAlbumImageId = parcel.readInt();
    }

    public String getName() {
        return mName;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getAlbumImageId() {
        return mAlbumImageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeString(mArtist);
        parcel.writeInt(mAlbumImageId);
    }
}
