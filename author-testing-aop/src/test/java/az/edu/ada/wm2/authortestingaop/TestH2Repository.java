package az.edu.ada.wm2.authortestingaop;

import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2Repository extends JpaRepository<Author, Long> {

}
