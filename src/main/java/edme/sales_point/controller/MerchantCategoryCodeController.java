package edme.sales_point.controller;

import edme.sales_point.dto.MerchantCategoryCodeDto;
import edme.sales_point.service.MerchantCategoryCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/sales-point/merchant-category-codes")
@RequiredArgsConstructor
public class MerchantCategoryCodeController {

    private final MerchantCategoryCodeService merchantCategoryCodeService;

    @GetMapping
    public ResponseEntity<List<MerchantCategoryCodeDto>> getAllMerchantCategoryCodes() {
        return ResponseEntity.ok(merchantCategoryCodeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MerchantCategoryCodeDto> getMerchantCategoryCodeById(@PathVariable Long id) {
        return ResponseEntity.ok(merchantCategoryCodeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MerchantCategoryCodeDto> createMerchantCategoryCode(@RequestBody MerchantCategoryCodeDto merchantCategoryCodeDto) {
        return ResponseEntity.ok(merchantCategoryCodeService.save(merchantCategoryCodeDto));
    }

    @PutMapping("/{id}")
    public MerchantCategoryCodeDto updateMerchantCategoryCode(@PathVariable Long id, @RequestBody MerchantCategoryCodeDto merchantCategoryCodeDto) {
        return merchantCategoryCodeService.update(id, merchantCategoryCodeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMerchantCategoryCode(@PathVariable Long id) {
        merchantCategoryCodeService.deleteById(id);
    }
}
