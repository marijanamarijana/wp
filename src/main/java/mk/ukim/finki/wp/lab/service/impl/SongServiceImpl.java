package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId) {
        return songRepository.findAllByAlbum_Id(albumId);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public void saveSong(Song song) {

        Song s = songRepository.findAll().stream().filter(x -> x.getId().equals(song.getId())).findFirst().orElse(null);

        if (s == null)
        songRepository.save(song);

        else {
            songRepository.deleteById(song.getId());
            songRepository.save(song);
        }
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findAll().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
