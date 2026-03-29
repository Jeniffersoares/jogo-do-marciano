import java.util.Random;
import java.util.Scanner;

public class JogoMarciano {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Random sorteio = new Random();

        int melhorPontuacao = 999;
        boolean continuar = true;

        while (continuar) {

            // Introdução
            System.out.println("\n==============================");
            System.out.println("👽 JOGO DO MARCIANO 👽");
            System.out.println("==============================");
            System.out.println("Você foi sequestrado por um marciano!");
            System.out.println("Para escapar, precisa adivinhar o número secreto.");
            System.out.println("Se errar demais... vira estagiário 🤡");
            System.out.println();

            // Escolha de dificuldade
            System.out.println("Escolha a dificuldade:");
            System.out.println("1 - Fácil (1 a 10)");
            System.out.println("2 - Médio (1 a 50)");
            System.out.println("3 - Difícil (1 a 100)");

            int opcao = entrada.nextInt();

            int maxNumero;

            if (opcao == 1) {
                maxNumero = 10;
            } else if (opcao == 2) {
                maxNumero = 50;
            } else {
                maxNumero = 100;
            }

            int numeroSecreto = sorteio.nextInt(maxNumero) + 1;

            int tentativas = 0;
            int limite = 5;
            boolean acertou = false;

            // Loop principal
            while (tentativas < limite) {

                System.out.print("\nDigite seu palpite: ");
                int palpite = entrada.nextInt();
                tentativas++;

                if (palpite == numeroSecreto) {
                    acertou = true;
                    break;
                } else if (palpite < numeroSecreto) {
                    System.out.println("Muito baixo!");
                } else {
                    System.out.println("Muito alto!");
                }
            }

            // Resultado
            if (acertou) {
                System.out.println("\nParabéns! Você acertou em " + tentativas + " tentativas!");

                if (tentativas < melhorPontuacao) {
                    melhorPontuacao = tentativas;
                    System.out.println("Novo recorde!");
                }

            } else {
                System.out.println("\nVocê perdeu!");
                System.out.println("O número era: " + numeroSecreto);
            }

            // Mostrar recorde
            if (melhorPontuacao < 999) {
                System.out.println("Melhor pontuação até agora: " + melhorPontuacao);
            }

            // Jogar novamente
            System.out.print("\nDeseja jogar novamente? (s/n): ");
            String resposta = entrada.next();

            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false;
                System.out.println("Encerrando o jogo...");
            }
        }

        entrada.close();
    }
}
