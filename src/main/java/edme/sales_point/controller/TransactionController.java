//package edme.sales_point.controller;
//
//import edme.sales_point.dto.TransactionDTO;
//import edme.sales_point.service.TransactionService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/api/sales-point/transactions")
//public class TransactionController {
//
//
//    private TransactionService transactionService;
//
//    @PostMapping
//    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {
//        TransactionDTO createdTransaction = transactionService.createTransaction(transactionDTO);
//        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
//    }
//
//    @GetMapping
//    public List<TransactionDTO> getAllTransactions() {
//        return transactionService.getAllTransactions();
//    }
//
//    @GetMapping("/{id}")
//    public TransactionDTO getTransactionById(@PathVariable Long id) {
//        return transactionService.getTransactionById(id);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<TransactionDTO> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
//        TransactionDTO updatedTransaction = transactionService.updateTransaction(id, transactionDTO);
//        return updatedTransaction != null ? ResponseEntity.ok(updatedTransaction) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
//        boolean isDeleted = transactionService.deleteTransaction(id);
//        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//    }
//}
