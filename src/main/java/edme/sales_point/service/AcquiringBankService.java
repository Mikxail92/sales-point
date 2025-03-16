package edme.sales_point.service;

import edme.sales_point.dto.AcquiringBankDto;
import edme.sales_point.exception.NotFoundException;
import edme.sales_point.mapper.AcquiringBankMapper;
import edme.sales_point.model.AcquiringBank;
import edme.sales_point.repository.AcquiringBankRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AcquiringBankService {

    private final AcquiringBankRepository acquiringBankRepository;

    private final AcquiringBankMapper acquiringBankMapper;



    public List<AcquiringBankDto> findAll() {
        return acquiringBankRepository.findAll().stream()
                .map(acquiringBankMapper::toDto)
                .collect(Collectors.toList());
    }

    public AcquiringBankDto findById(Long id) {
        return acquiringBankRepository.findById(id)
                .map(acquiringBankMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Acquiring Bank not found"));
    }

    public AcquiringBankDto save(AcquiringBankDto acquiringBankDto) {
        AcquiringBank acquiringBank = acquiringBankMapper.toEntity(acquiringBankDto);
        return acquiringBankMapper.toDto(acquiringBankRepository.save(acquiringBank));
    }

    public AcquiringBankDto update(Long id, AcquiringBankDto acquiringBankDto) {
        if (acquiringBankRepository.existsById(id)) {
            acquiringBankDto.setId(id);
            AcquiringBank acquiringBank = acquiringBankMapper.toEntity(acquiringBankDto);
            AcquiringBank updatedAcquiringBank = acquiringBankRepository.save(acquiringBank);
            return acquiringBankMapper.toDto(updatedAcquiringBank);
        } else {
            throw new NotFoundException("Acquiring Bank not found");
        }
    }

    public void deleteById(Long id) {
        if (!acquiringBankRepository.existsById(id)) {
            throw new NotFoundException("Acquiring Bank not found");
        }
        acquiringBankRepository.deleteById(id);
    }
}
