package com.my.company.mycustomclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditCardValidation {

    public List<Map<String, Object>> validateCards(
            String[] bannedPrefixes, String[] cardsToValidate) {
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

        Map<String, Object> map;
        if (null != cardsToValidate) {

            for (String swipedCard : cardsToValidate) {
                boolean isAllowed = true;

                if (null != bannedPrefixes) {
                    for (String banned : bannedPrefixes) {
                        if (swipedCard.startsWith(banned)) {
                            isAllowed = false;
                            break;
                        }
                    }
                }

                boolean isValid = isValid(swipedCard);

                map = new HashMap<>();
                map.put("card", swipedCard);
                map.put("isValid", isValid);
                map.put("isAllowed", isAllowed);

                result.add(map);
            }
        }
        return result;
    }

    public boolean isValid(String ccNumber) {
        int sum = 0;

        for (int i = 0; i < ccNumber.length() - 1; i++) {
            sum = sum + (2 * Integer.parseInt(String.valueOf(ccNumber.charAt(i))));
        }

        return ((sum % 10) == Integer.parseInt(String.valueOf(ccNumber.charAt(ccNumber.length() - 1))));
    }
}
