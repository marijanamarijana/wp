package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

   @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public List<Song> getSongsByAlbumId(Long id) {
        Album a = albumRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        if (a != null)
                return  a.getSongs();
        else return null;
    }

    @Override
    public Album getAlbumById(Long id) {
        return albumRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }
}

// @Override
//    public List<Album> findAll() {
//        return albumRepository.findAll();
//    }
//
//    @Override
//    public Album findById(Long id) {
//        return albumRepository.findById(id);
//    }
