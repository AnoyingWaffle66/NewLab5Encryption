package org.example.Utility.Enigma;

import java.util.Random;

public class KeyMapper {
    private int[] keyMapping = new int[26];
    private Random myRandom = new Random();

    public KeyMapper(){
        pairKeys();
    }

    public void pairKeys() {
        int temporaryStorage;
        for (int iteration = 0; iteration < keyMapping.length/2; iteration++) {
            do {
            temporaryStorage = (myRandom.nextInt(keyMapping.length / 2) + 13);
            } while (keyMapping[temporaryStorage] != 0);
                keyMapping[iteration] = temporaryStorage + 1;
                keyMapping[temporaryStorage] = iteration + 1;
        }
        for (int decrementing = 0; decrementing < keyMapping.length; decrementing++){
            keyMapping[decrementing] -= 1;
        }
    }
    public int[] getKeyMapping(){
        return keyMapping;
    }
}
