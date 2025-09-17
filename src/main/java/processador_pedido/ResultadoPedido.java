package processador_pedido;

public class ResultadoPedido {
    private final boolean sucesso;
    private final String codigoRastreamento;
    private final double valorTotal;

    public ResultadoPedido (boolean sucesso, String codigoRastreamento, double valorTotal) {
        this.sucesso = sucesso;
        this.codigoRastreamento = codigoRastreamento;
        this.valorTotal = valorTotal;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
