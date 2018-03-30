package clpth.soundcloud;

public class Category {
    private String title;
    private String hint;
    private PlaylistRecyclerAdapter playlistRecyclerAdapter;

    public Category(String title, String hint) {
        this.title = title;
        this.hint = hint;
    }

    public Category(String title, String hint, PlaylistRecyclerAdapter playlistRecyclerAdapter) {
        this.title = title;
        this.hint = hint;
        this.playlistRecyclerAdapter = playlistRecyclerAdapter;
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

    public PlaylistRecyclerAdapter getPlaylistRecyclerAdapter() {
        return playlistRecyclerAdapter;
    }

    public void setPlaylistRecyclerAdapter(PlaylistRecyclerAdapter playlistRecyclerAdapter) {
        this.playlistRecyclerAdapter = playlistRecyclerAdapter;
    }
}
