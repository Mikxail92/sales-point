package edme.sales_point.service;

import edme.sales_point.dto.ResponseCodeDto;
import edme.sales_point.exception.NotFoundException;
import edme.sales_point.mapper.ResponseCodeMapper;
import edme.sales_point.model.ResponseCode;
import edme.sales_point.repository.ResponseCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ResponseCodeService {

    private final ResponseCodeRepository responseCodeRepository;
    private final ResponseCodeMapper responseCodeMapper;

    public List<ResponseCodeDto> findAll() {
        return responseCodeRepository.findAll().stream()
                .map(responseCodeMapper::toDto)
                .collect(Collectors.toList());
    }

    public ResponseCodeDto findById(Long id) {
        return responseCodeRepository.findById(id)
                .map(responseCodeMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Response Code not found"));
    }

    public ResponseCodeDto save(ResponseCodeDto responseCodeDto) {
        ResponseCode responseCode = responseCodeMapper.toEntity(responseCodeDto);
        return responseCodeMapper.toDto(responseCodeRepository.save(responseCode));
    }

    public ResponseCodeDto update(Long id, ResponseCodeDto responseCodeDto) {
        if (responseCodeRepository.existsById(id)) {
            responseCodeDto.setId(id);
            ResponseCode responseCode = responseCodeMapper.toEntity(responseCodeDto);
            ResponseCode updatedResponseCode = responseCodeRepository.save(responseCode);
            return responseCodeMapper.toDto(updatedResponseCode);
        } else {
            throw new NotFoundException("Response Code not found");
        }
    }

    public void deleteById(Long id) {
        if (!responseCodeRepository.existsById(id)) {
            throw new NotFoundException("Response Code not found");
        }
        responseCodeRepository.deleteById(id);
    }
}
