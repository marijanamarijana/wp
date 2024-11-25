package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artists;
    }
    public Artist findById(Long id){
        return DataHolder.artists.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }
    public Song addSongToArtist(Song song, Artist artist){
        if ( song != null && artist != null){
            DataHolder.artists.remove(artist);
            artist.getSongsList().add(song);
            DataHolder.artists.add(artist);
        }
        return song;
    }

    public List<Song> listSongsFromArtist(Long id){
        return DataHolder.artists.stream().filter(x -> x.getId().equals(id)).findFirst().get().getSongsList();
    }
//    public Optional<Artist> findByName(String name){
//        return artists.stream().filter(x -> x.getFirstName().equals(name)).findFirst();
//    }

    public List<Artist> results(String s){
        return DataHolder.artists.stream().filter(x -> x.getFirstName().contains(s)).toList();
    }
}
