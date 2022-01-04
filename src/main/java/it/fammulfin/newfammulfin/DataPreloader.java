package it.fammulfin.newfammulfin;

import it.fammulfin.newfammulfin.entity.User;
import it.fammulfin.newfammulfin.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
@Configuration
public class DataPreloader {
  private static final Logger L = LoggerFactory.getLogger(DataPreloader.class);

  @Bean
  CommandLineRunner preloadData(UserRepository personRepository) {
    return args -> personRepository.saveAll(List.of(
        new User("Mary", "Reds"),
        new User("Jake", "Greens")
    ));
  }
}
