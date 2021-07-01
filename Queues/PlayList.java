class PlayList {

    private LibraryStringStack history;       // to go back to previous song
    private LibraryQueue playlist;      // to enqueue new songs
    private String current;             // currently playing song

    /**
     * Constructor of the playlist, creates a playlist with the given songs.
     * @param songs - the songs that will be part of this playlist
     */
    public PlayList(String[] songs) {
        this.playlist = new LibraryQueue();
        this.history = new LibraryStringStack();
        this.current = null;
        for (String s : songs) {
            playlist.enqueueBack(s);
        }
    }

    /**
     * Starts playing the first song in the playlist, if no songs was playing yet.
     * @return the first song that will be played if no song was playing, otherwise null
     */
    public String playSong() {
        if (current == null) {
            current = playlist.dequeue();      // first in queue
            // DON'T PUSH the first ON STACK: no previous
            return current;
        }
        return null;
    }

    /**
     * Switches to the next song in the playlist.
     * @return the next song in the playlist
     */
    public String nextSong() {
        if (current == null) {
            return playSong();
        }
        history.push(current);          // push the previous song
        current = playlist.dequeue();      // now current becomes next
        return current;
    }

    /**
     * Switches back to the previous song in the playlist.
     * @return the previous song in the playlist
     */
    public String previousSong() {
        playlist.enqueueFront(current); // current song will be next again!
        current = history.pop();        // last song added to stack
        return current;
    }
}
