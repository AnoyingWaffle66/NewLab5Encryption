package org.example.Utility.Enigma;

import org.example.Utility.IStringEncryptable;

import java.util.Random;

public class Enigma implements IStringEncryptable {
    private char[] keyOriginal = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private char[] key = new char[keyOriginal.length];
    private int rotorOneCurrentValue, rotorTwoCurrentValue, rotorThreeCurrentValue;

    public Enigma() {
        Random randomRotor = new Random();
        this.rotorOneCurrentValue = randomRotor.nextInt(key.length);
        this.rotorTwoCurrentValue = randomRotor.nextInt(key.length);
        this.rotorThreeCurrentValue = randomRotor.nextInt(key.length);
        setKeyPositions();
    }

    @Override
    public String encrypt(String phraseToEncrypt) {
        char[] encryptChars = phraseToEncrypt.toCharArray();
        for (int encryptCharIndex = 0; encryptCharIndex < phraseToEncrypt.length(); encryptCharIndex++) {
            encryptChars[encryptCharIndex] = encryptChar(encryptChars[encryptCharIndex]);
        }
        phraseToEncrypt = makeMeAStringStupid(encryptChars);
        return phraseToEncrypt;
    }

    public char encryptChar(char currentChar) {
        for (int i = 0; i < key.length; i++) {
            if (currentChar == key[i]) {
                i += (rotorOneCurrentValue);
                i %= key.length;
                currentChar = key[i];
                rotorOneCurrentValue += 1;
                rotorOneCurrentValue %= key.length;
                currentChar = encryptCharAgain(currentChar);
                return currentChar;
            }
        }
        return currentChar;
    }

    private char encryptCharAgain(char currentChar) {
        for (int i = 0; i < key.length; i++) {
            if (currentChar == key[i]) {
                i += (rotorTwoCurrentValue);
                i %= key.length;
                currentChar = key[i];
                if (rotorOneCurrentValue % 2 == 0) {
                    rotorTwoCurrentValue += 1;
                    rotorTwoCurrentValue %= key.length;
                }
                currentChar = encryptCharThrice(currentChar);
                return currentChar;
            }
        }
        return currentChar;
    }

    private char encryptCharThrice(char currentChar) {
        for (int i = 0; i < key.length; i++) {
            if (currentChar == key[i]) {
                i += (rotorThreeCurrentValue);
                i %= key.length;
                currentChar = key[i];
                if (rotorTwoCurrentValue%2 == 0){
                rotorThreeCurrentValue += 1;
                rotorThreeCurrentValue = (rotorThreeCurrentValue + key.length) % key.length;
                }
                return currentChar;
            }
        }
        return currentChar;
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        char[] decryptChars = phraseToDecrypt.toCharArray();
        for (int decryptIndex = phraseToDecrypt.length() - 1; decryptIndex >= 0; decryptIndex--) {
            decryptChars[decryptIndex] = decryptCharThrice(decryptChars[decryptIndex]);
        }
        phraseToDecrypt = makeMeAStringStupid(decryptChars);
        return phraseToDecrypt;
    }

    private char decryptChar(char currentChar) {
        for (int i = 0; i < key.length; i++) {
            if (currentChar == key[i]) {
                rotorOneCurrentValue -= 1;
                rotorOneCurrentValue = (rotorOneCurrentValue + key.length) % key.length;
                i -= (rotorOneCurrentValue);
                i = (i + key.length) % key.length;
                currentChar = key[i];
                return currentChar;
            }
        }
        return currentChar;
    }

    private char decryptCharAgain(char currentChar) {
        for (int i = 0; i < key.length; i++) {
            if (currentChar == key[i]) {
                if (rotorOneCurrentValue%2 == 0) {
                    rotorTwoCurrentValue -= 1;
                    rotorTwoCurrentValue = (rotorTwoCurrentValue + key.length) % key.length;
                }
                i -= (rotorTwoCurrentValue);
                i = (i + key.length) % key.length;
                currentChar = key[i];
                currentChar = decryptChar(currentChar);
                return currentChar;
            }
        }
        return currentChar;
    }

    private char decryptCharThrice(char currentChar) {
        for (int i = 0; i < key.length; i++) {
            if (currentChar == key[i]) {
                if (rotorTwoCurrentValue%2 == 0){
                rotorThreeCurrentValue -= 1;
                rotorThreeCurrentValue = (rotorThreeCurrentValue + key.length) % key.length;
                }
                i -= (rotorThreeCurrentValue);
                i = (i + key.length) % key.length;
                currentChar = key[i];
                currentChar = decryptCharAgain(currentChar);
                return currentChar;
            }
        }
        return currentChar;
    }

    private int[] obtainKeyPositions(){
        KeyMapper keyPositions = new KeyMapper();
        return keyPositions.getKeyMapping();
    }

    private void setKeyPositions(){
        int[] newKeyPositions = obtainKeyPositions();
        for (int keyPos = 0; keyPos < key.length/2; keyPos++){
            key[keyPos] = keyOriginal[newKeyPositions[keyPos]];
            key[newKeyPositions[keyPos]] = keyOriginal[keyPos];
        }
    }

    public String makeMeAStringStupid(char[] myCharacters) {
        StringBuilder aStupidStringMadeOfArrays = new StringBuilder();
        for (int i = 0; i < myCharacters.length; i++) {
            aStupidStringMadeOfArrays.append(myCharacters[i]);
        }
        return aStupidStringMadeOfArrays.toString();
    }
}
