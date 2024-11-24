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

@WebServlet(name = "song details", urlPatterns = "/songDetails")
public class SongDetails extends HttpServlet {

    private final ArtistService artistService;
    private final SongService songService;
    private final SpringTemplateEngine springTemplateEngine;

    public SongDetails(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.songService = songService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        Song song = songService.listSongs().stream().findFirst().orElse(null);
        context.setVariable("part", song);
        springTemplateEngine.process("songDetails.html",context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        //String trackId = req.getParameter("trackId");
        String trackId = req.getSession().getAttribute("trackId").toString();
        String artistId = req.getParameter("nameArtistRadio");
        Song song = songService.listSongs().stream().findFirst().orElse(null);

        if(trackId != null && artistId != null){
           song = songService.findByTrackId(trackId);
           Artist art = artistService.findById(Long.valueOf(artistId));
           req.getSession().setAttribute("ArtistId",art.getId());
           songService.addArtistToSong(art, song);
           artistService.addSongToArtist(song, art);
        }
        context.setVariable("part", song);
        springTemplateEngine.process("songDetails.html", context, resp.getWriter());
    }
}
