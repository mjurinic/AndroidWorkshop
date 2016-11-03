package org.foi.androidworkshop.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.foi.androidworkshop.R;
import org.foi.androidworkshop.adapters.ListAdapter;
import org.foi.androidworkshop.models.MusicAlbum;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private List<MusicAlbum> musicAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        musicAlbums = generateListData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rvListActivity);

        layoutManager = new LinearLayoutManager(getBaseContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ListAdapter(musicAlbums, this));
    }

    private List<MusicAlbum> generateListData() {
        List<MusicAlbum> ret = new ArrayList<>();

        ret.add(new MusicAlbum("https://upload.wikimedia.org/wikipedia/en/9/92/Fungus_amongus.jpg", "Incubus", "Fungus Amongus", 1995));
        ret.add(new MusicAlbum("https://upload.wikimedia.org/wikipedia/en/4/4f/Incubus_Science.jpg", "Incubus", "S.C.I.E.N.C.E.", 1997));
        ret.add(new MusicAlbum("https://upload.wikimedia.org/wikipedia/en/6/68/Incubus_-_Morning_View.jpg", "Incubus", "Morning View", 2001));
        ret.add(new MusicAlbum("https://upload.wikimedia.org/wikipedia/en/8/8d/ACrowLeftoftheMurderIncubus.jpg", "Incubus", "A Crow Left After the Murder", 2004));
        ret.add(new MusicAlbum("https://upload.wikimedia.org/wikipedia/en/0/0f/Incubus_-_Light_Grenades.jpg", "Incubus", "Light Grenades", 2006));
        ret.add(new MusicAlbum("https://upload.wikimedia.org/wikipedia/en/2/22/If_not_now_when_album_cover.jpg", "Incubus", "If Not Now, When?", 2011));

        return ret;
    }
}
