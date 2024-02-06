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
            StringBuilder decrypted = new StringBuilder();
            for (int decryptIndex = 0; decryptIndex < phraseToDecrypt.length() * .5; decryptIndex++) {
                decrypted.append(phraseToDecrypt.charAt(decryptIndex));
            }
            return decrypted.toString();
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
