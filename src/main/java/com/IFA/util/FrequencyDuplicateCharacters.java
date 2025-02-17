package com.IFA.util;

import java.util.HashMap;

public class FrequencyDuplicateCharacters {
    public static void main(String[] args) {
        String text = "Learn java Programming";
        HashMap<Character, Integer> counts = new HashMap<>();

        // Count each character
        for (char ch : text.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        }

        // Print characters that appear more than once
        counts.forEach((ch, count) -> {
            if (count > 1) {
                System.out.println(ch + ": " + count);
            }
        });
    }
}

