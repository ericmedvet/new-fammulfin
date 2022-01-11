package it.fammulfin.newfammulfin.repo;

import it.fammulfin.newfammulfin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @author "Eric Medvet" on 2022/01/02 for new-fammulfin
 */
@PreAuthorize("hasRole('admin')") // TODO see README.md
public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(@Param("email") String email);
}
