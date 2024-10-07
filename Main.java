import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();

        System.out.print("Digite o código do produto: ");
        produto.setCodigo(scanner.nextLine());

        System.out.print("Digite o nome do produto: ");
        produto.setNome(scanner.nextLine());

        System.out.print("Digite o tamanho/peso do produto: ");
        produto.setTamanhoOuPeso(scanner.nextLine());

        System.out.print("Digite a cor do produto: ");
        produto.setCor(scanner.nextLine());

        System.out.print("Digite o valor do produto: R$ ");
        produto.setValor(scanner.nextDouble());

        System.out.print("Digite a quantidade em estoque: ");
        produto.setQuantidadeEmEstoque(scanner.nextInt());

        System.out.println("\nIniciando venda...");
        System.out.print("Digite a quantidade que desejs vender: ");
        int quantidadeVendida = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Digite o método de pagamento (Pix, Espécie, Transferência, Débito, Crédito): ");
        String metodoPagamento = scanner.nextLine();

        boolean vendaRealizada = produto.realizarVenda(quantidadeVendida, metodoPagamento);

        if (vendaRealizada) {
            System.out.println("Venda realizada com sucesso.");
            System.out.println("Quantidade restante em estoque: " + produto.getQuantidadeEmEstoque());
        } else {
            System.out.println("Venda não realizada.");
        }

        scanner.close();
    }
}