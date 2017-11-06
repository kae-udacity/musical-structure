package com.example.android.musicalstructure;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.musicalstructure.adapter.SongAdapter;
import com.example.android.musicalstructure.data.Song;
import com.example.android.musicalstructure.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song ("Tainted Love", "Soft Cell", R.drawable.soft_cell));
        songs.add(new Song ("Everybody wants to rule the world", "Tears for Fears", R.drawable.tears_for_fears));
        songs.add(new Song ("Vienna", "Ultravox", R.drawable.ultravox));
        songs.add(new Song ("Slip Away", "Perfume Genius", R.drawable.perfume_genius));
        songs.add(new Song ("Cherry", "Chromatics", R.drawable.chromatics));
        songs.add(new Song ("Best to You", "Blood Orange", R.drawable.blood_orange));
        songs.add(new Song ("Bruises", "Chairlift", R.drawable.chairlift));
        songs.add(new Song ("Rill Rill", "Sleigh Bells", R.drawable.sleigh_bells));

        SongAdapter adapter = new SongAdapter(this, songs);
        binding.list.setAdapter(adapter);
    }
}
