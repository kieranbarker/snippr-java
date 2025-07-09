package codes.barker.snippr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SnipprApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnipprApplication.class, args);
    }
}
