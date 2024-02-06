package org.example.Utility;

public class Doubler implements IStringEncryptable {

    @Override
    public String encrypt(String phraseToEncrypt) {
        if (phraseToEncrypt != null) {
            phraseToEncrypt += phraseToEncrypt;
            return phraseToEncrypt;
        } else {
            System.out.println("Can't be empty");
            return null;
        }
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        if (phraseToDecrypt != null) {
            String decrypted = "";
            for (int decryptIndex = 0; decryptIndex < phraseToDecrypt.length() * .5; decryptIndex++) {
                decrypted += phraseToDecrypt.charAt(decryptIndex);
            }
            return decrypted;
        } else {
            System.out.println("Can't be empty");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Doubler";
    }
}
