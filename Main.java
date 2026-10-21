
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER ===");

        // Tiga karakter utama
        Character c1 = new Character(
            "Arjuna", CharacterType.WARRIOR
        );

        Character c2 = new Character(
            "Srikandi", CharacterType.ARCHER,
            2, 120, 15
        );

        Character c3 = new Character(
            "Bima", CharacterType.HEALER
        );

        System.out.println("\n--- Tiga Karakter ---");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // Demo level up
        System.out.println("\n--- Demo Level Up ---");
        System.out.println("Sebelum: " + c1);
        c1.setLevel(2);
        System.out.println("Sesudah: " + c1);

        // Mini-Challenge: karakter keempat
        Character c4 = new Character(
            "Naga", CharacterType.MAGE
        );

        c4.setMana(80);

        System.out.println("\n--- Mini-Challenge ---");
        System.out.println(c4);
        System.out.println("Mana: " + c4.getMana());
        System.out.println("Apakah Naga masih hidup? "
            + c4.isAlive());

        // Pengujian isAlive ketika HP nol
        c4.setHitPoints(0);
        System.out.println("Setelah HP menjadi 0: "
            + c4.isAlive());
    }
}
