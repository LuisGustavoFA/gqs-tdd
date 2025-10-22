package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PedidoServiceTest {

    @Test
    public void deveFazerPedidoServiceComEmailService() {
        //arrange - create
        EmailService emailServiceMock = mock(EmailService.class);
        EstoqueService estoqueServiceMock = mock(EstoqueService.class);

        //arrange - config
        when(emailServiceMock.enviarEmail(anyString(), anyString())).thenReturn(true);
        when(estoqueServiceMock.verificarEstoque(anyString(), anyInt())).thenReturn(true);

        //arrange - create pedido 
        PedidoService pedidoService = new PedidoService(emailServiceMock, estoqueServiceMock);

        //action
        String resultado = pedidoService.finalizarPedido("c@e.com", "SKU-1", 1);

        //assert
        assertEquals("sucesso", resultado);
        verify(emailServiceMock, times(1)).enviarEmail("c@e.com", "Pedido finalizado: SKU-1");
    }

    @Test
    public void deveFazerPedidoServiceComEmailServiceFalso() {
        //arrange - create
        EmailService emailServiceMock = mock(EmailService.class);
        EstoqueService estoqueServiceMock = mock(EstoqueService.class);

        //arrange - config
        when(emailServiceMock.enviarEmail(anyString(), anyString())).thenReturn(false);
        when(estoqueServiceMock.verificarEstoque(anyString(), anyInt())).thenReturn(true);

        //arrange - create pedido 
        PedidoService pedidoService = new PedidoService(emailServiceMock, estoqueServiceMock);

        //action
        String resultado = pedidoService.finalizarPedido("c@e.com", "SKU-1", 1);

        //assert
        assertEquals("falhou", resultado);
    }

    /*
     * Q8 — Mockando dependência de estoque (4 pts — Avançado)
        Use Mockito para mockar EstoqueService e testar o caminho "sem_estoque" quando
        verificarEstoque retorna false . Asserte que finalizarPedido retorna "sem_estoque" e
        não chama emailService.enviarEmail() (use verify(emailService, never()) )
     */

    @Test
    public void deveCriarPedidoSemEstoque() {
        //arrange - create
        EmailService emailServiceMock = mock(EmailService.class);
        EstoqueService estoqueServiceMock = mock(EstoqueService.class);

        //arrange - config
        when(estoqueServiceMock.verificarEstoque(anyString(), anyInt())).thenReturn(false);

        //arrange - create pedido 
        PedidoService pedidoService = new PedidoService(emailServiceMock, estoqueServiceMock);

        //action
        String resultado = pedidoService.finalizarPedido("c@e.com", "SKU-1", 1);

        //assert
        assertEquals("sem_estoque", resultado);
        verify(emailServiceMock, never()).enviarEmail(anyString(), anyString());
    }
}
