package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface ArtistService{
    List<Artist> listArtists();
    Artist findById(Long id);
    Song addSongToArtist(Song song, Artist artist);
    List<Song> listSongsFromArtist(Long id);
    }
