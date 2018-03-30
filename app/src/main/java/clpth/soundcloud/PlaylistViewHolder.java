package clpth.soundcloud;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    public ImageView image;
    public TextView tvName;
    public TextView tvArtist;

    public PlaylistViewHolder(View itemView) {
        super(itemView);

        image = (ImageView) itemView.findViewById(R.id.image);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvArtist = (TextView) itemView.findViewById(R.id.tvArtist);
    }
}
