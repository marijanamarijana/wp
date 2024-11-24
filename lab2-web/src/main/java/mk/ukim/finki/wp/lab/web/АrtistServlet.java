package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "artist servlet", urlPatterns = "/artist")
public class АrtistServlet extends HttpServlet {

    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public АrtistServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("artists", artistService.listArtists());
        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        String trackId = "";
        if(req.getParameter("nameSongRadio") != null){
            trackId = req.getParameter("nameSongRadio");
        }
        req.getSession().setAttribute("trackId", trackId);
        context.setVariable("trackId", trackId);
        context.setVariable("artists", artistService.listArtists());
        springTemplateEngine.process("artistsList.html", context, resp.getWriter());
    }
}
