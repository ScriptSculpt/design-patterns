package practice.musicPlayer.strategy;

import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;

public class SequentialPlayStrategy implements PlayStrategy {
    private Playlist playlist;
    int currentSongIndex;
    Song currentSong;

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.currentSongIndex = 0;
    }

    @Override
    public Song nextSong() {
        if (playlist != null && currentSongIndex < playlist.getSongs().size()) {
            currentSong = playlist.getSongs().get(currentSongIndex++);
            return currentSong;
        }
        return null;
    }

    @Override
    public Song previousSong() {
        if (playlist != null && currentSongIndex > 0) {
            currentSong = playlist.getSongs().get(--currentSongIndex);
            return currentSong;
        }
        return null;
    }

    @Override
    public void playSong(Song song) {
        if (playlist != null && playlist.getSongs().contains(song)) {
            currentSong = song;
            System.out.println("Playing song in sequential mode: " + song.getTitle());
            currentSongIndex = playlist.getSongs().indexOf(song) + 1; // Move to the next song
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }

    @Override
    public Boolean hasNext() {
        return playlist != null && currentSongIndex < playlist.getSongs().size();
    }

    @Override
    public Boolean hasPrevious() {
        return playlist != null && currentSongIndex > 0;
    }
    
}
