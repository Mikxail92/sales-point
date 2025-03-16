package edme.sales_point.mapper;

import edme.sales_point.dto.RegistrationUserAccessDto;
import edme.sales_point.dto.RegistrationUserDTO;
import edme.sales_point.model.UserAccess;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserAccessMapper {

    RegistrationUserDTO toDTO(UserAccess userAccess);

    UserAccess toEntity(RegistrationUserDTO registrationUserDTO);

    UserAccess toEntity(RegistrationUserAccessDto signUpRequest);
}
