package practice.musicPlayer.strategy;

import java.util.Stack;

import practice.musicPlayer.models.Playlist;
import practice.musicPlayer.models.Song;

public class ShufflePlayStrategy implements PlayStrategy {

    private Playlist playlist;
    private int currentSongIndex;
    private Song currentSong;
    Stack<Integer> playedIndices = new Stack<>();

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        this.currentSongIndex = 0;
    }

    @Override
    public Song nextSong() {
        int nextIndex = (int) (Math.random() * playlist.getSongs().size());
        this.currentSongIndex = nextIndex;
        this.currentSong = playlist.getSongs().get(currentSongIndex);
        playedIndices.push(currentSongIndex);
        return currentSong;
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
        // peek the previous index without removing it from history
        int previousIndex = playedIndices.peek();
        this.currentSongIndex = previousIndex;
        this.currentSong = playlist.getSongs().get(currentSongIndex);
        return currentSong;
    }

    @Override
    public Boolean hasNext() {
        return playlist != null && !playlist.getSongs().isEmpty();
    }

    @Override
    public Boolean hasPrevious() {
        return playedIndices.size() > 1;
    }

    @Override
    public void playSong(Song song) {
        if (playlist != null && playlist.getSongs().contains(song)) {
            currentSong = song;
            System.out.println("Playing song in shuffle mode: " + song.getTitle());
            currentSongIndex = playlist.getSongs().indexOf(song);
            playedIndices.push(currentSongIndex);
        } else {
            System.out.println("Song not found in the playlist.");
        }
    }
}
