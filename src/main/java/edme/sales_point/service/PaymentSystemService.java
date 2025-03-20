package edme.sales_point.service;

import edme.sales_point.dto.PaymentSystemDto;
import edme.sales_point.mapper.PaymentSystemMapper;
import edme.sales_point.model.PaymentSystem;
import edme.sales_point.repository.PaymentSystemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@CacheConfig(cacheNames = "PaymentSystem")
public class PaymentSystemService {

    private final PaymentSystemRepository paymentSystemRepository;
    private final PaymentSystemMapper paymentSystemMapper;

    @Cacheable()
    public List<PaymentSystemDto> findAll() {
        return paymentSystemRepository.findAll().stream()
                .map(paymentSystemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Cacheable(key = "#id")
//    @Cacheable(value = "paymentSystemById", key = "#id")
    public PaymentSystemDto findById(Long id) {
        log.info("Find payment system by id: {}", id);
        return paymentSystemRepository.findById(id)
                .map(paymentSystemMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Payment System not found"));
    }

    //    @CacheEvict(value = {"paymentSystemById"}, allEntries = true)
    public PaymentSystemDto save(PaymentSystemDto paymentSystemDto) {
        PaymentSystem paymentSystem = paymentSystemMapper.toEntity(paymentSystemDto);
        log.info("Save payment system: {}", paymentSystem);
        return paymentSystemMapper.toDto(paymentSystemRepository.save(paymentSystem));
    }

    //    @CacheEvict(value = {"paymentSystemById"}, allEntries = true)
    public void deleteById(Long id) {
        if (!paymentSystemRepository.existsById(id)) {
            throw new RuntimeException("Payment System not found");
        }
        paymentSystemRepository.deleteById(id);
        log.info("Delete payment system: {}", id);
    }
}
