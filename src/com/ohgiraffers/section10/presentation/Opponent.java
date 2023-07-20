package com.ohgiraffers.section10.presentation;

public class Opponent implements Skill {
    private String name;
    private int frozenNum;
    private int turn;
    private int health;


    Opponent(String name) {
        this.name = name;
        this.health = 100;
        this.turn= 30;
    }

    @Override
    public void sword() {
        System.out.println(name + "이(가) 할퀴기를 시전합니다.");
        System.out.println("당신에게 15의 피해를 주었습니다.");
    }

    @Override
    public void heal() {

    }

    //    @Override
//    public void sword2() {
//        System.out.println(name + "이(가) 꼬리치기를 시전합니다.");
//        System.out.println("당신에게 25의 피해를 주었습니다.");
//    }
    @Override
    public void magic() {
        int num = (int) (Math.random() * 10) + 1;
        if (num == 1 || num == 2 || num == 3) {
            System.out.println("마법이 빗나갔습니다.");
        } else {
            frozenNum = 1;

            System.out.println(name + "이(가) 얼어붙었습니다. 3턴 동안 움직이지 못합니다.");
        }
    }

    public void stunned() {
        if (turn > 0) {;
            System.out.println(name + "는 스턴상태 입니다.");
        } else {
            frozenNum = 2;
            System.out.println(name + "이(가) 깨어났습니다.");
        }
    }

    void takeDamage(int damage) {
        health -= damage;
        if (health == 0) {
            System.out.println(name + "이(가) 기절했습니다. 게임 오버!");
        } else {
            System.out.println(name + "의 체력: " + health);
        }
    }

    void takeTurn(int damage) {
        turn -= damage;

    }


    boolean isAlive() {
        return health > 0;
    }

    String getName() {
        return name;
    }

    public boolean isFrozen() {
        return frozenNum == 1;

    }
}
