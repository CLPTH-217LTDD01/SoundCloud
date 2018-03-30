package clpth.soundcloud;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PlaylistRecyclerAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    ArrayList<Playlist> playlists = new ArrayList<>();

    public PlaylistRecyclerAdapter(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.playlist_item_layout, parent, false);
        return new PlaylistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        holder.image.setImageResource(playlists.get(position).getImage());
        holder.tvName.setText(playlists.get(position).getName());
        holder.tvArtist.setText(playlists.get(position).getArtist());
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }
}
