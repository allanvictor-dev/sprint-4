package projetoprincipiosdesign;

public class DescontoAluno implements CalculadoraDesconto {
    @Override
    public double aplicar(double totalBruto) {
        return totalBruto * 0.90;
    }
}
