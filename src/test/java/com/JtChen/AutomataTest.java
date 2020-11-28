package com.JtChen;

import org.junit.Test;

import static org.junit.Assert.*;

public class AutomataTest {
    /**
     * 终态3
     */
    @Test
    public void FinalState3() {
        Automata automata = new Automata();
        assertEquals(0, automata.StateTransition(' '));
        assertEquals(1, automata.StateTransition('a'));
        assertEquals(1, automata.StateTransition('b'));
        assertEquals(1, automata.StateTransition('2'));
        assertEquals(3, automata.StateTransition('&'));
    }

    /**
     * 终态2
     */
    @Test
    public void FinalState2() {
        Automata automata = new Automata();
        assertEquals(1, automata.StateTransition('m'));
        assertEquals(1, automata.StateTransition('a'));
        assertEquals(1, automata.StateTransition('i'));
        assertEquals(1, automata.StateTransition('n'));
        assertEquals(2, automata.StateTransition('q'));
    }

    /**
     * 终态5
     */
    @Test
    public void FinalState5() {
        Automata automata = new Automata();
        assertEquals(4, automata.StateTransition('1'));
        assertEquals(4, automata.StateTransition('2'));
        assertEquals(4, automata.StateTransition('3'));
        assertEquals(4, automata.StateTransition('4'));
        assertEquals(5, automata.StateTransition('&'));
    }

    /**
     * 终态7
     */
    @Test
    public void FinalState7() {
        Automata automata = new Automata();
        assertEquals(6, automata.StateTransition('"'));
        assertEquals(6, automata.StateTransition('5'));
        assertEquals(6, automata.StateTransition('%'));
        assertEquals(6, automata.StateTransition('额'));
        assertEquals(7, automata.StateTransition('"'));
    }

    /**
     * 终态8
     */
    @Test
    public void FinalState8() {
        Automata automata = new Automata();
        assertEquals(8, automata.StateTransition(';'));
        assertEquals(8, automata.StateTransition(','));
        assertEquals(8, automata.StateTransition(':'));
    }

    /**
     * 终态10
     */
    @Test
    public void FinalState10() {
        Automata automata = new Automata();
        assertEquals(9, automata.StateTransition('<'));
        assertEquals(10, automata.StateTransition('='));
    }

    /**
     * 终态11
     */
    @Test
    public void FinalStat11() {
        Automata automata = new Automata();
        assertEquals(9, automata.StateTransition('<'));
        assertEquals(11, automata.StateTransition('-'));
    }

    /**
     * 终态13
     */
    @Test
    public void FinalState13() {
        Automata automata = new Automata();
        assertEquals(12, automata.StateTransition('额'));
        assertEquals(12, automata.StateTransition('&'));
        assertEquals(13, automata.StateTransition(' '));
    }

}