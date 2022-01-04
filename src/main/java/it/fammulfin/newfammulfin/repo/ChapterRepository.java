package it.fammulfin.newfammulfin.repo;

import it.fammulfin.newfammulfin.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
