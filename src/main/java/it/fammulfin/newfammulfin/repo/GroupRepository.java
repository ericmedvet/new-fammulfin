package it.fammulfin.newfammulfin.repo;

import it.fammulfin.newfammulfin.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Eric Medvet" on 2022/01/04 for new-fammulfin
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
}
