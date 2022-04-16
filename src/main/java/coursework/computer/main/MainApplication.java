package coursework.computer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);

        Runtime rt = Runtime.getRuntime();
        String url = "http://localhost:63342/main/static/home_page.html";
        String[] browsers = { /*"chromium", */"firefox"/*, "mozilla", "epiphany", "konqueror",
                "netscape", "opera", "links", "lynx"*/ };

        StringBuilder cmd = new StringBuilder();
        for (String browser : browsers) cmd.append(browser).append(" \"").append(url).append(" \"");
        // If the first didn't work, try the next browser and so on

        rt.exec(new String[] { "sh", "-c", cmd.toString() });
    }
}
