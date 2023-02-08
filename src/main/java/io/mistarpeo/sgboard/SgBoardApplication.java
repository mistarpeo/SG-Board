package io.mistarpeo.sgboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SgBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgBoardApplication.class, args);
    }

}
