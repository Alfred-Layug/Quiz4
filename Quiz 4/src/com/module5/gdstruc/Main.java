package com.module5.gdstruc;

public class Main {
    public static void main(String[] args) {
        Player pikachu = new Player(25, "Pikachu", 1);
        Player celebi = new Player(251, "Celebi", 2);
        Player hitmonchan = new Player(107, "Hitmonchan", 3);
        Player mankey = new Player(56, "Mankey", 4);
        Player starmie = new Player(175, "Starmie", 4);

        SimpleHashtable hashtable = new SimpleHashtable();

        // Add initial players
        hashtable.put(celebi.getUserName(), celebi);
        hashtable.put(mankey.getUserName(), mankey);
        hashtable.put(pikachu.getUserName(), pikachu);
        hashtable.put(hitmonchan.getUserName(), hitmonchan);
        hashtable.put(starmie.getUserName(), starmie);

        // Print the contents of the hashtable
        hashtable.printHashtable();

        System.out.println();

        // Add a new Pokémon to the table
        Player eevee = new Player(33, "Eevee", 2);
        hashtable.put(eevee.getUserName(), eevee);

        hashtable.printHashtable();

        System.out.println();

        // Remove Eevee from the hash table
        hashtable.remove(eevee.getUserName());

        System.out.println();

        // Print the contents of the hashtable
        hashtable.printHashtable();

        System.out.println();

        // Try deleting Eevee again
        hashtable.remove(eevee.getUserName());

        // Add Eevee back
        hashtable.put(eevee.getUserName(), eevee);

        System.out.println();

        hashtable.printHashtable();

        System.out.println();

        //Add 2 more Pokémon
        Player charizard = new Player(101, "Charizard", 5);
        hashtable.put(charizard.getUserName(), charizard);

        Player snorlax = new Player(57, "Snorlax", 7);
        hashtable.put(snorlax.getUserName(), snorlax);

        hashtable.printHashtable();

        System.out.println();

        //Remove Eevee
        hashtable.remove(eevee.getUserName());

        System.out.println();

        hashtable.printHashtable();

        System.out.println();

        //Remove Charizard
        hashtable.remove(charizard.getUserName());

        System.out.println();

        hashtable.printHashtable();

        System.out.println();

        // get a value based on a given key
        System.out.println(hashtable.get("Mankey"));
    }
}