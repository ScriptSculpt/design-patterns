package practice.musicPlayer.strategy;

import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song nextSong();
    Song previousSong();
    Boolean hasNext();
    Boolean hasPrevious();
    void playSong(Song song);
}
