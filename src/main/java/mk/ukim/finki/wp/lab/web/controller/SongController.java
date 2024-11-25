package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


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
    public String getSongsPage(@RequestParam(required = false) String error, Model model){

        model.addAttribute("songs", this.songService.listSongs());
        //model.addAttribute("error", error);
        return "songs";
    }

    @PostMapping
    public String getArtistsPage(@RequestParam(name = "nameSongRadio", required = false) String selectedTrackId, Model model){

        if (selectedTrackId != null) {
            model.addAttribute("selectedTrackId", selectedTrackId);
            return "redirect:/artist/controller?selectedTrackId=" + selectedTrackId;
        }
        return "redirect:/songs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSong(@PathVariable String id){

        Song s = this.songService.findByTrackId(id);
        if (s != null) {
            this.songService.listSongs().remove(s);
        }
        return "redirect:/songs";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable String id, Model model){

        Song s = this.songService.findByTrackId(id);
        if (s != null) {
            model.addAttribute("albums", albumService.findAll());
            model.addAttribute("song", s);
            return "add-song";
        }

        return "redirect:/songs";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model){
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam Integer releaseYear,
                           @RequestParam Long albumId){

        Album album = albumService.findById(albumId);
        if (album != null) {
            songService.addNewSong(trackId, title, genre, releaseYear, album);
        }
        return "redirect:/songs";
    }

}
