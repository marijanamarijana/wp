package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }
    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public Song addSongToArtist(Song song, Artist artist) {
        return artistRepository.addSongToArtist(song, artist);
    }

    @Override
    public List<Song> listSongsFromArtist(Long id) {
        return artistRepository.listSongsFromArtist(id);
    }

    @Override
    public List<Artist> results(String s) {
        return artistRepository.results(s);
    }

}
