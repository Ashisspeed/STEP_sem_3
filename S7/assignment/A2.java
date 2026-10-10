class Playlist {
    @SuppressWarnings("FieldMayBeFinal")
    private String[] songs;
    private int count;

    public Playlist(int capacity) {
        songs = new String[capacity];
        count = 0;
    }

    public void addSong(String songTitle) {
        if (count < songs.length) {
            songs[count++] = songTitle;
        }
    }

    @SuppressWarnings("ManualArrayToCollectionCopy")
    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }
}

public class A2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Playlist real first song: " + p.getSongs()[0]);
        System.out.println("Modified copy first song: " + copy[0]);
    }
}