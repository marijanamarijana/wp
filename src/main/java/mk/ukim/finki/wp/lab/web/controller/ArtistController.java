package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artist/controller")
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtistPage(@RequestParam(required = false) String selectedTrackId,
                                @RequestParam(required = false) String error,
                                Model model){

        model.addAttribute("selectedTrackId", selectedTrackId);
        model.addAttribute("artists", artistService.listArtists());
        return "artists";
    }

    @PostMapping
    public String getArtistPages(@RequestParam(required = false) Long nameArtistRadio,
                                 @RequestParam(required = false) String selectedTrackId,
                                 @RequestParam(required = false) String error, Model model){

        if (nameArtistRadio != null) {
            Artist a = artistService.findById(nameArtistRadio);

            if (selectedTrackId != null && a != null){
                Song s = songService.findByTrackId(selectedTrackId);

                if (s != null){
                    s.getPerformers().add(a);
                    model.addAttribute("part", s);
                    return "song-details";
                }
            }
            return "redirect:/artist/controller?selectedTrackId=" + selectedTrackId;
        }
        else {
            model.addAttribute("artists", artistService.listArtists());
            return "redirect:/artist/controller?selectedTrackId=" + selectedTrackId;
        }
    }
}
