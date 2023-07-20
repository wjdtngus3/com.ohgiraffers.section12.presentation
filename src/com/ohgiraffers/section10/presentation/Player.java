package com.ohgiraffers.section10.presentation;
public class Player implements Skill {

    private String name;
    private int health;

    Player(String name) {
        this.name = name;
        this.health = 100;
    }

    @Override
    public void sword() {
        System.out.println(name + "이(가) 칼질을 시전합니다.");
        System.out.println("상대방에게 10의 피해를 주었습니다.");
    }

    @Override
    public void heal() {
        System.out.println(name + "이(가) 체력을 회복합니다.");
        System.out.println(name + "이(가) 체력을 10 회복했습니다.");
    }

    @Override
    public void magic() {
        System.out.println(name + "이(가) 얼음마법을 시전합니다.");
    }


    void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + "이(가) 기절했습니다. 게임 오버!");
        } else {
            System.out.println(name + "의 체력: " + health);
        }
    }

    public int returnHealth(int health){
        return this.health=100;
    }


    void gainHealth(int healing){
        health+=healing;
    }
    boolean isAlive() {
        return health > 0;
    }

    String getName() {
        return name;
    }
}