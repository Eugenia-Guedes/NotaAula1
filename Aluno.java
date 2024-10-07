public class Aluno {

    private String nome;

    private double nota1;

    private double nota2;

    private double nota3;


    public void setNome(String nomeAluno){
        this.nome = nomeAluno;
    }

    public void setNota1(double primeiraNota) {
        this.nota1 = primeiraNota;
    }
    public void setNota2(double segundaNota) {
        this.nota2 = segundaNota;
    }
    public void setNota3(double terceiraNota) {
        this.nota3 = terceiraNota;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3)/ 3;
    }

    public String situacao() {
        double media = calcularMedia();
        if (media >= 70) {
            return "Aprovado";
        } else if (media < 40) {
            return "Reprovado";
        } else {
            return "Na final";
        }
    }

    public String getNome() {
        return nome;
    }

    public double getMedia() {
        return calcularMedia();
    }
}
