package edme.sales_point.service;

import edme.sales_point.dto.TerminalDto;
import edme.sales_point.exception.NotFoundException;
import edme.sales_point.mapper.TerminalMapper;
import edme.sales_point.model.MerchantCategoryCode;
import edme.sales_point.model.SalesPoint;
import edme.sales_point.model.Terminal;
import edme.sales_point.repository.MerchantCategoryCodeRepository;
import edme.sales_point.repository.SalesPointRepository;
import edme.sales_point.repository.TerminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TerminalService {

    private final TerminalRepository terminalRepository;
    private final MerchantCategoryCodeRepository merchantCategoryCodeRepository;
    private final SalesPointRepository salesPointRepository;
    private final TerminalMapper terminalMapper;

    public List<TerminalDto> findAll() {
        return terminalRepository.findAll().stream()
                .map(terminalMapper::toDto)
                .collect(Collectors.toList());
    }

    public TerminalDto findById(Long id) {
        return terminalRepository.findById(id)
                .map(terminalMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Terminal not found"));
    }

    public TerminalDto save(TerminalDto terminalDto) {
        MerchantCategoryCode merchantCategoryCode = merchantCategoryCodeRepository.findById(terminalDto.getMerchantCategoryCodeId())
                .orElseThrow(() -> new NotFoundException("Merchant Category Code not found"));
        SalesPoint salesPoint = salesPointRepository.findById(terminalDto.getSalesPointId())
                .orElseThrow(() -> new NotFoundException("SalesPoint not found"));
        Terminal terminal = terminalMapper.toEntity(terminalDto);
        terminal.setMerchantCategoryCode(merchantCategoryCode);
        terminal.setSalesPoint(salesPoint);
        return terminalMapper.toDto(terminalRepository.save(terminal));
    }

    public TerminalDto update(Long id, TerminalDto terminalDto) {
        if (terminalRepository.existsById(id)) {
            terminalDto.setId(id);
            MerchantCategoryCode merchantCategoryCode = merchantCategoryCodeRepository.findById(terminalDto.getMerchantCategoryCodeId())
                    .orElseThrow(() -> new NotFoundException("Merchant Category Code not found"));
            SalesPoint salesPoint = salesPointRepository.findById(terminalDto.getSalesPointId())
                    .orElseThrow(() -> new NotFoundException("SalesPoint not found"));
            Terminal terminal = terminalMapper.toEntity(terminalDto);
            terminal.setMerchantCategoryCode(merchantCategoryCode);
            terminal.setSalesPoint(salesPoint);
            Terminal updatedTerminal = terminalRepository.save(terminal);
            return terminalMapper.toDto(updatedTerminal);
        } else {
            throw new NotFoundException("Terminal not found");
        }
    }

    public void deleteById(Long id) {
        if (!terminalRepository.existsById(id)) {
            throw new NotFoundException("Terminal not found");
        }
        terminalRepository.deleteById(id);
    }
}
