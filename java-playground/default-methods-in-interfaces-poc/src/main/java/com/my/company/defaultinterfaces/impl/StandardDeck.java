package com.my.company.defaultinterfaces.impl;

import com.my.company.defaultinterfaces.Card;
import com.my.company.defaultinterfaces.Deck;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class StandardDeck implements Deck {

    private List<Card> entireDeck;

    @Override
    public List<Card> getCards() {
        return entireDeck;
    }

    @Override
    public Deck deckFactory() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addCard(Card card) {
        if (CollectionUtils.isEmpty(entireDeck))
        {
            entireDeck = new ArrayList<>();
        }
        entireDeck.add(card);
    }

    @Override
    public void addCards(List<Card> cards) {

    }

    @Override
    public void addDeck(Deck deck) {

    }

    @Override
    public void shuffle() {

    }

    public void sort() {
        Collections.sort(entireDeck);
    }

    public void sort(Comparator<Card> c) {
        Collections.sort(entireDeck, c);
    }

    @Override
    public String deckToString() {
        return entireDeck.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining(", ", "", ""));
    }

    @Override
    public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
        return null;
    }
}
