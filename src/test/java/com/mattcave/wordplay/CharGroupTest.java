package com.mattcave.wordplay;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Common tests for classes implementing {@link CharGroup}.
 */
public abstract class CharGroupTest {

    protected CharGroup charGroup;

    public abstract CharGroup newInstance(String chars);

    @Before
    public void setUp() {
        charGroup = newInstance("abbcccdddd");
    }


    @Test
    public void charCounts() throws Exception {

    }

    @Test
    public void containsAll() throws Exception {

    }

}
