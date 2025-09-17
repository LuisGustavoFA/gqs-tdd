package processador_pedido;

public interface ServicoEntrega {
    String agendar(Pedido pedido, double valorTotal);
}
