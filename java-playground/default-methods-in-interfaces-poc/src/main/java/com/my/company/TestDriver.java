package com.my.company;

import com.my.company.defaultinterfaces.Card;
import com.my.company.defaultinterfaces.comparators.SortByRankThenSuit;
import com.my.company.defaultinterfaces.impl.PlayingCard;
import com.my.company.defaultinterfaces.impl.StandardDeck;

import java.util.Comparator;

/**
 * Hello world!
 */
public class TestDriver {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        StandardDeck myDeck = StandardDeck.builder()
                .build();

        myDeck.addCard(
                PlayingCard.builder()
                        .rank(Card.Rank.QUEEN)
                        .suit(Card.Suit.SPADES)
                        .build()

        );
        myDeck.addCard(
                PlayingCard.builder()
                        .rank(Card.Rank.KING)
                        .suit(Card.Suit.HEARTS)
                        .build()
        );
        myDeck.shuffle();

        // This approach is too verbose; it would be better if you could specify just the sort criteria and avoid creating multiple sorting implementations.
        // Everytime we want to change the sorting behavior, we have to write a new class that implements the Comparator interface and pass it to StandardDeck.sort() method
        myDeck.sort(new SortByRankThenSuit());
        System.out.println("myDeck after sorting by rank and then by suit: " + myDeck.deckToString());


        // From here on, lets not create multiple sorting implementations but still specify different sort criteria whenever we want.

        // Because the interface Comparator is a functional interface, you can use a lambda expression as an argument for the sort method.
        // This eliminates the need to write a new class that implements the Comparator interface everytime we want to change the comparison strategy
        // In this example, the lambda expression compares two integer values.


        // Suppose that you want to sort the deck of playing cards by rank, regardless of suit.
        myDeck.sort(
                (firstCard, secondCard) ->
                        firstCard.getRank().value() - secondCard.getRank().value()
        );
        System.out.println("myDeck after sorting cards by rank regardless of suit using lambda expression: " + myDeck.deckToString());

        // It would be simpler for your developers if they could create a Comparator instance by invoking the method Card.getRank only.
        // In particular, it would be helpful if your developers could create a Comparator instance that compares any object that can return a numerical value from a method such as getValue or hashCode.
        // The Comparator interface has been enhanced with this ability with the static method comparing.
        // The Comparator interface has been enhanced with other versions of the static method comparing such as comparingDouble and comparingLong that enable you to create Comparator instances that compare other data types.
        // The Comparator interface has been enhanced with other versions of the default method thenComparing (such as thenComparingDouble and thenComparingLong) that enable you to build Comparator instances that compare other data types.

        myDeck.sort(Comparator.comparing((card) -> card.getRank()));
        System.out.println("myDeck after sorting cards by rank regardless of suit with comparator created by getRank() method: " + myDeck.deckToString());

        // using method reference
        myDeck.sort(Comparator.comparing(Card::getRank));
        System.out.println("myDeck after sorting cards by rank regardless of suit with comparator created from method reference: " + myDeck.deckToString());

        // Suppose that you want to sort the deck of playing cards by suit, regardless of rank.
        myDeck.sort(
                (firstCard, secondCard) ->
                        firstCard.getSuit().value() - secondCard.getSuit().value()
        );
        System.out.println("myDeck after sorting cards by suit regardless of rank: " + myDeck.deckToString());


        // sort the deck of playing cards first by rank, and then by suit
        myDeck.sort(
                (firstCard, secondCard) -> {
                    int compare =
                            firstCard.getRank().value() - secondCard.getRank().value();
                    if (compare != 0)
                        return compare;
                    else
                        return firstCard.getSuit().value() - secondCard.getSuit().value();
                }
        );
        System.out.println("myDeck after sorting by rank and then by suit using lambda expression: " + myDeck.deckToString());

        // Doing the same thing with a series of Comparator instances
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("myDeck after sorting by rank and then by suit using a series of Comparator instances: " + myDeck.deckToString());

        // Suppose we like to create a Comparator instance that enables them to sort a collection of objects in reverse order.
        // For example, how would you sort the deck of playing cards first by descending order of rank, from Ace to Two (instead of from Two to Ace)?
        // As before, you could specify another lambda expression.
        // However, it would be simpler for your developers if they could reverse an existing Comparator by invoking a method.
        // The Comparator interface has been enhanced with this ability with the default method reversed:

        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .reversed()
                        .thenComparing(Comparator.comparing(Card::getSuit)));
        System.out.println("myDeck after sorting in reverse order or rank and then by suit: " + myDeck.deckToString());
    }
}
