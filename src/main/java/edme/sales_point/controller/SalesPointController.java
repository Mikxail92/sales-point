package edme.sales_point.controller;

import edme.sales_point.dto.SalesPointDto;
import edme.sales_point.service.SalesPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-point/sales-points")
@RequiredArgsConstructor
public class SalesPointController {

    private final SalesPointService salesPointService;

    @GetMapping
    public ResponseEntity<List<SalesPointDto>> getAllSalesPoints() {
        return ResponseEntity.ok(salesPointService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesPointDto> getSalesPointById(@PathVariable Long id) {
        return ResponseEntity.ok(salesPointService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SalesPointDto> createSalesPoint(@RequestBody SalesPointDto salesPointDto) {
        return ResponseEntity.ok(salesPointService.save(salesPointDto));
    }

    @PutMapping("/{id}")
    public SalesPointDto updateSalesPoint(@PathVariable Long id, @RequestBody SalesPointDto salesPointDto) {
        return salesPointService.update(id, salesPointDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesPoint(@PathVariable Long id) {
        salesPointService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
