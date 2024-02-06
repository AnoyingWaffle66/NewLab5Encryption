package org.example.Utility;

public class Cutter implements IStringEncryptable {
    @Override
    public String encrypt(String phraseToEncrypt) {
        if (phraseToEncrypt != null) {
            StringBuilder encryptFront = new StringBuilder();
            StringBuilder encryptBack = new StringBuilder();
            for (int backIndex = (int) (phraseToEncrypt.length() * .5); backIndex < phraseToEncrypt.length(); backIndex++) {
                encryptBack.append(phraseToEncrypt.charAt(backIndex));
            }
            for (int frontIndex = 0; frontIndex < (phraseToEncrypt.length() - 1) * .5; frontIndex++) {
                encryptFront.append(phraseToEncrypt.charAt(frontIndex));
            }
            phraseToEncrypt = encryptBack.toString() + encryptFront;
            return phraseToEncrypt;
        } else {
            return null;
        }
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        if (phraseToDecrypt != null) {
            StringBuilder decryptFront = new StringBuilder();
            StringBuilder decryptBack = new StringBuilder();
            for (int backIndex = (int) ((phraseToDecrypt.length() + 1) * .5); backIndex < phraseToDecrypt.length(); backIndex++) {
                decryptBack.append(phraseToDecrypt.charAt(backIndex));
            }
            for (int frontIndex = 0; frontIndex < phraseToDecrypt.length() * .5; frontIndex++) {
                decryptFront.append(phraseToDecrypt.charAt(frontIndex));
            }
            phraseToDecrypt = decryptBack + decryptFront.toString();
            return phraseToDecrypt;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Cutter";
    }
}
