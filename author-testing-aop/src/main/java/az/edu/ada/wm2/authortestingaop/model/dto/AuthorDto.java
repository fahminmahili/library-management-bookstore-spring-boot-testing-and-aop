package az.edu.ada.wm2.authortestingaop.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;

    @NotNull(message = "Firstname cannot be null")
    @Size(min = 3, max = 50, message = "Firstname must be of length [3-50]")
    private String firstname;


    @NotNull(message = "Lastname cannot be null")
    @Size(min = 3, max = 50, message = "Lastname must be of length [3-50]")
    private String lastname;


    @NotNull(message = "Email cannot be null")
    @Size(min = 3, max = 120, message = "Email must be of length [3-120], and valid format")
    private String email;


    @NotNull(message = "Gender cannot be null")
    @Size(min = 4, max = 6, message = "Gender must be of length [4-6], and either 'male' or 'female' format")
    private String gender;

}
