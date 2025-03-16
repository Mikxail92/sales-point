package edme.sales_point.service;

import edme.sales_point.dto.TransactionTypeDto;
import edme.sales_point.exception.NotFoundException;
import edme.sales_point.mapper.TransactionTypeMapper;
import edme.sales_point.model.TransactionType;
import edme.sales_point.repository.TransactionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionTypeService {

    private final TransactionTypeRepository transactionTypeRepository;
    private final TransactionTypeMapper transactionTypeMapper;

    public List<TransactionTypeDto> findAll() {
        return transactionTypeRepository.findAll().stream()
                .map(transactionTypeMapper::toDto)
                .collect(Collectors.toList());
    }

    public TransactionTypeDto findById(Long id) {
        return transactionTypeRepository.findById(id)
                .map(transactionTypeMapper::toDto)
                .orElseThrow(() -> new NotFoundException("TransactionType not found"));
    }

    public TransactionTypeDto save(TransactionTypeDto transactionTypeDto) {
        TransactionType transactionType = transactionTypeMapper.toEntity(transactionTypeDto);
        return transactionTypeMapper.toDto(transactionTypeRepository.save(transactionType));
    }

    public TransactionTypeDto update(Long id, TransactionTypeDto transactionTypeDto) {
        if (transactionTypeRepository.existsById(id)) {
            transactionTypeDto.setId(id);
            TransactionType transactionType = transactionTypeMapper.toEntity(transactionTypeDto);
            TransactionType updatedTransactionType = transactionTypeRepository.save(transactionType);
            return transactionTypeMapper.toDto(updatedTransactionType);
        } else {
            throw new NotFoundException("TransactionType not found");
        }
    }

    public void deleteById(Long id) {
        if (!transactionTypeRepository.existsById(id)) {
            throw new NotFoundException("TransactionType not found");
        }
        transactionTypeRepository.deleteById(id);
    }
}
