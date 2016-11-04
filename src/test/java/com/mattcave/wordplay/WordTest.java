package com.mattcave.wordplay;

import static org.junit.Assert.*;


public class WordTest extends CharGroupTest {

    @Override
    public CharGroup newInstance(String w) {
        return new Word(w);
    }
}
