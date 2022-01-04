package it.fammulfin.newfammulfin.repo;

import it.fammulfin.newfammulfin.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
  List<Chapter> findByGroupId(@Param("groupId") long groupId);

  List<Chapter> findByParentId(@Param("chapterId") long chapterId);
}
