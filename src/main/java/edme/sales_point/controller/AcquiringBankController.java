package edme.sales_point.controller;

import edme.sales_point.dto.AcquiringBankDto;
import edme.sales_point.service.AcquiringBankService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-point/acquiring-banks")
@RequiredArgsConstructor
@Tag(name = "Банк-эквайер")
public class AcquiringBankController {

    private final AcquiringBankService acquiringBankService;

    @Operation(summary = "Получить все счета", description = "Возвращает список всех счетов")
    @GetMapping
    public ResponseEntity<List<AcquiringBankDto>> getAllAcquiringBanks() {
        return ResponseEntity.ok(acquiringBankService.findAll());
    }

    @Operation(summary = "Получить банк по ID", description = "Возвращает банк по его ID")
    @GetMapping("/{id}")
    public AcquiringBankDto getAcquiringBankById(@Parameter(description = "ID банка")@PathVariable Long id) {
        return acquiringBankService.findById(id);
    }

    @Operation(summary = "Добавление банка", description = "Создаёт счёт банка")
    @PostMapping
    public ResponseEntity<AcquiringBankDto> createAcquiringBank(@RequestBody AcquiringBankDto acquiringBankDto) {
        return ResponseEntity.ok(acquiringBankService.save(acquiringBankDto));
    }

    @Operation(summary = "Обновить банк")
    @PutMapping("/{id}")
    public AcquiringBankDto updateAcquiringBank(@Parameter(description = "ID банка")@PathVariable Long id, @RequestBody AcquiringBankDto acquiringBankDto) {
        return acquiringBankService.update(id, acquiringBankDto);
    }

    @Operation(summary = "Удаление банка", description = "ВУдалить счёт банка")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcquiringBank(@Parameter(description = "ID банка")@PathVariable Long id) {
        acquiringBankService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
