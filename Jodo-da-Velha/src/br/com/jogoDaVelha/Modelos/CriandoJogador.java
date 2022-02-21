package br.com.jogoDaVelha.Modelos;

import java.util.Scanner;

public class CriandoJogador extends Jogador {
    Scanner scanner = new Scanner(System.in);

    public CriandoJogador(int jogador) {
        super(jogador);
        this.jogador = jogador;
    }

    @Override
    public void Jogar(Tabuleiro tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }

    @Override
    public void Tentativa(Tabuleiro tabuleiro) {
        do {
            do {
                System.out.print("Linha: ");
                tentativa[0] = scanner.nextInt();

                if (tentativa[0] > 3 || tentativa[0] < 1) {
                    System.out.println("Linha inválida[1, 2 ou 3]: ");
                }
            } while (tentativa[0] > 3 || tentativa[0] < 1);

            do {
                System.out.print("Coluna: ");
                tentativa[1] = scanner.nextInt();

                if (tentativa[1] > 3 || tentativa[1] < 1) {
                    System.out.println("Coluna inválida[1, 2 ou 3]: ");
                }
            } while (tentativa[1] > 3 || tentativa[1] < 1);

            tentativa[0]--;
            tentativa[1]--;

            if (!checaTentativa(tentativa, tabuleiro)) {
                System.out.println("Local já está ocupado, tente outro ");
            }
        } while (!checaTentativa(tentativa, tabuleiro));
    }
}