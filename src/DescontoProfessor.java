package projetoprincipiosdesign;

public class DescontoProfessor implements CalculadoraDesconto {
    @Override
    public double aplicar(double totalBruto) {
        return totalBruto * 0.85;
    }
}
