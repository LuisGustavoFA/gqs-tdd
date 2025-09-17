package processador_pedido;

import java.util.List;

public class Pedido {
    private final Integer id;
    private final String destination;
    private final double price;
    private final List<String> itens;

    public Pedido (Integer id, String destination, double price, List<String> itens) {
        this.id = id;
        this.destination = destination;
        this.price = price;
        this.itens = itens;
    }

    public Integer getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getItens() {
        return itens;
    }
}
