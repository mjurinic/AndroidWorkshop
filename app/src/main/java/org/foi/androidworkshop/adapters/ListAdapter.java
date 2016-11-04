package org.foi.androidworkshop.adapters;

import org.foi.androidworkshop.R;
import org.foi.androidworkshop.models.MusicAlbum;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<MusicAlbum> musicAlbums;
    private Context context;

    public ListAdapter(List<MusicAlbum> musicAlbums, Context context) {
        this.musicAlbums = musicAlbums;
        this.context = context;
    }

    // Creates new views that will be invoked by the LayoutManager
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // It is crucial to set "attachToRoot" to false because the LayoutManager
        // will decide when to attach the inflated layout to the root layout.
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    // "holder" is the view at the i-th (position) position on the screen.
    // Whenever a view gets invoked by the LayoutManager, set the right content,
    // e.g. i-th view should have i-th data from the dataset.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        Glide.with(context)
//                .load(musicAlbums.get(position).getAlbumArtUrl())
//                .into(holder.ivAlbumArt);

        holder.ivAlbumArt.setImageResource(R.mipmap.ic_launcher);
        holder.tvArtist.setText(musicAlbums.get(position).getArtist());
        holder.tvAlbum.setText(musicAlbums.get(position).getAlbum());
        holder.tvYear.setText(musicAlbums.get(position).getYear() + "");
    }

    @Override
    public int getItemCount() {
        return musicAlbums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivAlbumArt;
        private TextView tvArtist;
        private TextView tvAlbum;

        //Example with Butterknife usage in RecyclerView.ViewHolder
        @BindView(R.id.tvYear)
        TextView tvYear;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            ivAlbumArt = (ImageView) itemView.findViewById(R.id.ivAlbumArt);
            tvArtist = (TextView) itemView.findViewById(R.id.tvArtist);
            tvAlbum = (TextView) itemView.findViewById(R.id.tvAlbum);
            tvYear = (TextView) itemView.findViewById(R.id.tvYear);
        }
    }
}
