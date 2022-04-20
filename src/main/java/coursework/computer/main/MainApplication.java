package coursework.computer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);

        Runtime rt = Runtime.getRuntime();
        String url = "http://localhost:63342/springboot/src/main/resources/home_page.html";
        String[] browsers = { /*"chromium", */"firefox"/*, "mozilla", "epiphany", "konqueror",
                "netscape", "opera", "links", "lynx"*/ };

        StringBuilder cmd = new StringBuilder();
        for (String browser : browsers) cmd.append(browser).append(" \"").append(url).append(" \"");
        // If the first didn't work, try the next browser and so on

        rt.exec(new String[] { "sh", "-c", cmd.toString() });
    }
}
