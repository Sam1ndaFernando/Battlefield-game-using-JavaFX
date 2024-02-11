package org.battlefieldGame.controller;

import java.util.Random;

public class Tank implements Weapon{
    private int random;
    @Override
    public void shoot(Random ran) {
        ran = new Random();
        int random = ran.nextInt(11);
        this.random= random;

    }

    @Override
    public int getScore() {
        return random;
    }
}
