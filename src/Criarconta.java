
import java.util.Random;
import java.util.Scanner;

    public class Criarconta {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            boolean criarConta = true;
             while (criarConta) {
                 System.out.print("Digite o nome do titular: ");
                 String nomeTitular = scanner.nextLine();

                 System.out.print("Digite o CPF: ");
                 String cpf = scanner.nextLine();
                 boolean cpfValido = ValidatorCPF.validarCPF(cpf);
                 if (cpfValido) {
                     System.out.print("Digite o endereço: ");
                     String endereco = scanner.nextLine();


                     Random random = new Random();
                     int numeroAgencia = random.nextInt(10000);
                     String agencia = String.format("%04d", numeroAgencia);

                     double saldo = 0.0;

                     System.out.print("Digite a profissão: ");
                     String profissao = scanner.nextLine();

                     Cliente cliente = new Cliente(nomeTitular, cpf, profissao);

                     System.out.println("Conta criada!");
                     System.out.println("Nome do titular: " + nomeTitular);
                     System.out.println("Agência: " + agencia);
                     System.out.println("Saldo: " + saldo);
                 } else {
                     System.out.println("CPF inválido. A conta não pode ser criada.");
                 }
                 boolean opcaoValida = false;
                 while (!opcaoValida) {
                     System.out.print("Deseja criar outra conta? (S/N): ");
                     String opcao = scanner.nextLine();

                     if (opcao.equalsIgnoreCase("S")) {
                         criarConta = true;
                         opcaoValida = true;
                     } else if (opcao.equalsIgnoreCase("N")) {
                         criarConta = false;
                         opcaoValida = true;
                     } else {
                         System.out.println("Opção inválida. Digite S para sim ou N para não.");
                     }
                 }
             }

            System.out.println("Programa encerrado.");
            scanner.close();
        }


}
