
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        
        for (int i=0; i<encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (Character.isLowerCase(currChar)) {
                idx = alphabet.toLowerCase().indexOf(currChar);
            }
            if (idx != -1) {
                if (Character.isLowerCase(currChar)) {
                    char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                else {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String inputString, int key1, int key2) {
        StringBuilder newString = new StringBuilder(inputString);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0; i<inputString.length(); i++) {
            char currChar = inputString.charAt(i);
            if (i % 2 == 0) {
                String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0,key1);
                int idx = alphabet.indexOf(currChar);
                if (Character.isLowerCase(currChar)) {
                    idx = alphabet.toLowerCase().indexOf(currChar);
                }
                if (idx != -1) {
                    if (Character.isLowerCase(currChar)) {
                        char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                        newString.setCharAt(i, newChar);
                    }
                    else {
                        char newChar = shiftedAlphabet.charAt(idx);
                        newString.setCharAt(i, newChar);
                    }
                }
            }
            if (i % 2 == 1) {
                String shiftedAlphabet = alphabet.substring(key2) + alphabet.substring(0,key2);
                int idx = alphabet.indexOf(currChar);
                if (Character.isLowerCase(currChar)) {
                    idx = alphabet.toLowerCase().indexOf(currChar);
                }
                if (idx != -1) {
                    if (Character.isLowerCase(currChar)) {
                        char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                        newString.setCharAt(i, newChar);
                    }
                    else {
                        char newChar = shiftedAlphabet.charAt(idx);
                        newString.setCharAt(i, newChar);
                    }
                }
            }
        }
        return newString.toString();
    }
    
    public void testEncryptTwoKeys () {
        String encrypted = "Hfs cpwewloj loks cd Hoto kyg Cyy.";
        int key1 = 14;
        int key2 = 24;
        String decrypted = encryptTwoKeys(encrypted, 26-key1, 26-key2);
        System.out.println(decrypted);
    }
}
