package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface AlbumService {
    public List<Album> getAllAlbums();

    List<Song> getSongsByAlbumId(Long id);

    Album getAlbumById(Long id);
}

//    public List<Album> findAll();
//
//    public Album findById(Long id);
