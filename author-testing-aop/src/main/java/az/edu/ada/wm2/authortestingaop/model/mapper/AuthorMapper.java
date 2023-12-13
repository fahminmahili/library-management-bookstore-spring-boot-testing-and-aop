package az.edu.ada.wm2.authortestingaop.model.mapper;
import az.edu.ada.wm2.authortestingaop.model.dto.AuthorDto;
import az.edu.ada.wm2.authortestingaop.model.entity.Author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "firstname"),
            @Mapping(source = "surname", target = "lastname")
    })
    AuthorDto authorToAuthorDto(Author author);

    @Mappings({
            @Mapping(source = "name", target = "firstname"),
            @Mapping(source = "surname", target = "lastname")
    })
    List<AuthorDto> authorListToAuthorDtoList(List<Author> authors);

    @Mappings({
            @Mapping(source = "firstname", target = "name"),
            @Mapping(source = "lastname", target = "surname")
    })
    Author authorDtoToAuthor(AuthorDto authorDto);

}
