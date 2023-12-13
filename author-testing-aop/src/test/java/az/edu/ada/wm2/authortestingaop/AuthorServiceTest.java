package az.edu.ada.wm2.authortestingaop;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import az.edu.ada.wm2.authortestingaop.repository.AuthorRepository;
import az.edu.ada.wm2.authortestingaop.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {


    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    private Author author;

    @BeforeEach
    public void setUp(){
        author = new Author("Drake", "Loe", "drakeloe@gmail.com", "Male" );
    }


    @Test
    @DisplayName("save_WhenCalled_ShouldReturnExpectedEntity")
    void save_WhenCalled_ShouldReturnExpectedEntity(){


        //Mock Author Storage Repository
        when(authorRepository.save(author)).thenReturn(author);

        //When
        Author actual = authorService.save(author);

        //Then
        assertNotNull(actual);
        assertEquals(author,actual);
        verify(authorRepository, times(1)).save(author);

    }

    @Test
    @DisplayName("deleteById_WhenCalled_ShouldDeleteAuthor")
    void deleteById_WhenCalled_ShouldDeleteAuthor(){

        //Given
        Long authorId = 1L;

        //When
        authorService.deleteById(authorId);

        //Then
        verify(authorRepository, times(1)).deleteById(authorId);


    }

    @Test
    @DisplayName("list_WhenCalled_ShouldReturnExpectedList")
    void list_WhenCalled_ShouldReturnExpectedList(){

        //Given
        List<Author> expectedAuthors = List.of(
                new Author("Drake", "Loe", "drakeloe@gmail.com", "Male" ),
                author = new Author( "Micheal", "Scotland", "michealscotland@gmail.com", "Male")
        );

        //Mock Author Storage Repository
        when(authorRepository.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"))).thenReturn(expectedAuthors);

        //When
        List<Author> actualAuthors = authorService.list();

        //Then
        assertNotNull(actualAuthors);
        assertEquals(expectedAuthors, actualAuthors);
        verify(authorRepository, times(1)).findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));
    }

    @Test
    @DisplayName("getById_WhenCalled_ShouldReturnExpectedResult")
    void getById_WhenCalled_ShouldReturnExpectedResult(){

        //Mock Author Storage Repository
        when(authorRepository.findById(author.getId())).thenReturn(Optional.of(author));

        //When
        Optional<Author> actualAuthor = authorService.getById(author.getId());

        //Then
        assertNotNull(actualAuthor);
        Author expectedAuthor = author;
        Author actualAuthorValue = actualAuthor.orElse(null);
        assertEquals(expectedAuthor, actualAuthorValue);
        verify(authorRepository, times(1)).findById(author.getId());

    }





    @Test
    @DisplayName("update_WhenCalled_ShouldReturnUpdatedAuthor")
    void update_WhenCalled_ShouldReturnUpdatedAuthor(){

        //Given
        Long authorId = 1L;
        Author author = new Author("Drake", "Loe", "drakeloe@gmail.com", "Male");

        //Mock Author Storage Repository
        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        when(authorRepository.save(author)).thenReturn(author);

        //When
        Optional<Author> updatedAuthor = authorService.update(authorId, author);

        //Then
        assertTrue(updatedAuthor.isPresent());
        assertEquals(author, updatedAuthor.get());
        verify(authorRepository, times(1)).findById(authorId);
        verify(authorRepository, times(1)).save(author);
    }

}
