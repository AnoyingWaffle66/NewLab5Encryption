package org.example.Utility;

public class Cutter implements IStringEncryptable {
    @Override
    public String encrypt(String phraseToEncrypt) {
        if (phraseToEncrypt != null) {
            String encryptFront = "";
            String encryptBack = "";
            for (int backIndex = (int) (phraseToEncrypt.length() * .5); backIndex < phraseToEncrypt.length(); backIndex++) {
                encryptBack += phraseToEncrypt.charAt(backIndex);
            }
            for (int frontIndex = 0; frontIndex < (phraseToEncrypt.length() - 1) * .5; frontIndex++) {
                encryptFront += phraseToEncrypt.charAt(frontIndex);
            }
            phraseToEncrypt = encryptBack + encryptFront;
            return phraseToEncrypt;
        } else {
            return null;
        }
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        if (phraseToDecrypt != null) {
            String decryptFront = "";
            String decryptBack = "";
            for (int backIndex = (int) ((phraseToDecrypt.length() + 1) * .5); backIndex < phraseToDecrypt.length(); backIndex++) {
                decryptBack += phraseToDecrypt.charAt(backIndex);
            }
            for (int frontIndex = 0; frontIndex < phraseToDecrypt.length() * .5; frontIndex++) {
                decryptFront += phraseToDecrypt.charAt(frontIndex);
            }
            phraseToDecrypt = decryptBack + decryptFront;
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
