package ro.tuc;

import junit.framework.TestCase;
import org.junit.Test;

public class OperationTest extends TestCase {
    public Polinom P1;
    public Polinom P2;

    public void setUp() {
        P1 = new Polinom("x^2");
        P2 = new Polinom("x^1");
    }

    @Test
    public void testAddition() {
        Operation o = new Operation();
        assertEquals("1.0x^2 + 1.0x^1", o.addition(P1, P2).toString());
    }

    @Test
    public void testSubstraction() {
        Operation o = new Operation();
        assertEquals("1.0x^2 - 1.0x^1", o.substraction(P1, P2).toString());
    }

    @Test
    public void testMultiply() {
        Operation o = new Operation();
        assertEquals("1.0x^3", o.multiplication(P1, P2).toString());
    }

    @Test
    public void testDivide() throws IncorrectPolynomException {
        Operation o = new Operation();
        P1 = new Polinom("x^3-2x^2+6x^1-5");
        P2 = new Polinom("x^2-1");
        assertEquals("1.0x^1 - 2.0x^0  rest: 7.0x^1 - 7.0x^0", o.division(P1, P2).toString());
    }

    @Test
    public void testDerivation() {
        Operation o = new Operation();
        assertEquals("2.0x^1", o.derivation(P1).toString());
    }

    @Test
    public void testIntegration() {
        Operation o = new Operation();
        assertEquals("0.5x^2", o.integration(P2).toString());
    }

    @Test
    public void testAdditionFalse() {
        Operation o = new Operation();
        assertEquals("1.0x2 + 1.0x1", o.addition(P1, P2).toString());
    }

    @Test
    public void testIntegrationFalse() {
        Operation o = new Operation();
        assertEquals("0.3x^3", o.integration(P1).toString());
    }
}
