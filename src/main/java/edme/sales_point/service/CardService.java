package edme.sales_point.service;

import edme.sales_point.dto.CardDTO;
import edme.sales_point.mapper.CardMapper;
import edme.sales_point.model.Card;
import edme.sales_point.repository.CardRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardDTO createCard(CardDTO cardDTO) {
        Card card = cardMapper.toEntity(cardDTO);
        Card savedCard = cardRepository.save(card);
        return cardMapper.toDTO(savedCard);
    }

    public List<CardDTO> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map(cardMapper::toDTO).toList();
    }

    public Optional<CardDTO> getCardById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.map(cardMapper::toDTO);
    }

    public CardDTO updateCard(Long id, CardDTO cardDTO) {
        if (cardRepository.existsById(id)) {
            cardDTO.setId(id);
            Card card = cardMapper.toEntity(cardDTO);
            Card updatedCard = cardRepository.save(card);
            return cardMapper.toDTO(updatedCard);
        } else {
            return null;  // Or throw a custom exception
        }
    }

    public boolean deleteCard(Long id) {
        if (cardRepository.existsById(id)) {
            cardRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
