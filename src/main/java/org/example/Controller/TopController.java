package org.example.Controller;

import org.example.Utility.*;
import org.example.Utility.Enigma.Enigma;
import org.example.Utility.Enigma.KeyMapper;
import org.example.View.Menu;
import org.example.View.MyIO;

import java.util.ArrayList;

public class TopController {
    private ArrayList<IStringEncryptable> encryptList = new ArrayList<>();
    private MyIO inputOutput = new MyIO();
    private Menu menus = new Menu();
    private String encryptedStringStorage = "";

    public void startHere() {
        int userSelection = 0;
        while (userSelection != 10) {
            userSelection = menus.mainMenu();
            switch (userSelection) {
                case 1:
                    // add cutter
                    addEncryptor(new Cutter());
                    break;
                case 2:
                    // add doubler
                    addEncryptor(new Doubler());
                    break;
                case 3:
                    // add vowel replacer
                    addEncryptor(new VowelReplacer());
                    break;
                case 4:
                    // add Enigma
                    addEncryptor(new Enigma());
                    break;
                case 5:
                    // view encryptor list
                    displayEncryptors();
                    break;
                case 6:
                    // clear encryptor list
                    clearEncryptors();
                    break;
                case 7:
                    // store string for encryption/decryption
                    encryptedStringStorage = menus.getStringToEncrypt().replaceAll("\\s", "");
                    break;
                case 8:
                    // run all encryptors in order
                    if (!encryptedStringStorage.isEmpty()) {
                        runEncryptors();
                    }
                    break;
                case 9:
                    // run all decryptors in reverse order
                    if (!encryptedStringStorage.isEmpty()) {
                        runDecryptors();
                    }
                    break;
                case 10:
                    //do nothing this exits the program
                    break;
            }
        }
    }

    public void displayEncryptors() {
        if (!encryptList.isEmpty()) {
            for (int listIndex = 0; listIndex < encryptList.size(); listIndex++) {
                inputOutput.printMessages(encryptList.get(listIndex).toString());
            }
        }
    }

    public void runEncryptors() {
        if (!encryptList.isEmpty()) {
            for (int encryptIndex = 0; encryptIndex < encryptList.size(); encryptIndex++) {
                encryptedStringStorage = encryptList.get(encryptIndex).encrypt(encryptedStringStorage);
                inputOutput.printMessages(encryptedStringStorage);
            }
        }
    }

    public void runDecryptors() {
        if (!encryptList.isEmpty()) {
            for (int decryptIndex = encryptList.size() - 1; decryptIndex >= 0; decryptIndex--) {
                encryptedStringStorage = encryptList.get(decryptIndex).decrypt(encryptedStringStorage);
                inputOutput.printMessages(encryptedStringStorage);
            }
        }
    }

    public void addEncryptor(IStringEncryptable encryptor) {
        encryptList.add(encryptor);
    }

    public void clearEncryptors() {
        if (!encryptList.isEmpty()) {
            while (!encryptList.isEmpty()) {
                encryptList.remove(0);
            }
        } else {
            inputOutput.printMessages("There is no encryptors in the list.");
        }
    }
}
