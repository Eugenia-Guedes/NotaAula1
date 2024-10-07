import java.util.Scanner;

public class Produto {
    private String codigo;
    private String nome;
    private String tamanhoOuPeso;
    private String cor;
    private double valor;
    private int quantidadeEmEstoque;

    public void setCodigo(String codigoProduto) {
        this.codigo = codigoProduto;
    }

    public void setNome(String nomeProduto) {

        this.nome = nomeProduto;
    }

    public void setTamanhoOuPeso(String tamanhoOuPesoProduto) {

        this.tamanhoOuPeso = tamanhoOuPesoProduto;
    }

    public void setCor(String corProduto) {

        this.cor = corProduto;
    }

    public void setValor(double valorProduto) {

        this.valor = valorProduto;
    }

    public void setQuantidadeEmEstoque(int quantidade) {

        this.quantidadeEmEstoque = quantidade;
    }

    public String getCodigo() {

        return codigo;
    }

    public String getNome() {

        return nome;
    }

    public String getTamanhoOuPeso() {

        return tamanhoOuPeso;
    }

    public String getCor() {
        return cor;
    }

    public double getValor() {

        return valor;
    }

    public int getQuantidadeEmEstoque() {

        return quantidadeEmEstoque;
    }

    public boolean realizarVenda(int quantidadeVendida, String metodoPagamento) {
        if (quantidadeVendida > quantidadeEmEstoque) {
            System.out.println("Quantidade em estoque insuficiente.");
            return false;
        }

        quantidadeEmEstoque -= quantidadeVendida;

        double valorFinal = calcularValorFinal(quantidadeVendida, metodoPagamento);
        System.out.println("Valor total da venda: R$ " + valorFinal);

        if (metodoPagamento.equalsIgnoreCase("Espécie")) {
            this.calcularTroco(valorFinal);
        }
        return true;
    }

    public double calcularValorFinal(int quantidadeVendida, String metodoPagamento) {
        double valorSemDesconto = valor * quantidadeVendida;

        switch (metodoPagamento.toLowerCase()) {
            case "pix":
            case "espécie":
            case "transferência":
            case "débito":
                return valorSemDesconto * 0.95;
            case "crédito":
                System.out.println("Compra parcelada em 3x sem juros.");
                return valorSemDesconto;
            default:
                System.out.println("Método de pagamento inválido. Sem desconto aplicado.");
                return valorSemDesconto;
        }
    }

    public void calcularTroco(double valorFinal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor pago: R$ ");
        double valorPago = scanner.nextDouble();

        if (valorPago > valorFinal) {
            double troco = valorPago - valorFinal;
        } else if (valorPago == valorFinal) {
            System.out.println("Pagamento exato. Sem troco.");
        } else {
            System.out.println("Valor pago insuficiente.");
        }
    }
}


