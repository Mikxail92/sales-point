package edme.sales_point.mapper;

import edme.sales_point.dto.TerminalDto;
import edme.sales_point.model.Terminal;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TerminalMapper {

    TerminalDto toDto(Terminal terminal);

    Terminal toEntity(TerminalDto terminalDto);
}
