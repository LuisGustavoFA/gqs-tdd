package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    //arrange
    public void setup () {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar() {
        //action
        int resultado = calculadora.somar(2, 3);
        //assert
        assertEquals(5, resultado);
    }

    @Test
    public void deveSubtrair() {
        //action
        int resultado = calculadora.subtrair(10, 4);
        //assert
        assertEquals(6, resultado);
    }

    @Test
    public void deveMultiplicar() {
        //action
        int resultado = calculadora.multiplicar(6, 7);
        //assert
        assertEquals(42, resultado);
    }

    @Test
    public void deveDividir() {
        //action
        double resultado = calculadora.dividir(10, 2);
        //assert
        assertEquals(5.0, resultado);
    }

    @Test
    public void deveDividirComExcecaoZero() {
        //assert
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(10, 0));
    }

    @ParameterizedTest
    @CsvSource( {
        "1, 1, 2",
        "3, 7, 10",
        "-5, 5, 0"
    })
    public void deveSomarParametrizado(int num1, int num2, int numEsperado) {
        //action
        int resultado = calculadora.somar(num1, num2);
        //assert
        assertEquals(numEsperado, resultado);
    }
}
