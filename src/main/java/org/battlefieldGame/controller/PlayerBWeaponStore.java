package org.battlefieldGame.controller;

import java.util.ArrayList;
import java.util.Random;

public class PlayerBWeaponStore {
    T56 t56 = new T56();
    Tank tank = new Tank();
    MultiBarrel multiBarrel = new MultiBarrel();
    Pistol pistol = new Pistol();

    Bomb bomb = new Bomb();

    ArrayList<Integer> arrayList = new ArrayList<>();

    public int scoreBCalculateT56(){
        t56.shoot(new Random(11));
        int value1 = t56.getScore();
        arrayList.add(value1);
        return value1;
    }

    public int scoreBCalculateTank(){
        tank.shoot(new Random(11));
        int value2 = tank.getScore();
        arrayList.add(value2);
        return value2;
    }

    public int scoreBCalculateMulti(){
        multiBarrel.shoot(new Random(11));
        int value3 = multiBarrel.getScore();
        arrayList.add(value3);
        return value3;
    }

    public int scoreBCalculatePistol(){
        pistol.shoot(new Random(11));
        int value4 = pistol.getScore();
        arrayList.add(value4);
        return value4;
    }

    public int scoreBCalculateBomb(){
        bomb.shoot(new Random(11));
        int value5 = bomb.getScore();
        arrayList.add(value5);
        return value5;
    }

    public void scoreACalculate(){
        int sum =0;
        for (int value: arrayList ) {

        }
    }

}
