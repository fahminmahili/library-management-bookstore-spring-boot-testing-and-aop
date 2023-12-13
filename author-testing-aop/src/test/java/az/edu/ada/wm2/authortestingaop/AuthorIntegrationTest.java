package az.edu.ada.wm2.authortestingaop;
import az.edu.ada.wm2.authortestingaop.model.dto.AuthorDto;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;
import az.edu.ada.wm2.authortestingaop.service.AuthorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import az.edu.ada.wm2.authortestingaop.repository.AuthorRepository;
import az.edu.ada.wm2.authortestingaop.controller.AuthorController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AuthorIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    private static TestRestTemplate testRestTemplate;


    @BeforeAll
    public static void init(){
        testRestTemplate = new TestRestTemplate();
    }

    @Autowired
    private AuthorService authorService;

    @Autowired
    private TestH2Repository testH2Repository;

    @AfterEach
    public void tearDown(){
        testH2Repository.deleteAll();
    }

    @Autowired
    private AuthorController authorController;

    @Autowired
    private AuthorRepository authorRepository;

    private AuthorDto authorDto;

    @BeforeEach
    void setUp() {
        authorDto = new AuthorDto();
        authorDto.setFirstname("John");
        authorDto.setLastname("Doe");
        authorDto.setEmail("johndoe@example.com");
        authorDto.setGender("male");
    }


    @Test
    public void testGetAuthorById() throws Exception {
        // creating test data
        Author author = new Author();
        author.setEmail("johndoe@example.com");

        // saving test data to the database
        authorRepository.save(author);

        // sending a GET request to the endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/authors/{id}", author.getId()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(author.getEmail()));
    }


    @Test
    public void testListAuthors() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andDo(MockMvcResultHandlers.print());
    }



}
