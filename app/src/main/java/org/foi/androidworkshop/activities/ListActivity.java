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
        recyclerView.setAdapter(new ListAdapter(musicAlbums));
    }

    private List<MusicAlbum> generateListData() {
        List<MusicAlbum> ret = new ArrayList<>();

        ret.add(new MusicAlbum("Incubus", "Fungus Amongus", 1995));
        ret.add(new MusicAlbum("Incubus", "S.C.I.E.N.C.E.", 1997));
        ret.add(new MusicAlbum("Incubus", "Make Yourself", 1999));
        ret.add(new MusicAlbum("Incubus", "Morning View", 2001));
        ret.add(new MusicAlbum("Incubus", "A Crow Left After the Murder", 2004));
        ret.add(new MusicAlbum("Incubus", "Light Grenades", 2006));
        ret.add(new MusicAlbum("Incubus", "If Not Now, When?", 2011));

        return ret;
    }
}
