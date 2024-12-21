package mk.ukim.finki.wp.lab.repository;


import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    //public List<Album> getAllAlbums();
}

//   public List<Album> findAll(){
//        return DataHolder.albums;
//    }
//
//    public Album findById(Long id){
//        return DataHolder.albums.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
//    }
