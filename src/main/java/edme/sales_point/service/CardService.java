package edme.sales_point.service;

import edme.sales_point.dto.CardDto;
import edme.sales_point.mapper.CardMapper;
import edme.sales_point.model.Card;
import edme.sales_point.repository.CardRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Service
@CacheConfig(cacheNames = "Cards")
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
//    private final CacheManager cacheManager;

    public CardDto createCard(CardDto cardDTO) {
        Card card = cardMapper.toEntity(cardDTO);
        Card savedCard = cardRepository.save(card);
        return cardMapper.toDTO(savedCard);
    }
//    @Cacheable(value = "cards", key = "'allCards'")
    @Cacheable()
    public List<CardDto> getAllCards() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map(cardMapper::toDTO).toList();
    }

    //    @Cacheable(value = "card", key = "#id")
    @Cacheable(key = "#id")
    public Optional<CardDto> getCardById(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.map(cardMapper::toDTO);
    }

    public CardDto updateCard(Long id, CardDto cardDTO) {
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
