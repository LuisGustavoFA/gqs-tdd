package processador_pedido;

import calculadora.Calculadora;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessadorPedidosTest {
    @Mock
    private ValidadorPedido validadorPedido;

    @Mock
    private CalculadoraFrete calculadoraFrete;

    @Mock
    private ServicoEntrega servicoEntrega;

    @InjectMocks
    private ProcessadorPedidos processadorPedidos;

    @Test
    public void deveProcessarPedidos () {
        //Arrange
        Pedido pedido = new Pedido(1, "Porto Alegre", 100, Arrays.asList("item1", "item2"));

        when(validadorPedido.validar(pedido)).thenReturn(true);
        when(calculadoraFrete.calcular("Porto Alegre", 2)).thenReturn(13.0);
        when(servicoEntrega.agendar(pedido, 113.0)).thenReturn("TRACK123");

        //Action
        ResultadoPedido resultadoPedido = processadorPedidos.processarPedido(pedido);

        //Assert
        assertTrue(resultadoPedido.isSucesso());
        assertEquals(113.0, resultadoPedido.getValorTotal());
        assertEquals("TRACK123", resultadoPedido.getCodigoRastreamento());

        //Verificar ordem das chamadas
        InOrder inOrder = inOrder(validadorPedido, calculadoraFrete, servicoEntrega);
        inOrder.verify(validadorPedido).validar(pedido);
        inOrder.verify(calculadoraFrete).calcular("Porto Alegre", 2);
        inOrder.verify(servicoEntrega).agendar(pedido, 113.0);
    }

    @Test
    public void deveRejeitarPedidoInvalido() {
        //Arrange
        Pedido pedido = new Pedido(2, "", -10.0, Arrays.asList());

        when(validadorPedido.validar(pedido)).thenReturn(false);

        //Action
        ResultadoPedido resultadoPedido = processadorPedidos.processarPedido(pedido);

        //Assert
        assertFalse(resultadoPedido.isSucesso());
        assertNull(resultadoPedido.getCodigoRastreamento());
        assertEquals(0, resultadoPedido.getValorTotal());

        verify(validadorPedido).validar(pedido);
        verify(calculadoraFrete, never()).calcular(anyString(), anyDouble());
        verify(servicoEntrega, never()).agendar(any(Pedido.class), anyDouble());
    }
}
