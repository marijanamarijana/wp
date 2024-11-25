package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import java.util.List;
@Data
public class Song {
    private String trackId;
    private String title;
    private String genre;
    private Integer releaseYear;
    private List<Artist> performers;
    private Long id;
    private Album album;

    public Song(String trackId, String title, String genre, Integer releaseYear, List<Artist> performers, Album album) {
        this.id = (long) (Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }
}

