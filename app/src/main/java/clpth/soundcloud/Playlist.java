package clpth.soundcloud;

public class Playlist {
    private int image;
    private String name;
    private String artist;

    public Playlist(int image, String name, String artist) {
        this.image = image;
        this.name = name;
        this.artist = artist;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
