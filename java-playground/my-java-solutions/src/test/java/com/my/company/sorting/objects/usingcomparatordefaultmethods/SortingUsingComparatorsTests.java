package com.my.company.sorting.objects.usingcomparatordefaultmethods;

import com.my.company.sorting.objects.usingcomparatordefaultmethods.comparators.SortByRankThenSuit;
import com.my.company.sorting.objects.usingcomparatordefaultmethods.impl.PlayingCard;
import com.my.company.sorting.objects.usingcomparatordefaultmethods.impl.StandardDeck;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingUsingComparatorsTests {

    @Test
    public void test_sorting_using_Comparator() throws Exception {

        StandardDeck myDeck = getStandardDeck();

        // Before sorting
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());

        /**
         *   This approach is too verbose;
         *   It would be better if we could specify just the sort criteria and avoid creating multiple sorting implementations.
         *   Everytime we want to change the sorting behavior,
         *   we have to write a new class that implements the Comparator interface;
         *   And pass it to StandardDeck.sort() method
         */
        myDeck.sort(new SortByRankThenSuit());

        // After sorting
        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(1).getSuit());
    }

    // From here on, lets not create multiple sorting implementations but still specify different sort criteria whenever we want.

    @Test
    public void test_sorting_using_lambda_expression() throws Exception {

        StandardDeck myDeck = getStandardDeck();

        // Before sorting
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());

        /**
         *   Because the interface Comparator is a functional interface, you can use a lambda expression as an argument for the sort method.
         *   This eliminates the need to write a new class that implements the Comparator interface everytime we want to change the comparison strategy
         *   In this example, the lambda expression compares two integer values.
         */
        myDeck.sort(
                (firstCard, secondCard) ->
                        firstCard.getRank().value() - secondCard.getRank().value()
        );

        // After sorting by Rank
        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(1).getSuit());

        // Suppose that you want to sort the deck of playing cards by suit, regardless of rank.
        myDeck.sort(
                (firstCard, secondCard) ->
                        firstCard.getSuit().value() - secondCard.getSuit().value()
        );

        // After sorting by Suit
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());

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

        // After sorting by Rank and then by Suit
        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(1).getSuit());
    }

    /**
     *   It would be simpler for your developers if they could create a Comparator instance by invoking the method Card.getRank only.
     *   In particular, it would be helpful if your developers could create a Comparator instance that compares any object that can return a numerical value from a method such as getValue or hashCode.
     *   The Comparator interface has been enhanced with this ability with the static method comparing.
     *   The Comparator interface has been enhanced with other versions of the static method comparing such as comparingDouble and comparingLong that enable you to create Comparator instances that compare other data types.
     *   The Comparator interface has been enhanced with other versions of the default method "thenComparing()" (such as thenComparingDouble and thenComparingLong) that enable you to build Comparator instances that compare other data types.
     *
     *   https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
     */

    @Test
    public void test_sorting_using_Comparator_comparing_with_lambda_expression() throws Exception {

        StandardDeck myDeck = getStandardDeck();

        // Before sorting
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());

        myDeck.sort(Comparator.comparing((card) -> card.getRank()));

        // After sorting
        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(1).getSuit());
    }

    @Test
    public void test_sorting_using_Comparator_comparing_with_method_reference() throws Exception {

        StandardDeck myDeck = getStandardDeck();

        // Before sorting
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());

        myDeck.sort(Comparator.comparing(Card::getRank));

        // After sorting
        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(1).getSuit());
    }

    @Test
    public void test_sorting_using_Comparator_comparing_chaining() throws Exception {

        StandardDeck myDeck = getStandardDeck();

        // Before sorting
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());

        // sorting by Rank and then by Suit
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .thenComparing(Card::getSuit));

        // After sorting by Rank and then by Suit
        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(1).getSuit());

        /**
         *   Suppose we like to create a Comparator instance that enables them to sort a collection of objects in reverse order.
         *   For example, how would you sort the deck of playing cards first by descending order of rank, from Ace to Two (instead of from Two to Ace)?
         *   As before, you could specify another lambda expression.
         *   However, it would be simpler for your developers if they could reverse an existing Comparator by invoking a method.
         *   The Comparator interface has been enhanced with this ability with the default method "reversed()"
         */
        
        myDeck.sort(
                Comparator.comparing(Card::getRank)
                        .reversed()
                        .thenComparing(Card::getSuit));

        // After sorting by Rank and then by Suit
        assertEquals(getKingOfHearts().getRank(), myDeck.getCards().get(0).getRank());
        assertEquals(getKingOfHearts().getSuit(), myDeck.getCards().get(0).getSuit());

        assertEquals(getQueenOfSpades().getRank(), myDeck.getCards().get(1).getRank());
        assertEquals(getQueenOfSpades().getSuit(), myDeck.getCards().get(1).getSuit());
    }

    private static StandardDeck getStandardDeck() {
        StandardDeck myDeck = StandardDeck.builder().build();

        myDeck.addCard(
                PlayingCard.builder()
                        .rank(Card.Rank.KING)
                        .suit(Card.Suit.HEARTS)
                        .build()
        );
        myDeck.addCard(
                PlayingCard.builder()
                        .rank(Card.Rank.QUEEN)
                        .suit(Card.Suit.SPADES)
                        .build()

        );

        return myDeck;
    }

    private static PlayingCard getKingOfHearts() {
        return PlayingCard.builder()
                .rank(Card.Rank.KING)
                .suit(Card.Suit.HEARTS)
                .build();
    }

    private static PlayingCard getQueenOfSpades() {
        return PlayingCard.builder()
                .rank(Card.Rank.QUEEN)
                .suit(Card.Suit.SPADES)
                .build();
    }

}
