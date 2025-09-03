package calculadora;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {
    private Calculadora calculadora;

    @Before
    //arrange
    public void setup () {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar() {
        //action
        int resultado = calculadora.somar(5, 3);
        //assert
        assertEquals(8, resultado);
    }

    @Test
    public void deveSubtrair() {
        //action
        int resultado = calculadora.subtrair(5, 3);
        //assert
        assertEquals(2, resultado);
    }

    @Test
    public void deveMultiplicar() {
        //action
        int resultado = calculadora.multiplicar(5, 3);
        //assert
        assertEquals(15, resultado);
    }

    @Test
    public void deveDividir() {
        //action
        int resultado = calculadora.dividir(15, 3);
        //assert
        assertEquals(5, resultado);
    }

    @Test
    public void deveFatorar() {
        //action
        int resultado = calculadora.fatorial(5);
        //assert
        assertEquals(125, resultado);
    }
}
