package edme.sales_point.controller;

import edme.sales_point.dto.TransactionTypeDto;
import edme.sales_point.service.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-point/transaction-types")
@RequiredArgsConstructor
public class TransactionTypeController {

    private final TransactionTypeService transactionTypeService;

    @GetMapping
    public ResponseEntity<List<TransactionTypeDto>> getAllTransactionTypes() {
        return ResponseEntity.ok(transactionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTypeDto> getTransactionTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TransactionTypeDto> createTransactionType(@RequestBody TransactionTypeDto transactionTypeDto) {
        return ResponseEntity.ok(transactionTypeService.save(transactionTypeDto));
    }

    @PutMapping("/{id}")
    public TransactionTypeDto updateTransactionType(@PathVariable Long id, @RequestBody TransactionTypeDto transactionTypeDto) {
        return transactionTypeService.update(id, transactionTypeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransactionType(@PathVariable Long id) {
        transactionTypeService.deleteById(id);
    }
}
