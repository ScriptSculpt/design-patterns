package practice.musicPlayer.models;

public class Song {
    private String title;
    private String artist;
    private int duration;
    private String path;

    public Song(String title, String artist, int duration, String path) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public String getPath() {
        return path;
    }
}
