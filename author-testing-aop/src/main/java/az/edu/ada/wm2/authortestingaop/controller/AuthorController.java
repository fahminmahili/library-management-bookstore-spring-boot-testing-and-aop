package az.edu.ada.wm2.authortestingaop.controller;
import az.edu.ada.wm2.authortestingaop.annotation.TimeTracker;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import az.edu.ada.wm2.authortestingaop.service.AuthorService;
import az.edu.ada.wm2.authortestingaop.model.mapper.AuthorMapper;
import az.edu.ada.wm2.authortestingaop.model.dto.AuthorDto;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/authors")

public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @TimeTracker //
    @SneakyThrows //
    @GetMapping
    @ResponseStatus(HttpStatus.OK) //200
    public @ResponseBody List<AuthorDto> listAuthors() {
    List<Author> authors = authorService.list();

    Thread.sleep(1000); //

    return AuthorMapper.INSTANCE.authorListToAuthorDtoList(authors);
}


    @SneakyThrows //
    @GetMapping("/{authorId}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("authorId") Long id) {
        Optional<Author> res = authorService.getById(id);

        Thread.sleep(1000); //


        if (res.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            AuthorDto authorDto = AuthorMapper.INSTANCE.authorToAuthorDto(res.get());
            return ResponseEntity.ok(authorDto);
        }
    }


    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("authorId") Long id) {
        authorService.deleteById(id);
    }




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public @ResponseBody AuthorDto saveAuthor(@Valid @RequestBody AuthorDto authorDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        Author author = AuthorMapper.INSTANCE.authorDtoToAuthor(authorDto);
        Author newA = authorService.save(author);
        return AuthorMapper.INSTANCE.authorToAuthorDto(newA);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable("authorId") Long  id, @Valid @RequestBody AuthorDto newAuthorDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        Author newAuthor = AuthorMapper.INSTANCE.authorDtoToAuthor(newAuthorDto);
        Optional<Author> res = authorService.update(id, newAuthor);

        if (res.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            AuthorDto authorDto = AuthorMapper.INSTANCE.authorToAuthorDto(res.get());
            return ResponseEntity.ok(authorDto);
        }
    }


    @PatchMapping("/{authorId}")
    public ResponseEntity<AuthorDto> partialUpdateAuthor(@PathVariable("authorId") Long id, @RequestBody Map<String, Object> updates) {
        Optional<Author> res = authorService.partialUpdate(id, updates);

        if (res.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            AuthorDto authorDto = AuthorMapper.INSTANCE.authorToAuthorDto(res.get());
            return ResponseEntity.ok(authorDto);
        }
    }



}
