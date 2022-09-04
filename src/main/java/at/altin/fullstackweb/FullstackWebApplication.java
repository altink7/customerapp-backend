package at.altin.fullstackweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@SpringBootApplication
public class FullstackWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackWebApplication.class, args);
    }



}
