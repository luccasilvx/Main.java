package codigo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int vitoriasJogador = 0;
        int vitoriasComputador = 0;
        int empates = 0;

        System.out.println("Bem-vindo ao Jokenpô!");

        for (int rodada = 1; rodada <= 5; rodada++) {
            System.out.println("\nRodada " + rodada);
            System.out.println("Escolha entre: (1) Pedra, (2) Papel, (3) Tesoura");
            int escolhaJogador = scanner.nextInt();

            if (escolhaJogador < 1 || escolhaJogador > 3) {
                System.out.println("Escolha inválida! Por favor, escolha entre 1, 2 ou 3.");
                rodada--;
                continue;
            }

            String[] opcoes = {"Pedra", "Papel", "Tesoura"};
            String escolhaTexto = opcoes[escolhaJogador - 1];
            String escolhaComputadorTexto = opcoes[random.nextInt(3)];

            System.out.println("Você escolheu: " + escolhaTexto);
            System.out.println("O computador escolheu: " + escolhaComputadorTexto);

            String resultado = determinarResultado(escolhaTexto, escolhaComputadorTexto);
            System.out.println(resultado);

            if (resultado.equals("Você venceu!")) {
                vitoriasJogador++;
            } else if (resultado.equals("O computador venceu!")) {
                vitoriasComputador++;
            } else {
                empates++;
            }

            exibirPlacar(vitoriasJogador, vitoriasComputador, empates);
        }

        exibirResultadoFinal(vitoriasJogador, vitoriasComputador, empates);

        System.out.println("\nDeseja jogar novamente? (S/N)");
        String jogarNovamente = scanner.next();
        if (!jogarNovamente.equalsIgnoreCase("S")) {
            System.out.println("Obrigado por jogar!");
        } else {
            main(null);
        }

        scanner.close();
    }

    public static String determinarResultado(String escolhaJogador, String escolhaComputador) {
        if (escolhaJogador.equals(escolhaComputador)) {
            return "Empate!";
        } else if ((escolhaJogador.equals("Pedra") && escolhaComputador.equals("Tesoura")) ||
                (escolhaJogador.equals("Papel") && escolhaComputador.equals("Pedra")) ||
                (escolhaJogador.equals("Tesoura") && escolhaComputador.equals("Papel"))) {
            return "Você venceu!";
        } else {
            return "O computador venceu!";
        }
    }

    public static void exibirPlacar(int vitoriasJogador, int vitoriasComputador, int empates) {
        System.out.println("Placar:");
        System.out.println("Jogador: " + vitoriasJogador + " vitórias");
        System.out.println("Computador: " + vitoriasComputador + " vitórias");
        System.out.println("Empates: " + empates);
    }

    public static void exibirResultadoFinal(int vitoriasJogador, int vitoriasComputador, int empates) {
        if (vitoriasJogador > vitoriasComputador) {
            System.out.println("Parabéns! Você venceu o jogo!");
        } else if (vitoriasComputador > vitoriasJogador) {
            System.out.println("O computador venceu o jogo. Tente novamente!");
        } else {
            System.out.println("O jogo terminou em empate!");
        }
        System.out.println("Número total de vitórias do jogador: " + vitoriasJogador);
        System.out.println("Número total de vitórias do computador: " + vitoriasComputador);
        System.out.println("Número total de empates: " + empates);
    }
}
