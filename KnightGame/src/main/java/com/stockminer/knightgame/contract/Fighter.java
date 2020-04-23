package com.stockminer.knightgame.contract;

public interface Fighter {
    Boolean isAlive();
    String getName();
    void setDamageAmount(Integer damageAmount);
    void fight(Fighter fighter, Integer damage);
}
