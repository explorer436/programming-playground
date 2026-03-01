package com.my.company.mycustomclasses;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardValidationTest {

    CreditCardValidation creditCardValidation = new CreditCardValidation();

    @Test
    public void testIsValid() {
        // Based on the implementation: sum of (2 * digit) for all digits except last, then % 10 == last digit
        
        // Example: "123" -> (1*2 + 2*2) = 6. 6 % 10 = 6. Last digit 3. 6 != 3. Should be false.
        assertFalse(creditCardValidation.isValid("123"));
        
        // Example: "126" -> (1*2 + 2*2) = 6. 6 % 10 = 6. Last digit 6. 6 == 6. Should be true.
        assertTrue(creditCardValidation.isValid("126"));
    }

    @Test
    public void testValidateCards() {
        String[] swipedCreditCards = {"6724843711060148", "6745343711060149"};
        String[] invalidPrefixes = {"11", "3434", "67453", "9"};

        List<Map<String, Object>> results = creditCardValidation.validateCards(invalidPrefixes, swipedCreditCards);

        assertEquals(2, results.size());

        // Card 1: 6724843711060148
        // Allowed: true (doesn't start with 11, 3434, 67453, 9)
        // Valid: true (Sum of first 15 digits is 54. 54 * 2 = 108. 108 % 10 = 8. Last digit is 8.)
        Map<String, Object> card1 = results.get(0);
        assertEquals("6724843711060148", card1.get("card"));
        assertEquals(true, card1.get("isAllowed"));
        assertEquals(true, card1.get("isValid"));

        // Card 2: 6745343711060149
        // Allowed: false (starts with 67453)
        // Valid: false
        Map<String, Object> card2 = results.get(1);
        assertEquals("6745343711060149", card2.get("card"));
        assertEquals(false, card2.get("isAllowed"));
        assertEquals(false, card2.get("isValid"));
    }

    @Test
    public void testValidateCardsWithNulls() {
        assertNotNull(creditCardValidation.validateCards(null, null));
        assertTrue(creditCardValidation.validateCards(null, null).isEmpty());
        
        String[] cards = {"126"};
        List<Map<String, Object>> results = creditCardValidation.validateCards(null, cards);
        assertEquals(1, results.size());
        assertEquals(true, results.get(0).get("isAllowed"));
        assertEquals(true, results.get(0).get("isValid"));
    }
}
