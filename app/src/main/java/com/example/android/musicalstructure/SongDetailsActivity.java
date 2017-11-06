package com.example.android.musicalstructure;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.musicalstructure.data.Song;
import com.example.android.musicalstructure.databinding.ActivitySongDetailsBinding;

public class SongDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySongDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_song_details);

        Song song = getIntent().getParcelableExtra("song");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.songDetails.albumImage.setImageDrawable(getResources().getDrawable(song.getAlbumImageId(), getTheme()));
        } else {
            binding.songDetails.albumImage.setImageDrawable(getResources().getDrawable(song.getAlbumImageId()));
        }

        binding.songDetails.songTitle.setText(song.getName());
        binding.songDetails.artistName.setText(song.getArtist());
    }
}
