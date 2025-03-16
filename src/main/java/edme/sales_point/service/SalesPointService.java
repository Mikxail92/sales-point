package edme.sales_point.service;

import edme.sales_point.dto.SalesPointDto;
import edme.sales_point.exception.NotFoundException;
import edme.sales_point.mapper.SalesPointMapper;
import edme.sales_point.model.AcquiringBank;
import edme.sales_point.model.SalesPoint;
import edme.sales_point.repository.AcquiringBankRepository;
import edme.sales_point.repository.SalesPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SalesPointService {

    private final SalesPointRepository salesPointRepository;
    private final AcquiringBankRepository acquiringBankRepository;
    private final SalesPointMapper salesPointMapper;

    public List<SalesPointDto> findAll() {
        return salesPointRepository.findAll().stream()
                .map(salesPointMapper::toDto)
                .collect(Collectors.toList());
    }

    public SalesPointDto findById(Long id) {
        return salesPointRepository.findById(id)
                .map(salesPointMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Sales Point not found"));
    }

    public SalesPointDto save(SalesPointDto salesPointDto) {
        AcquiringBank acquiringBank = acquiringBankRepository.findById(salesPointDto.getAcquiringBankId())
                .orElseThrow(() -> new NotFoundException("AcquiringBank not found"));
        SalesPoint salesPoint = salesPointMapper.toEntity(salesPointDto);
        salesPoint.setAcquiringBank(acquiringBank);
        return salesPointMapper.toDto(salesPointRepository.save(salesPoint));
    }

    public SalesPointDto update(Long id, SalesPointDto salesPointDto) {
        if (salesPointRepository.existsById(id)) {
            salesPointDto.setId(id);
            AcquiringBank acquiringBank = acquiringBankRepository.findById(salesPointDto.getAcquiringBankId())
                    .orElseThrow(() -> new NotFoundException("AcquiringBank not found"));
            SalesPoint salesPoint = salesPointMapper.toEntity(salesPointDto);
            salesPoint.setAcquiringBank(acquiringBank);
            SalesPoint updatedSalesPoint = salesPointRepository.save(salesPoint);
            return salesPointMapper.toDto(updatedSalesPoint);
        } else {
            throw new NotFoundException("Sales Point not found");
        }
    }

    public void deleteById(Long id) {
        if (!salesPointRepository.existsById(id)) {
            throw new NotFoundException("Sales Point not found");
        }
        salesPointRepository.deleteById(id);
    }
}
