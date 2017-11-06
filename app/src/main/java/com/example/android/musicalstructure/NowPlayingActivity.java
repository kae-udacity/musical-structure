package com.example.android.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.musicalstructure.data.Song;
import com.example.android.musicalstructure.databinding.ActivityNowPlayingBinding;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNowPlayingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_now_playing);

        Song song = getIntent().getParcelableExtra(getString(R.string.song));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.songDetails.albumImage.setImageDrawable(getResources().getDrawable(song.getAlbumImageId(), getTheme()));
        } else {
            binding.songDetails.albumImage.setImageDrawable(getResources().getDrawable(song.getAlbumImageId()));
        }

        binding.songDetails.songTitle.setText(song.getName());
        binding.songDetails.artistName.setText(song.getArtist());

        binding.playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NowPlayingActivity.this, PlaylistActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
