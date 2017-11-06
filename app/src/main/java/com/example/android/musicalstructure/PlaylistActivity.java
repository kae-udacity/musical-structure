package com.example.android.musicalstructure;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.android.musicalstructure.adapter.SongAdapter;
import com.example.android.musicalstructure.data.Song;
import com.example.android.musicalstructure.databinding.ActivityPlaylistBinding;

import java.util.ArrayList;
import java.util.Random;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlaylistBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_playlist);
        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song (getString(R.string.tainted_love), getString(R.string.soft_cell), R.drawable.music_note));
        songs.add(new Song (getString(R.string.everybody_wants_to_rule_the_world), getString(R.string.tears_for_fears), R.drawable.music_note));
        songs.add(new Song (getString(R.string.vienna), getString(R.string.ultravox), R.drawable.music_note));
        songs.add(new Song (getString(R.string.slip_away), getString(R.string.perfume_genius), R.drawable.music_note));
        songs.add(new Song (getString(R.string.cherry), getString(R.string.chromatics), R.drawable.music_note));
        songs.add(new Song (getString(R.string.best_to_you), getString(R.string.blood_orange), R.drawable.music_note));
        songs.add(new Song (getString(R.string.bruises), getString(R.string.chairlift), R.drawable.music_note));
        songs.add(new Song (getString(R.string.rill_rill), getString(R.string.sleigh_bells), R.drawable.music_note));

        SongAdapter adapter = new SongAdapter(this, songs);
        binding.list.setAdapter(adapter);

        binding.nowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = new Random().nextInt(songs.size());
                Song song = songs.get(index);
                Intent intent = new Intent(PlaylistActivity.this, NowPlayingActivity.class);
                intent.putExtra(getString(R.string.song), song);
                startActivity(intent);
            }
        });
    }
}
