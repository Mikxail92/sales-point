//package edme.sales_point.service;
//
//import edme.sales_point.dto.TransactionDTO;
//import edme.sales_point.mapper.TransactionMapper;
//import edme.sales_point.model.*;
//import edme.sales_point.repository.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Slf4j
//public class TransactionService {
//    private final TransactionRepository transactionRepository;
//    private final TransactionTypeRepository transactionTypeRepository;
//    private final CardRepository cardRepository;
//    private final TerminalRepository terminalRepository;
//    private final ResponseCodeRepository responseCodeRepository;
//    private final TransactionMapper transactionMapper;
//    private final TransactionFeignClient transactionFeignClient;
//    private final RetryTemplate retryTemplate;
//
//    public TransactionService(TransactionRepository transactionRepository, TransactionTypeRepository transactionTypeRepository, CardRepository cardRepository, TerminalRepository terminalRepository, ResponseCodeRepository responseCodeRepository, TransactionMapper transactionMapper, TransactionFeignClient transactionFeignClient, RetryTemplate retryTemplate) {
//        this.transactionRepository = transactionRepository;
//        this.transactionTypeRepository = transactionTypeRepository;
//        this.cardRepository = cardRepository;
//        this.terminalRepository = terminalRepository;
//        this.responseCodeRepository = responseCodeRepository;
//        this.transactionMapper = transactionMapper;
//        this.transactionFeignClient = transactionFeignClient;
//        this.retryTemplate = retryTemplate;
//    }
//
//    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
//
//        retryTemplate.execute(context -> {
//            log.info("Попытка #{} вызова transactionFeignClient.createTransaction", context.getRetryCount() + 1);
//            try {
//                transactionFeignClient.createTransaction(transactionDTO);
//                return null;
//            } catch (ServerErrorException | EmptyResponseException e) {
//                log.warn("Ошибка, требующая повторного запроса: {}", e.getMessage());
//                throw new RetryableRemoteServiceException("Ошибка при вызове Feign-клиента", e);
//            } catch (ClientErrorException e) {
//                log.error("Клиентская ошибка, ретраи не выполняются: {}", e.getMessage());
//                throw e;
//            } catch (Exception e) {
//                log.error("Неизвестная ошибка при вызове Feign-клиента: {}", e.getMessage(), e);
//                throw new RetryableRemoteServiceException("Неизвестная ошибка", e);
//            }
//        });
//
//        Transaction transaction = transactionMapper.toEntity(transactionDTO);
//        Transaction savedTransaction = transactionRepository.save(transaction);
//        return transactionMapper.toDTO(savedTransaction);
//    }
//
//    public List<TransactionDTO> getAllTransactions() {
//        List<Transaction> transactions = transactionRepository.findAll();
//        return transactions.stream().map(transactionMapper::toDTO).toList();
//    }
//
//    public TransactionDTO getTransactionById(Long id) {
//
//        return transactionRepository.findById(id)
//                .map(transactionMapper::toDTO)
//                .orElseThrow(() -> new NotFoundException("Transaction not found"));
//    }
//
//    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
//        if (transactionRepository.existsById(id)) {
//            transactionDTO.setId(id);
//            TransactionType transactionType = transactionTypeRepository.findById(transactionDTO.getTransactionTypeId())
//                    .orElseThrow(() -> new NotFoundException("TransactionType not found"));
//            Card card = cardRepository.findById(transactionDTO.getCardId())
//                    .orElseThrow(() -> new NotFoundException("Card not found"));
//            Terminal terminal = terminalRepository.findById(transactionDTO.getTerminalId())
//                    .orElseThrow(() -> new NotFoundException("Terminal not found"));
//            ResponseCode responseCode = responseCodeRepository.findById(transactionDTO.getResponseCodeId())
//                    .orElseThrow(() -> new NotFoundException("Response code not found"));
//            Transaction transaction = transactionMapper.toEntity(transactionDTO);
//            transaction.setTransactionType(transactionType);
//            transaction.setCard(card);
//            transaction.setTerminal(terminal);
//            transaction.setResponseCode(responseCode);
//            Transaction updatedTransaction = transactionRepository.save(transaction);
//            return transactionMapper.toDTO(updatedTransaction);
//        } else {
//            throw new NotFoundException("Transaction not found");
//        }
//    }
//
//    public boolean deleteTransaction(Long id) {
//        if (transactionRepository.existsById(id)) {
//            transactionRepository.deleteById(id);
//            return true;
//        } else {
//            throw new NotFoundException("Transaction not found");
//        }
//    }
//}
