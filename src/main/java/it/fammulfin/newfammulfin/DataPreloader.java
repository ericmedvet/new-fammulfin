package it.fammulfin.newfammulfin;

import it.fammulfin.newfammulfin.entity.Chapter;
import it.fammulfin.newfammulfin.entity.Entry;
import it.fammulfin.newfammulfin.entity.Group;
import it.fammulfin.newfammulfin.entity.User;
import it.fammulfin.newfammulfin.repo.ChapterRepository;
import it.fammulfin.newfammulfin.repo.EntryRepository;
import it.fammulfin.newfammulfin.repo.GroupRepository;
import it.fammulfin.newfammulfin.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
@Configuration
public class DataPreloader {
  private static final Logger L = LoggerFactory.getLogger(DataPreloader.class);

  @Bean
  CommandLineRunner preloadData(
      UserRepository userRepository,
      GroupRepository groupRepository,
      ChapterRepository chapterRepository,
      EntryRepository entryRepository
  ) {
    return args -> {
      L.info("Preloading data");
      User aUser = userRepository.save(new User("Alice", "Red", "alice@red.org"));
      User bUser = userRepository.save(new User("Bob", "Red", "bob@red.org"));
      Group group = groupRepository.save(new Group("family", aUser, Set.of(aUser, bUser)));
      Chapter rootChapter = chapterRepository.save(new Chapter(group, null, ""));
      Chapter foodChapter = chapterRepository.save(new Chapter(group, rootChapter, "food"));
      Chapter sweetsChapter = chapterRepository.save(new Chapter(group, foodChapter, "sweets"));
      entryRepository.save(new Entry(
          group,
          foodChapter,
          LocalDate.of(2021, 12, 24),
          BigDecimal.valueOf(25.36),
          Map.of(aUser, BigDecimal.valueOf(25.36)),
          Map.of(aUser, BigDecimal.valueOf(12.68), bUser, BigDecimal.valueOf(12.68)),
          "Food store",
          "Xmas dinner food",
          "",
          Set.of()
      ));
      entryRepository.save(new Entry(
          group,
          sweetsChapter,
          LocalDate.of(2021, 12, 31),
          BigDecimal.valueOf(30),
          Map.of(aUser, BigDecimal.valueOf(30)),
          Map.of(aUser, BigDecimal.valueOf(20), bUser, BigDecimal.valueOf(10)),
          "Cakes inc.",
          "NY cake",
          "Very tasty",
          Set.of("diet")
      ));
    };
  }
}
