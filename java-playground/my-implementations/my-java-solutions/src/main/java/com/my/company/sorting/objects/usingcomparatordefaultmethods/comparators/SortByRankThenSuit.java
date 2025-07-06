package com.my.company.sorting.objects.usingcomparatordefaultmethods.comparators;

import com.my.company.sorting.objects.usingcomparatordefaultmethods.Card;

import java.util.Comparator;

public class SortByRankThenSuit implements Comparator<Card> {

    @Override
    public int compare(Card firstCard, Card secondCard) {

        int compVal = firstCard.getRank().value() - secondCard.getRank().value();

        if (compVal != 0) {
            return compVal;
        } else {
            return firstCard.getSuit().value() - secondCard.getSuit().value();
        }

    }

}