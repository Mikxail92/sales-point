package edme.sales_point.controller;

import edme.sales_point.dto.CardDto;
import edme.sales_point.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales-point/cards")
public class CardController {


    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDTO) {
        CardDto createdCard = cardService.createCard(cardDTO);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CardDto>> getAllCards() {
//        log.warn("____");
        List<CardDto> cards = cardService.getAllCards();
//        log.warn(cards.toString());
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

//    @Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
        Optional<CardDto> cardDTO = cardService.getCardById(id);
        return cardDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDto> updateCard(@PathVariable Long id, @RequestBody CardDto cardDTO) {
        CardDto updatedCard = cardService.updateCard(id, cardDTO);
        return updatedCard != null ? ResponseEntity.ok(updatedCard) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        boolean isDeleted = cardService.deleteCard(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
