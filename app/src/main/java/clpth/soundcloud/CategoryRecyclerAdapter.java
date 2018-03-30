package clpth.soundcloud;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private ArrayList<Category> categories = new ArrayList<>();

    public CategoryRecyclerAdapter(ArrayList<Category> categories){
        this.categories = categories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.category_item_layout, parent, false);
        RecyclerView horizontal = (RecyclerView) itemView.findViewById(R.id.rvPlaylist);
        horizontal.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayout.HORIZONTAL, false));
        horizontal.addItemDecoration(new PlaylistItemDecoration(22));
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvTitle.setText(categories.get(position).getTitle());
        holder.tvHint.setText(categories.get(position).getHint());
        holder.rvPlaylist.setAdapter(categories.get(position).getPlaylistRecyclerAdapter());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
