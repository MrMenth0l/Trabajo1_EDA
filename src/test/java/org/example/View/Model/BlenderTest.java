package org.example.View.Model;

import junit.framework.TestCase;

public class BlenderTest extends TestCase {

    // Método que se ejecuta antes de cada prueba
    protected void setUp() {
        System.out.println("Preparando antes de la prueba...");
    }

    // Método que se ejecuta después de cada prueba
    protected void tearDown() {
        System.out.println("Limpiando después de la prueba...");
    }

  
    public void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    public void testSubtraction() {
        int result = 5 - 3;
        assertEquals(2, result);
    }
}
