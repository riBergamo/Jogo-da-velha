package br.com.jogoDaVelha.Modelos;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada = 1;
    private int vez = 1;
    private Jogador jogador1;
    private Jogador jogador2;

    public Scanner scanner = new Scanner(System.in);

    public Jogo() {
        tabuleiro = new Tabuleiro();
        iniciarJogadores();

        while (jogar());
    }

    public void iniciarJogadores() {
        if (escolherJogador() == 1) {
            this.jogador1 = new CriandoJogador(1);
            this.jogador2 = new CriandoJogador(2);
        } else {
            this.jogador1 = new CriandoJogador(2);
            this.jogador2 = new CriandoJogador(1);
        }
        System.out.println("Jogador 'O' e 'X' criados!");
    }

    private int escolherJogador() {
        int opcao = 0;

        do {
            System.out.println("1. X");
            System.out.println("2. O\n");
            System.out.print("Primeiro jogador escolhe: [1, 2] ");
            opcao = scanner.nextInt();
            if (opcao != 1 && opcao != 2) {
                System.out.println("Opção inválida! Tente novamente ");
            }
        } while (opcao != 1 && opcao != 2);

        return opcao;
    }

    public boolean jogar() {
        if (ganhou() == 0) {
            System.out.println("\n-----Rodada " + rodada + "-----");
            System.out.println("Vez do jogador " + vez());

            if (vez() == 1)) {
                jogador1.Jogar(tabuleiro);
            } else {
                jogador2.Jogar(tabuleiro);
            }

            if (empate()) {
                return false;
            }

            vez++;
            rodada++;

            return true;
        }

        if (ganhou() == -1) {
            System.out.println("\nO Jogador 'X' VENCEU!");
        } else {
            System.out.println("\nO Jogador 'O' VENCEU!");
        }

        return false;

    }

    private boolean empate() {
        if (tabuleiro.tabuleiroCompleto() && ganhou() == 0) {
            System.out.println("\nEmpate");
            return true;
        }
        return false;
    }

    public int vez() {
        if (vez%2 == 1) {
            return 1;
        }
        return 2;
    }

    public int ganhou() {
        if (tabuleiro.checaLinhas() == 1) {
            return 1;
        }
        if (tabuleiro.checaColunas() == 1) {
            return 1;
        }
        if (tabuleiro.checaDiagonais() == 1) {
            return 1;
        }

        if (tabuleiro.checaLinhas() == -1) {
            return -1;
        }
        if (tabuleiro.checaColunas() == -1) {
            return -1;
        }
        if (tabuleiro.checaDiagonais() == -1) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Jogo";
    }

}
