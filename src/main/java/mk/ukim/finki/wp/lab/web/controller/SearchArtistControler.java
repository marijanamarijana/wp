package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/search/artist")
public class SearchArtistControler {

    private final ArtistService artistService;

    public SearchArtistControler(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    String getSearch(Model model){
        model.addAttribute("artists", null);
        return "search-artist";
    }

    @PostMapping
    String getResults(@RequestParam String ArtistText,
                      Model model){

        List<Artist> resultArtists = artistService.results(ArtistText);
        model.addAttribute("artists", resultArtists);
        return "search-artist";
        //return "show-search-results";

    }

}
