package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Data
@Entity
public class Song {

    private String trackId;
    private String title;
    private String genre;
    private Integer releaseYear;

//    @ManyToMany
//    private List<Artist> performers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Album album;

    public Song(String trackId, String title, String genre, Integer releaseYear, Album album) {
        //this.id = (long) (Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        //this.performers = performers;
        this.album = album;
    }

    public Song() {

    }
}

