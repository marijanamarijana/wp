package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {
    List<Artist> artists;

    public ArtistRepository() {
        artists = new ArrayList<>();
        artists.add(new Artist("Lana","DelREY", "something about..."));
        artists.add(new Artist("Carrie", "Underwood", "country"));
        artists.add(new Artist("Pit", "bull", "dale dale dale"));
        artists.add(new Artist("Becky", "G", "latin something"));
        artists.add(new Artist("Enrique", "Iglesias", "latin something something"));
    }

    public List<Artist> findAll(){
        return artists;
    }
    public Optional<Artist> findById(Long id){
        return artists.stream().filter(x -> x.getId().equals(id)).findFirst();
    }
//    public Optional<Artist> findByName(String name){
//        return artists.stream().filter(x -> x.getFirstName().equals(name)).findFirst();
//    }
}
