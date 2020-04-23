package com.stockminer.knightgame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FightClubTest {

    LinkedList<Knight> fighters = new LinkedList<>();
    FightClub<Knight> fightClub;

    @Before
    public void init(){
        String[] names = {"Surena","Crassus","Alexander","Talisman","BlackHorse","DarkKnight"};
        for (String name : names) {
            fighters.addToTail(new Knight(name));
        }
        fightClub = new FightClub<>(fighters);
    }

    /**
     * Just for demonstration purpose.
     */
    @Test
    public void startFightClub() {
        fightClub.startFightClub();
        Assert.assertEquals(Integer.valueOf(1),fighters.size());
    }
}