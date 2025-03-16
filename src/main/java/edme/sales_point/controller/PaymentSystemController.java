package edme.sales_point.controller;

import edme.sales_point.dto.PaymentSystemDto;
import edme.sales_point.service.PaymentSystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-point/payment-systems")
@RequiredArgsConstructor
public class PaymentSystemController {

    private final PaymentSystemService paymentSystemService;

    @GetMapping
    public ResponseEntity<List<PaymentSystemDto>> getAllPaymentSystems() {
        return ResponseEntity.ok(paymentSystemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentSystemDto> getPaymentSystemById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentSystemService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentSystemDto> createPaymentSystem(@RequestBody PaymentSystemDto paymentSystemDto) {
        return ResponseEntity.ok(paymentSystemService.save(paymentSystemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentSystemDto> updatePaymentSystem(@PathVariable Long id, @RequestBody PaymentSystemDto paymentSystemDto) {
        paymentSystemDto.setId(id);
        return ResponseEntity.ok(paymentSystemService.save(paymentSystemDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentSystem(@PathVariable Long id) {
        paymentSystemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
