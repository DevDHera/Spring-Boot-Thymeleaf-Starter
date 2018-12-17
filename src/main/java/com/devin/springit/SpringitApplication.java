package com.devin.springit;

import com.devin.springit.domain.Comment;
import com.devin.springit.domain.Link;
import com.devin.springit.repository.CommentRepository;
import com.devin.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting Started with Spring Boot 2", "https://95revolution.com");
            linkRepository.save(link);

            Comment comment = new Comment("This Spring Boot 2 Link is Awesome!", link);
            commentRepository.save(comment);

            link.addComment(comment);
        };
    }
}
