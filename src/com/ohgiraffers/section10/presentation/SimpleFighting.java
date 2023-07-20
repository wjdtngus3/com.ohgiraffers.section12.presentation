package com.ohgiraffers.section10.presentation;

import java.util.Scanner;

public class SimpleFighting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" 보스 레이드에 오신 것을 환영합니다!");

        System.out.print("플레이어의 이름을 입력하세요: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);


        Opponent opponent = new Opponent("주니어 드래곤");

        boolean gameFinished = false;

        while (!gameFinished) {
            System.out.println("\n" + player.getName() + "님, 무엇을 하시겠습니까?");
            System.out.println("1. 주먹질");
            System.out.println("2. 마법-회복");
            System.out.println("3. 마법-얼리기");
            System.out.println("4. 게임 종료");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    player.sword();
                    opponent.takeDamage(10);
                    opponent.takeTurn(10);
                    break;
                case 2:
                    player.heal();
                    player.gainHealth(20);
                    opponent.takeTurn(10);
                    break;
                case 3:
                    player.magic();
                    opponent.magic();
                    break;

                case 4:
                    gameFinished = true;
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }


            if (opponent.isAlive() && !opponent.isFrozen()) {
                int opponentAttack = (int) (Math.random() * 2) + 1;
                switch (opponentAttack) {
                    case 1:
                        opponent.sword();
                        player.takeDamage(15);
                        break;
                    case 2:
                        opponent.heal();
                        player.takeDamage(25);
                        break;
                }


            } else if (opponent.isFrozen()) {
                opponent.stunned();


            } else {
                System.out.println(opponent.getName() + "이(가) 기절했습니다! 게임에서 승리하셨습니다!");
                gameFinished = true;
            }

            if (!player.isAlive()) {
                System.out.println(player.getName() + "이(가) 기절했습니다! 게임 오버!");
                gameFinished = true;
            }


        }

        {
            System.out.println("\n게임을 종료합니다. 다시 찾아주셔서 감사합니다!");
        }
    }
}

