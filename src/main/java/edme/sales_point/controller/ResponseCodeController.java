package edme.sales_point.controller;

import edme.sales_point.dto.ResponseCodeDto;
import edme.sales_point.service.ResponseCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/sales-point/response-codes")
@RequiredArgsConstructor
public class ResponseCodeController {

    private final ResponseCodeService responseCodeService;

    @GetMapping
    public ResponseEntity<List<ResponseCodeDto>> getAllResponseCodes() {
        return ResponseEntity.ok(responseCodeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCodeDto> getResponseCodeById(@PathVariable Long id) {
        return ResponseEntity.ok(responseCodeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ResponseCodeDto> createResponseCode(@RequestBody ResponseCodeDto responseCodeDto) {
        return ResponseEntity.ok(responseCodeService.save(responseCodeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCodeDto> updateResponseCode(@PathVariable Long id, @RequestBody ResponseCodeDto responseCodeDto) {
        return ResponseEntity.ok(responseCodeService.update(id, responseCodeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponseCode(@PathVariable Long id) {
        responseCodeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
