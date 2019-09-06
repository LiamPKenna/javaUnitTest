package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class BinTest {

    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
        bin.restock("Cheetos", 1, 50, 100);
        bin.restock("Daritos", 1, 50, 100);
    }

    @Test
    public void whenEmptyPriceIsZero() throws Exception {
        assertEquals(0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() throws Exception {
        assertNull(bin.getItemName());
    }

    @Test
    public void overstockingNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");
        bin.restock("Fritos", 2600, 50, 100);
    }
}