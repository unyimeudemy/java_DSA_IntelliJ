package Sorting.MergeSort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class UseComparable {

    public static void main(String[] args){
        ArrayList<Song> playList = new ArrayList<Song>();
        playList.add(new Song("Dumebi", 8000, LocalDate.of(2022, 7, 16)));
        playList.add(new Song("Bad commando", 10000, LocalDate.of(2024, 3, 20)));
        playList.add(new Song("Calm down", 90000, LocalDate.of(2023, 12, 12)));

//        Collections.sort(playList, new StreamsComparator());
//        Collections.sort(playList, new SongTitleComparator());
//        Collections.sort(playList, new DateComparator());

        Song[] songArray = playList.toArray(new Song[0]);
        Arrays.sort(songArray, new DateComparator());
        for(Song song: playList){
            System.out.println(song.songTitle);
        }
    }
}


class Song  {
    String songTitle;
    int numberOfStreams;
    LocalDate yearOfRelease;
    public Song(String songTitle, int numberOfStreams, LocalDate yearOfRelease){
        this.songTitle = songTitle;
        this.numberOfStreams = numberOfStreams;
        this.yearOfRelease = yearOfRelease;
    }

    public String getSongDetail(){
        return "Song title: " + songTitle + ", Year: " + yearOfRelease + ", Streams: " + numberOfStreams;
    }

}

class StreamsComparator implements Comparator<Song>{
    @Override
    public int compare (Song song1, Song song2){
        if(song1.numberOfStreams == song2.numberOfStreams){
            return 0;
        }
        if(song1.numberOfStreams > song2.numberOfStreams){
            return 1;
        }
        return -1;
    }
}

class SongTitleComparator implements Comparator<Song>{
    @Override
    public int compare (Song song1, Song song2){
        if (song1.songTitle == null && song2.songTitle == null) {
            return 0;
        } else if (song1.songTitle.compareTo(song2.songTitle) == 1) {
            return 1;
        }
            return -1;
    }
}

 class DateComparator implements Comparator<Song> {
    @Override
    public int compare(Song song1, Song song2) {
        if (song1.yearOfRelease == null && song2.yearOfRelease == null) {
            return 0;
        } else if (song1.yearOfRelease == null) {
            return -1; // Null comes before a non-null date
        } else if (song2.yearOfRelease == null) {
            return 1; // Non-null date comes before null
        } else {
            // Use compareTo directly, as it already returns -1, 0, or 1
            return song1.yearOfRelease.compareTo(song2.yearOfRelease);
        }
    }
}



