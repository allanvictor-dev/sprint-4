package projetoprincipiosdesign;

public class DescontoFuncionario implements CalculadoraDesconto {
    @Override
    public double aplicar(double totalBruto) {
        return totalBruto * 0.80;
    }
}
