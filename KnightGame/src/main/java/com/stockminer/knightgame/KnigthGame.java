package com.stockminer.knightgame;

public class KnigthGame {
    public static void main(String[] args) {
        FightClub<Knight> fightClub = new FightClub<>(init());
        fightClub.startFightClub();
    }

    private static LinkedList<Knight> init() {
        LinkedList<Knight> knightLinkedList = new LinkedList<>();
        String[] knights = {"Surena", "Crassus", "Alexander", "Talisman", "BlackHorse", "DarkKnight"};
        for (String name : knights) {
            knightLinkedList.addToTail(new Knight(name));
        }
        return knightLinkedList;
    }
}



