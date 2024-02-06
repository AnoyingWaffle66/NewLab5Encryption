package org.example.View;

public class Menu {
    private MyIO inputOutput = new MyIO();
    public int mainMenu(){
        return inputOutput.getUserInt("Select an option. \n 1) add cutter to list" +
                " \n 2) add doubler to list \n 3) add vowel replacer to list" +
                " \n 4) add custom to list \n 5) view encryptor list" +
                " \n 6) clear encryptor list \n 7) input string to encrypt" +
                " \n 8) run all encryptors \n 9) run all decryptors" +
                " \n 10) exit application", 1, 10, true);
    }
    public String getStringToEncrypt(){
        return inputOutput.getUserString("Enter a string for encryption. All spaces will be removed from prompt.", true);
    }
}
