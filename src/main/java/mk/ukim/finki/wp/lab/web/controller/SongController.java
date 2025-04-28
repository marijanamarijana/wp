package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(Model model) {
        model.addAttribute("songs", this.songService.getAllSongs());
        return "songs";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){

        Song s = this.songService.getSongById(id);
        if (s != null) {
            this.songService.deleteSong(id);
        }
        return "redirect:/songs";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model){

        Song s = this.songService.getSongById(id);
        if (s != null) {
            model.addAttribute("albums", this.albumService.getAllAlbums());
            model.addAttribute("song", s);
            return "add-song";
        }
        return "redirect:/songs";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add-form")
    public String getAddSongPage(Model model){
        model.addAttribute("albums", this.albumService.getAllAlbums());
        return "add-song";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam Integer releaseYear,
                           @RequestParam Long albumId){

        Album album = this.albumService.getAlbumById(albumId);
        if (album != null) {
            this.songService.saveSong(new Song(trackId, title, genre, releaseYear, album));
        }
        return "redirect:/songs";
    }
}
