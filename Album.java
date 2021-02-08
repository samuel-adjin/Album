import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String albumName, String artist) {
        this.name = albumName;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public boolean addSong(String songTittle, double songDuration){
        Song newSong = new Song(songTittle,songDuration);
        Song checkSong =findSong(songTittle);
        if (checkSong!= null){
            return false;
        }
        songs.add(newSong);
        return true;
    }

    public Song findSong(String songTitle) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(songTitle)) {
                return songs.get(i);
            }
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int songNumber = trackNumber -1;
        if ((songNumber >= 0) && (songNumber<= songs.size())){
            playList.add(songs.get(songNumber));
            return true;
        }
        System.out.println("Album does not have a track " + trackNumber);
        return false;
    }
    public boolean addToPlayList(String songTitle, LinkedList<Song> playList){
        Song checkSong = findSong(songTitle);
        if (checkSong != null){
            playList.add(checkSong);
            return true;
        }
        System.out.println("The song " + songTitle + " is not in the album");
        return false;
    }

}



