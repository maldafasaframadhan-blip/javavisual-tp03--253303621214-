
package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor 1: karakter baru dengan nilai awal
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.hitPoints = 100;
        this.attack = 10;
        this.mana = 0;
    }

    // Constructor 2: karakter dengan statistik yang ditentukan
    public Character(String name, CharacterType type,
                     int level, int hitPoints, int attack) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.mana = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level harus minimal 1!"
            );
        }

        int kenaikanLevel = level - this.level;
        this.hitPoints += kenaikanLevel * 20;
        this.attack += kenaikanLevel * 5;
        this.level = level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // Mini-Challenge: getter dan setter mana
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif!"
            );
        }

        this.mana = mana;
    }

    // Mini-Challenge: mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}
