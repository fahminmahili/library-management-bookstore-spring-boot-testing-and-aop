package az.edu.ada.wm2.authortestingaop.init;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import az.edu.ada.wm2.authortestingaop.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class DBInitializer {

    @Bean
    @Autowired
    public CommandLineRunner init(AuthorRepository authorRepo) {
        return (args) -> {
            Author a1 = authorRepo.save(new Author("Fahmin", "Mahili", "fahminmahili@gmail.com", "Male"));
            Author a2 = authorRepo.save(new Author("John", "Smith", "Johnsmith2gmail.com", "Male"));

            Thread.sleep(1000 * 60);

            authorRepo.save(new Author("Ismayil", "Mahili", "ismayilmahili@gmail.com", "Male"));

            Thread.sleep(1000 * 90);


            a1.setName("Fahmin");

            a2.setEmail(a2.getEmail());

            authorRepo.save(a1);
            authorRepo.save(a2);
        };
    }

}
