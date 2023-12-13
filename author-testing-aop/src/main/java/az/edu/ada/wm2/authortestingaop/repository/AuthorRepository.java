package az.edu.ada.wm2.authortestingaop.repository;

import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
