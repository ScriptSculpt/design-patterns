package practice.musicPlayer.strategy;

import java.util.Stack;

import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;

public class CustomPlayStrategy implements PlayStrategy {
    private Playlist playlist;
    private int currentSongIndex;
    private Song currentSong;
    private Stack<Integer> playedIndices = new Stack<>();

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.currentSongIndex = 0;
    }

    @Override
    public Song nextSong() {
        if (playlist != null && currentSongIndex < playlist.getSongs().size()) {
            currentSong = playlist.getSongs().get(currentSongIndex);
            playedIndices.push(currentSongIndex);
            currentSongIndex++;
            return currentSong;
        }
        return null;
    }

    @Override
    public Song previousSong() {
        if (playlist == null || playedIndices.isEmpty()) {
            return null;
        }
        if (playedIndices.size() == 1) {
            // only current song in history, no previous
            return null;
        }
        // remove the current index
        playedIndices.pop();
        // peek previous index
        int previousIndex = playedIndices.peek();
        currentSongIndex = previousIndex + 1;
        currentSong = playlist.getSongs().get(previousIndex);
        return currentSong;
        
    }

    @Override
    public Boolean hasNext() {
        if (playlist != null && currentSongIndex < playlist.getSongs().size()) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean hasPrevious() {
        return playlist != null && playedIndices.size() > 1;
    }

    @Override
    public void playSong(Song song) {
        if (playlist != null && playlist.getSongs().contains(song)) {
            currentSong = song;
            System.out.println("Playing song in custom mode: " + song.getTitle());
            int index = playlist.getSongs().indexOf(song);
            playedIndices.push(index);
            currentSongIndex = index + 1; // Move to the next song
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }
}
