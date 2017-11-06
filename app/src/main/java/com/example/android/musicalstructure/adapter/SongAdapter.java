package com.example.android.musicalstructure.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.musicalstructure.R;
import com.example.android.musicalstructure.SongDetailsActivity;
import com.example.android.musicalstructure.data.Song;

import java.util.ArrayList;

/**
 * Handles the list of songs to be displayed in a {@link SongDetailsActivity}.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter (Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_list_item, parent, false);
        }

        final Song song = getItem(position);
        ImageView albumImage = convertView.findViewById(R.id.album_image);
        TextView songTitle = convertView.findViewById(R.id.song_title);
        TextView artistName = convertView.findViewById(R.id.artist_name);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            albumImage.setImageDrawable(convertView.getResources().getDrawable(song.getAlbumImageId(), getContext().getTheme()));
        } else {
            albumImage.setImageDrawable(convertView.getResources().getDrawable(song.getAlbumImageId()));
        }

        songTitle.setText(song.getName());
        artistName.setText(song.getArtist());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SongDetailsActivity.class);
                intent.putExtra("song", song);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
