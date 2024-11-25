package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "display songs", urlPatterns = "/displaySongs")
public class DisplaySongs extends HttpServlet {
    //nameArtistForSongRadio
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public DisplaySongs(ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        Artist artist = artistService.listArtists().stream().findFirst().orElse(null);
        context.setVariable("songsArtist", artist.getSongsList());
        springTemplateEngine.process("pickArtist.html",context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String artistId = req.getParameter("nameArtistForSongRadio");
        Artist artist = null;
        if (artistId != null) {
            artist = artistService.findById(Long.valueOf(artistId));
        }
        context.setVariable("songsArtist", artist.getSongsList());
        springTemplateEngine.process("pickArtist.html",context, resp.getWriter());

    }
}
