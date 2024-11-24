import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WebLab2Application {

    public static void main(String[] args) {
        SpringApplication.run(com.example.weblab2.WebLab2Application.class, args);
    }

}
