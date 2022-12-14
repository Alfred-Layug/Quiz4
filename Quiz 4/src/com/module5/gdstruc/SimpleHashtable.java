package com.module5.gdstruc;

public class SimpleHashtable {
    private StoredPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // applied linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            // hashedkey is pointing at the last element
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            // search the array for the next immediate vacant position
            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    public void remove(String key) {
        // use the findKey() function to look for the item that will be removed
        int hashedKey = findKey(key);

        if (hashedKey == -1)  // a message gets printed if the item not found
        {
            System.out.println(key + " is not in the hash table");  // we add the "key" variable at the start to display the key that we are looking for
        }
        else
        {
            hashtable[hashedKey] = null;  // "delete" the item at the index by making it null
            System.out.println(key + " removed");   // we add the "key" variable at the start to display what item has been removed
        }
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        // found the right key?
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return  hashedKey;
        }

        // applied linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            // hashedkey is pointing at the last element
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            // search the array for the next immediate vacant position
            while (hashedKey != stoppingIndex &&
                    isOccupied(hashedKey) &&
                    !hashtable[hashedKey].getKey().equals(key)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        // return the index that corresponds to the key if applicable
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return  null;
        }

        return hashtable[hashedKey].getValue();
    }

    public boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].getValue());
            }
            else {
                System.out.println("Element " + i + " null");
            }
        }
    }
}