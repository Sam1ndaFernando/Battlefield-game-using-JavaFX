package org.battlefieldGame.controller;

import java.util.Random;

public interface Weapon {
    public abstract void shoot(Random ran);
    public abstract int getScore();
}
