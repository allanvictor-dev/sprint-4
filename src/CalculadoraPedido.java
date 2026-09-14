package projetoprincipiosdesign;

public class CalculadoraPedido {

    public double calcularTotal(Pedido pedido, CalculadoraDesconto desconto) {
        double subtotal = 0.0;

        for (ItemPedido item : pedido.getItens()) {
            subtotal += item.getPreco() * item.getQuantidade();
        }

        return desconto.aplicar(subtotal);
    }
}
