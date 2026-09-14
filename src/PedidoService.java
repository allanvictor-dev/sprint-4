package projetoprincipiosdesign;

public class PedidoService {

    private final CalculadoraPedido calculadora;
    private final PedidoRepository repository;

    public PedidoService(CalculadoraPedido calculadora, PedidoRepository repository) {
        this.calculadora = calculadora;
        this.repository = repository;
    }

    public double calcularTotal(Pedido pedido, CalculadoraDesconto desconto) {
        return calculadora.calcularTotal(pedido, desconto);
    }

    public String obterCidadeEntrega(Pedido pedido) {
        return pedido.getCidadeEntrega();
    }

    public void finalizarPedido(Pedido pedido, CalculadoraDesconto desconto, IPagamento pagamento) {
        double total = calcularTotal(pedido, desconto);

        repository.salvarPedidos(pedido, total);

        System.out.println("Gerando resumo do pedido...");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.printf("Total: R$ %.2f%n", total);

        pagamento.pagar(total);

        System.out.println(
            "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
        );
    }
}
