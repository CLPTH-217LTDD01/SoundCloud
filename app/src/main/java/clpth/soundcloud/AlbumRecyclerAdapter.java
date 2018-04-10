package clpth.soundcloud;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumRecyclerAdapter extends RecyclerView.Adapter<AlbumRecyclerAdapter.ViewHolder> {

    private ArrayList<Album> albums = new ArrayList<>();

    public AlbumRecyclerAdapter(ArrayList<Album> playlists) {
        this.albums = playlists;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.album_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.image.setImageResource(albums.get(position).getImage());
        holder.tvName.setText(albums.get(position).getName());
        holder.tvArtist.setText(albums.get(position).getArtist());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int image = albums.get(position).getImage();
                String name = albums.get(position).getName();
                String artist = albums.get(position).getArtist();
                Intent intent = new Intent(view.getContext(), PlaylistActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("img", image);
                bundle.putString("name", name);
                bundle.putString("artist", artist);
                intent.putExtra("bundle", bundle);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView tvName;
        public TextView tvArtist;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvArtist = (TextView) itemView.findViewById(R.id.tvArtist);
        }
    }
}
