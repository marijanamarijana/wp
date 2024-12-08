package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final SongService songService;

    public AlbumController(AlbumService albumService, SongService songService) {
        this.albumService = albumService;
        this.songService = songService;
    }

    @GetMapping
    public String getAlbumPage(Model model) {
        model.addAttribute("albums", this.albumService.getAllAlbums());
        return "albums";
    }

    @PostMapping
    public String showSongsInAlbum(@RequestParam Long albumId, Model model){
        if ( albumId != null ){
            model.addAttribute("songs", this.songService.findAllByAlbum_Id(albumId));
            return "songsFromAlbum";
        }
        else return "redirect:/albums";
    }
}
