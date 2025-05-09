package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> findAllByAlbum_Id(Long albumId);

    List<Song> getAllSongs();

    void deleteSong(Long id);

    void saveSong(Song song);

    Song getSongById(Long id);
}

//List<Song> listSongs();
//    Artist addArtistToSong(Artist artist, Song song);
//    Song findByTrackId(String trackId);
//    void addNewSong(String title, String trackId, String genre, Integer ReleaseYear, Album album);