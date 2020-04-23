package com.stockminer.knightgame;

import com.stockminer.knightgame.contract.Fighter;

public class Knight implements Fighter {
    private String name;
    private Integer life;

    public Knight(String name) {
        this.name = name;
        this.life = 100;
    }

    public String getName() {
        return name;
    }

    public Boolean isAlive() {
        return life >= 1;
    }

    public void fight(Fighter fighter, Integer damage) {
        fighter.setDamageAmount(damage);
    }

    public void setDamageAmount(Integer damageAmount) {
        life-=damageAmount;
    }

    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                '}';
    }
}
