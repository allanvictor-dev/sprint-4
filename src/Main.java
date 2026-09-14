package projetoprincipiosdesign;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LOJA ACADÊMICA ===");

        Cliente cliente = new Cliente(
            "Ana",
            new Endereco(
                "Rua das Flores",
                new Cidade("Belo Horizonte")
            )
        );

        Pedido pedido = new Pedido(
            cliente,
            List.of(
                new ItemPedido("Livro de Engenharia de Software", 120.0, 1),
                new ItemPedido("Caderno", 20.0, 2)
            )
        );

        PedidoService servico = new PedidoService(new CalculadoraPedido(), new PedidoRepository());
        CalculadoraDesconto desconto = new DescontoAluno();
        IPagamento pagamento = new PagamentoCartao();

        System.out.println();
        System.out.println("Cidade de entrega:");
        System.out.println(servico.obterCidadeEntrega(pedido));

        System.out.println();
        System.out.println("Total com desconto:");
        double total = servico.calcularTotal(pedido, desconto);
        System.out.printf("R$ %.2f%n", total);

        System.out.println();
        System.out.println("Entrega:");

        Entrega entrega = new EntregaRetiradaLoja();
        if (entrega.isDisponivel(total)) {
            System.out.printf("Frete: R$ %.2f%n", entrega.calcularFrete(total));
        } else {
            System.out.println("Retirada na loja indisponível para este total, usando entrega padrão.");
            entrega = new EntregaPadrao();
            System.out.printf("Frete: R$ %.2f%n", entrega.calcularFrete(total));
        }

        System.out.println();
        System.out.println("Pagamento:");
        servico.finalizarPedido(pedido, desconto, pagamento);

        System.out.println();
        System.out.println("Programa executado com sucesso.");
    }
}
