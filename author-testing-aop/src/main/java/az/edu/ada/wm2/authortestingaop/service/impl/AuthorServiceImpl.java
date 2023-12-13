package az.edu.ada.wm2.authortestingaop.service.impl;
import az.edu.ada.wm2.authortestingaop.service.AuthorService;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import az.edu.ada.wm2.authortestingaop.repository.AuthorRepository;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {


        private AuthorRepository authRepo;

        public AuthorServiceImpl(AuthorRepository authRepo) {
            this.authRepo = authRepo;
        }



        @Override
        public Author save(Author a) {
            return authRepo.save(a);
        }


        @Override
        public void deleteById(Long id) {
            authRepo.deleteById(id);
        }


        @Override
        public Optional<Author> getById(Long id) {
            return authRepo.findById(id);
        }



        @Override
        public Optional<Author> update(Long id, Author a) {
            Optional<Author> older = authRepo.findById(id);
            if (older.isEmpty()) return older;

            a.setId(id);

            return Optional.of(authRepo.save(a));
        }



        @Override
        public List<Author> list() {
            return authRepo.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));
        }





        @Override
        public Optional<Author> partialUpdate(Long id, Map<String, Object> a) {
            return Optional.empty();
        }



}
