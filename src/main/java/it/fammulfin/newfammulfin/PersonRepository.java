package it.fammulfin.newfammulfin;

import it.fammulfin.newfammulfin.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author "Eric Medvet" on 2022/01/02 for new-fammulfin
 */
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
  List<Person> findByLastName(@Param("lastName") String lastName);
}
