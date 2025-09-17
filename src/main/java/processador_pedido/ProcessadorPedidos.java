package processador_pedido;

public class ProcessadorPedidos {
    private final ValidadorPedido validadorPedido;
    private final CalculadoraFrete calculadoraFrete;
    private final ServicoEntrega servicoEntrega;

    public ProcessadorPedidos(ValidadorPedido validadorPedido, CalculadoraFrete calculadoraFrete, ServicoEntrega servicoEntrega) {
        this.validadorPedido = validadorPedido;
        this.calculadoraFrete = calculadoraFrete;
        this.servicoEntrega = servicoEntrega;
    }

    public ResultadoPedido processarPedido(Pedido pedido) {
        if(!validadorPedido.validar(pedido)) {
            return new ResultadoPedido(false, null, 0);
        }

        double frete = calculadoraFrete.calcular(pedido.getDestination(), pedido.getItens().size());
        double valorTotal = pedido.getPrice() + frete;

        String codigoRastreamento = servicoEntrega.agendar(pedido, valorTotal);

        return new ResultadoPedido(true, codigoRastreamento, valorTotal);
    }
}
