package clpth.soundcloud;

public class Category {
    private String title;
    private String hint;
    private AlbumRecyclerAdapter albumRecyclerAdapter;

    public Category(String title, String hint) {
        this.title = title;
        this.hint = hint;
    }

    public Category(String title, String hint, AlbumRecyclerAdapter albumRecyclerAdapter) {
        this.title = title;
        this.hint = hint;
        this.albumRecyclerAdapter = albumRecyclerAdapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public AlbumRecyclerAdapter getAlbumRecyclerAdapter() {
        return albumRecyclerAdapter;
    }

    public void setAlbumRecyclerAdapter(AlbumRecyclerAdapter albumRecyclerAdapter) {
        this.albumRecyclerAdapter = albumRecyclerAdapter;
    }
}
