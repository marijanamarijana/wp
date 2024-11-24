package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private List<Song> songs;

    public SongRepository() {
        songs = new ArrayList<>();
        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("ArtistP", "GenreP", "BioP"));

        songs.add(new Song("HRS","Hotel Room Service", "latin", 2009, artists));
        artists.remove(0);
        artists.add(new Artist("Artist1", "Genre1", "Bio1"));
        artists.add(new Artist("Artist22", "Genre22", "Bio22"));
        songs.add(new Song("track2", "song of the year", "genre2", 1998, artists));
        songs.add(new Song("track3", "song3", "genre3", 2003, artists));
        artists.remove(0);
        songs.add(new Song("track2", "song of the year", "genre2", 1998, artists));
        songs.add(new Song("track5", "hear", "genre44", 2022, artists));
    }

    public List<Song> findAll(){
        return songs;
    }
    public Optional<Song> findByTrackId(String trackId){
        return songs.stream().filter(x -> x.getTrackId().equals(trackId)).findFirst();
    }
    public Artist addArtistToSong(Artist artist, Song song){
        if( song != null && artist != null){
        songs.remove(song);
        song.getPerformers().add(artist);
        songs.add(song);
        }
        return artist;
    }
}
