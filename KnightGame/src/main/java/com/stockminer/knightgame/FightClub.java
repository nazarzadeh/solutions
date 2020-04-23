package com.stockminer.knightgame;

import com.stockminer.knightgame.contract.Fighter;

import java.util.Random;

public class FightClub<T extends Fighter> {

    private LinkedList<T> fighters;
    public FightClub(LinkedList<T> fighters) {
        this.fighters = fighters;
    }

    public void startFightClub() {
        Node<T> attacker;
        attacker = fighters.get(0);
        while (fighters.size() >= 2) {
            fight(attacker.getData(), attacker.getNext().getData());
            checkDefenderState(attacker.getNext().getData());
            attacker = attacker.getNext();
        }
        System.out.println(String.format("%s is the real Knight", fighters.get(0).getData().getName()));
    }

    private void checkDefenderState(T fighter) {
        if (!fighter.isAlive()) {
            fighters.deleteNode((T) fighter);
            System.out.println(String.format("%s dies", fighter.getName()));
        }
    }

    private void fight(T attacker, T defender) {
        Random random = new Random();
        int damage = random.nextInt(6) + 1;
        attacker.fight(defender, damage);
        System.out.println(String.format("%s hits %s with damage %d", attacker.getName(), defender.getName(), damage));
    }
}
