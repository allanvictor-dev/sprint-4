package projetoprincipiosdesign;

public class SemDesconto implements CalculadoraDesconto {
    @Override
    public double aplicar(double totalBruto) {
        return totalBruto;
    }
}
