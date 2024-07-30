package com.my.company.sorting.usingcomparatordefaultmethods.impl;

import com.my.company.sorting.usingcomparatordefaultmethods.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class PlayingCard implements Card {

    private Suit suit;
    private Rank rank;

    public int hashCode() {
        return ((suit.value()-1)*13)+rank.value();
    }

    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit=" + suit +
                ", rank=" + rank +
                '}';
    }
}
