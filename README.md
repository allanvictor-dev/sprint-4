# Loja Acadêmica

Projeto desenvolvido para a disciplina de Princípios de Design de Software.

O projeto consiste em um sistema simples de pedidos da Loja Acadêmica. A ideia foi pegar o código original e fazer algumas refatorações para aplicar princípios de orientação a objetos, mantendo o funcionamento da aplicação.

O sistema permite cadastrar um cliente, calcular o pedido, aplicar descontos, escolher uma forma de pagamento e definir a entrega.

## Princípios aplicados

### 1. SRP — Responsabilidade Única

A classe `PedidoService` estava fazendo várias coisas ao mesmo tempo, como calcular o pedido, salvar os dados e gerar informações do pedido.

Foi criada a classe `PedidoRepository` para cuidar da parte de salvar os pedidos. Também foi separada a lógica de cálculo para a `CalculadoraPedido`.

### 2. ISP — Segregação de Interfaces

A interface `IPagamento` tinha métodos que não eram necessários para todas as formas de pagamento.

As funcionalidades foram separadas em:

- `IPagamento` — realizar o pagamento
- `IParcelavel` — realizar parcelamento
- `IGeraBoleto` — gerar boleto

Assim, cada forma de pagamento implementa somente o que realmente precisa.

### 3. Composição sobre Herança

Antes, `PedidoService` herdava de `PagamentoCartao`, mesmo não sendo uma relação adequada entre as duas classes.

A herança foi removida e o serviço passou a receber uma implementação de `IPagamento`.

### 4. Lei de Demeter

Existia um acesso muito grande entre os objetos:

```java
pedido.getCliente().getEndereco().getCidade().getNome()
