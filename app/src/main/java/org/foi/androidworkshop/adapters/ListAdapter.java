package org.foi.androidworkshop.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.foi.androidworkshop.R;
import org.foi.androidworkshop.models.MusicAlbum;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    List<MusicAlbum> musicAlbums;

    public ListAdapter(List<MusicAlbum> musicAlbums) {
        this.musicAlbums = musicAlbums;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        holder.tvArtist.setText(musicAlbums.get(position).getArtist());
        holder.tvAlbum.setText(musicAlbums.get(position).getAlbum());
        holder.tvYear.setText(musicAlbums.get(position).getYear() + "");
    }

    @Override
    public int getItemCount() {
        return musicAlbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvArtist;
        private TextView tvAlbum;
        private TextView tvYear;

        public ViewHolder(View itemView) {
            super(itemView);

            tvArtist = (TextView) itemView.findViewById(R.id.tvArtist);
            tvAlbum = (TextView) itemView.findViewById(R.id.tvAlbum);
            tvYear = (TextView) itemView.findViewById(R.id.tvYear);
        }
    }
}
