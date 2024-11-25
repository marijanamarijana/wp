package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists;
    public static List<Song> songs;

    public static List<Album> albums;

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();

        Artist art1 = new Artist("FirstName1", "LastName1", "bio1..");
        Artist art2 = new Artist("FirstName2", "LastName2", "bio2..");
        Artist art3 = new Artist("FirstName3", "LastName3", "bio3..");
        Artist art4 = new Artist("FirstName4", "LastName4", "bio4..");
        Artist art5 = new Artist("FirstName5", "LastName5", "bio5..");

        artists.add(art1);
        artists.add(art2);
        artists.add(art3);
        artists.add(art4);
        artists.add(art5);

        albums = new ArrayList<>();
        Album a1 = new Album(1L, "First album", "genre1", "2003");
        Album a2 = new Album(2L, "Second album", "genre2", "2023");
        Album a3 = new Album(3L, "Third album", "genre3", "2022");
        Album a4 = new Album(4L, "Fourth album", "genre4", "2018");
        Album a5 = new Album(5L, "Fifth album", "genre5", "2013");

        albums.add(a1);
        albums.add(a2);
        albums.add(a3);
        albums.add(a4);
        albums.add(a5);

        songs = new ArrayList<>();

        List<Artist> art = new ArrayList<>();
        art.add(new Artist("ArtistP", "GenreP", "BioP"));

        Song s1 = new Song("Track1", "Title1", "genre1", 2003, art, a1);
        songs.add(s1);

        art.add(art1);
        art.add(art2);

        Song s2 = new Song("Track2", "Title2", "genre2", 2023, art, a2);
        songs.add(s2);

        Song s3 = new Song("Track3", "Title3", "genre3", 2022, art, a3);
        songs.add(s3);

        List<Artist> arts = new ArrayList<>();
        arts.add(art5);
        arts.add(art4);

        Song s4 = new Song("Track4", "Title4", "genre4", 2018, arts, a4);
        songs.add(s4);

        Song s5 = new Song("Track5", "Title5", "genre5", 2013, arts, a5);
        songs.add(s5);

    }

}
