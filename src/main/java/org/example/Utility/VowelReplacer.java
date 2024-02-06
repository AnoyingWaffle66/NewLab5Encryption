package org.example.Utility;

public class VowelReplacer implements IStringEncryptable{
    private char[] keyValues = {'a', 'e', 'i', 'o', 'u'};
    private char[] shiftLeft = {'e', 'i', 'o', 'u', 'a'};
    @Override
    public String encrypt(String phraseToEncrypt) {
        // shift vowels to the left
        char[] phraseToEncryptArray = phraseToEncrypt.toCharArray();
        for (int encryptIndex = 0; encryptIndex < phraseToEncrypt.length(); encryptIndex++){
            phraseToEncryptArray[encryptIndex] = loopThroughCharacters(phraseToEncrypt.charAt(encryptIndex));
        }
        phraseToEncrypt = makeMeAStringStupid(phraseToEncryptArray);
        return phraseToEncrypt;
    }

    @Override
    public String decrypt(String phraseToDecrypt) {
        // shift vowels to the right
        char[] phrastToDecryptArray = phraseToDecrypt.toCharArray();
        for (int decryptIndex = 0; decryptIndex < phraseToDecrypt.length(); decryptIndex++){
            phrastToDecryptArray[decryptIndex] = unLoopThroughCharacters(phraseToDecrypt.charAt(decryptIndex));
        }
        phraseToDecrypt = makeMeAStringStupid(phrastToDecryptArray);
        return phraseToDecrypt;
    }
    public char loopThroughCharacters(char theCharacterInQuestion){
        for (int i = 0; i < 5; i++){
            if (theCharacterInQuestion == keyValues[i]){
                theCharacterInQuestion = shiftLeft[i];
                return theCharacterInQuestion;
            }
        }
        return theCharacterInQuestion;
    }
    public char unLoopThroughCharacters(char theCharacterInQuestion){
        for (int i = 0; i< 5; i++){
            if (shiftLeft[i] == theCharacterInQuestion){
                theCharacterInQuestion = keyValues[i];
                return theCharacterInQuestion;
            }
        }
        return theCharacterInQuestion;
    }
    public String makeMeAStringStupid(char[] myCharacters){
        String aStupidStringMadeOfArrays = "";
        for (int i = 0; i < myCharacters.length; i++){
            aStupidStringMadeOfArrays += myCharacters[i];
        }
        return aStupidStringMadeOfArrays;
    }

    @Override
    public String toString() {
        return "VowelReplacer";
    }
}
