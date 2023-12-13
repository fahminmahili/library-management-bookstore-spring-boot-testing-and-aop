package az.edu.ada.wm2.authortestingaop.service;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AuthorService {
    Author save(Author a);

    void deleteById(Long id);

    Optional<Author> getById(Long  id);

    Optional<Author> update(Long  id, Author a);

    Optional<Author> partialUpdate(Long  id, Map<String, Object> a);

    List<Author> list();
}
