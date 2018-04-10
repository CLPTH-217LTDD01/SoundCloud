package clpth.soundcloud;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {

    private ArrayList<Category> categories = new ArrayList<>();

    public CategoryRecyclerAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.category_item_layout, parent, false);
        RecyclerView horizontal = (RecyclerView) itemView.findViewById(R.id.rvAlbum);
        horizontal.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayout.HORIZONTAL, false));
        horizontal.addItemDecoration(new AlbumItemDecoration(22));
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(categories.get(position).getTitle());
        holder.tvHint.setText(categories.get(position).getHint());
        holder.rvPlaylist.setAdapter(categories.get(position).getAlbumRecyclerAdapter());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;
        public TextView tvHint;
        public RecyclerView rvPlaylist;

        public ViewHolder(final View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvHint = (TextView) itemView.findViewById(R.id.tvHint);
            rvPlaylist = (RecyclerView) itemView.findViewById(R.id.rvAlbum);
        }
    }
}
