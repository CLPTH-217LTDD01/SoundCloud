package clpth.soundcloud;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;
    public TextView tvHint;
    public RecyclerView rvPlaylist;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvHint = (TextView) itemView.findViewById(R.id.tvHint);
        rvPlaylist = (RecyclerView) itemView.findViewById(R.id.rvPlaylist);
    }
}
