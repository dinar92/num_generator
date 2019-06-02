package com.inovus.carnum.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple matcher of a text.
 */
public class SimpleMatcher {

    /**
     * Returns a sequence of matches as a single string (concatenates all matches).
     *
     * @param regex        - regular expression.
     * @param text         - text for processing.
     * @param matchesCount - count of matches.
     * @return - single string of all matches.
     */
    protected String getMatches(String regex, String text, int matchesCount) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; matcher.find() && i <= matchesCount; i++) {
            stringBuilder.append(matcher.group());
        }

        return stringBuilder.toString();
    }
}
