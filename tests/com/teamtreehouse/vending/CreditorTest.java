package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() {

        creditor.addFunds(25);
        creditor.addFunds(25);

        assertEquals(50,creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() {
        creditor.addFunds(250);

        int change = creditor.refund();

        assertEquals(250, change);
    }

    @Test
    public void refundingSetsAvailableFundsToZero() {
        creditor.addFunds(250);

        creditor.refund();

        assertEquals(0, creditor.getAvailableFunds());

    }
}