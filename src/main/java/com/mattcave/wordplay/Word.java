package com.mattcave.wordplay;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Thin wrapper around a String to add CharGroup functionality.
 */
public class Word implements CharGroup {

    private String word;
    private Map<Character, Integer> charCounts;

    public Word(String word) {
        Objects.requireNonNull(word, "'word' must not be null");
        this.word = word;

        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : word.toCharArray()) {
            cnts.merge(c, 1, (prev, one) -> prev + one);
        }
        charCounts = Collections.unmodifiableMap(cnts);
    }

    /** {@inheritDoc} */
    public Map<Character, Integer> charCounts() {
        return charCounts;
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Word)) {
            return false;
        }

        Word other = (Word) obj;
        return Objects.equals(this.word, other.word);
    }
}
