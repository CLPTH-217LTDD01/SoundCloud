package clpth.soundcloud;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class AlbumItemDecoration extends RecyclerView.ItemDecoration {
    private int spacing;

    public AlbumItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildLayoutPosition(view);
        if (position == 0)
            outRect.left = spacing;
    }
}
