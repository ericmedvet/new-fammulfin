package it.fammulfin.newfammulfin.repo;

import it.fammulfin.newfammulfin.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
public interface EntryRepository extends JpaRepository<Entry, Long> {
  List<Entry> findByGroupId(@Param("groupId") long groupId);

  List<Entry> findByChapterId(@Param("chapterId") long chapterId);

  List<Entry> findByPayee(@Param("name") long name);

  // TODO add by dates, by tag
}
