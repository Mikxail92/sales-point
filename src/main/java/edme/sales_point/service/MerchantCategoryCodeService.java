package edme.sales_point.service;

import edme.sales_point.dto.MerchantCategoryCodeDto;
import edme.sales_point.exception.NotFoundException;
import edme.sales_point.mapper.MerchantCategoryCodeMapper;
import edme.sales_point.model.MerchantCategoryCode;
import edme.sales_point.repository.MerchantCategoryCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MerchantCategoryCodeService {

    private final MerchantCategoryCodeRepository merchantCategoryCodeRepository;
    private final MerchantCategoryCodeMapper merchantCategoryCodeMapper;

    public List<MerchantCategoryCodeDto> findAll() {
        return merchantCategoryCodeRepository.findAll().stream()
                .map(merchantCategoryCodeMapper::toDto)
                .collect(Collectors.toList());
    }

    public MerchantCategoryCodeDto findById(Long id) {
        return merchantCategoryCodeRepository.findById(id)
                .map(merchantCategoryCodeMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Merchant Category Code not found"));
    }

    public MerchantCategoryCodeDto save(MerchantCategoryCodeDto merchantCategoryCodeDto) {
        MerchantCategoryCode merchantCategoryCode = merchantCategoryCodeMapper.toEntity(merchantCategoryCodeDto);
        return merchantCategoryCodeMapper.toDto(merchantCategoryCodeRepository.save(merchantCategoryCode));
    }

    public MerchantCategoryCodeDto update(Long id, MerchantCategoryCodeDto merchantCategoryCodeDto) {
        if (merchantCategoryCodeRepository.existsById(id)) {
            merchantCategoryCodeDto.setId(id);
            MerchantCategoryCode merchantCategoryCode = merchantCategoryCodeMapper.toEntity(merchantCategoryCodeDto);
            MerchantCategoryCode updatedMerchantCategoryCode = merchantCategoryCodeRepository.save(merchantCategoryCode);
            return merchantCategoryCodeMapper.toDto(updatedMerchantCategoryCode);
        } else {
            throw new NotFoundException("Merchant Category Code not found");
        }
    }

    public void deleteById(Long id) {
        if (!merchantCategoryCodeRepository.existsById(id)) {
            throw new NotFoundException("Merchant Category Code not found");
        }
        merchantCategoryCodeRepository.deleteById(id);
    }
}
