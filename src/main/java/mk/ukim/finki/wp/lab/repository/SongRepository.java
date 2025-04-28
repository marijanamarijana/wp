package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByAlbum_Id(Long albumId);
//    void saveSong(Song song);
//    void deleteSong(Long id);
}


// public List<Song> findAll(){
//        return DataHolder.songs;
//    }
//    public Song findByTrackId(String trackId){
//        return DataHolder.songs.stream().filter(x -> x.getTrackId().equals(trackId)).findFirst().orElse(null);
//    }
//    public Artist addArtistToSong(Artist artist, Song song){
//        if( song != null && artist != null){
//            DataHolder.songs.remove(song);
//            //song.getPerformers().add(artist);
//            DataHolder.songs.add(song);
//        }
//        return artist;
//    }
//
//    public void addNewSong(String title, String trackId, String genre, Integer ReleaseYear, Album album){
//
//        Song s = findByTrackId(trackId);
//        if (s == null) {
//            DataHolder.songs.add(new Song(trackId, title, genre, ReleaseYear, new ArrayList<Artist>(), album));
//        }
//        else {
//            DataHolder.songs.remove(s);
//
//            s.setTitle(title);
//            s.setReleaseYear(ReleaseYear);
//            s.setGenre(genre);
//            s.setAlbum(album);
//
//            DataHolder.songs.add(s);
//        }
//
//    }
