package coursework.computer.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MainApplication {

    //running all model classes from main app
    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);


        //this is linux specific command, should work with other O/S
        //basically launches an instance of the below browsers in the list
        //for convienience purposes otherwise we need to enter manually in the url
        Runtime rt = Runtime.getRuntime();
        String url = "http://localhost:63342/springboot/src/main/resources/home_page.html";
        String[] browsers = { /*"firefox", */"chromium"/*, "mozilla", "epiphany", "konqueror",
                "netscape", "opera", "links", "lynx"*/};
        //building the exec {firefox -fork {browsers{i:} alternative in the bash-based command line
        StringBuilder cmd = new StringBuilder();
        for (String browser : browsers) cmd.append(browser).append(" \"").append(url).append(" \"");
        // If the first didn't work, try the next browser and so on

        rt.exec(new String[]{"sh", "-c", cmd.toString()});
    }
}
