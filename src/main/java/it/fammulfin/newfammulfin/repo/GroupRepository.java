package it.fammulfin.newfammulfin.repo;

import it.fammulfin.newfammulfin.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
  List<Group> findByOwnerId(@Param("userId") long userId);
  @Query("select g from Group g join g.members u where u.id = :userId")
  List<Group> findByMemberId(@Param("userId") long userId);
}
