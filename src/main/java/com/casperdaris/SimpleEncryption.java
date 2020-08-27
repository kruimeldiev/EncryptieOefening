package com.casperdaris;

public class SimpleEncryption {

    public static String EncryptedText(String text, Integer key) {

        // CharArray maken van de input van de gebruiker
        char[] chars = text.toCharArray();

        String encryptedString = "";

        // Ieder character van de CharArray encrypten door middel van de key
        for(char c : chars) {
            c += key;
            encryptedString += c;
        }

        return encryptedString;
    }

    public static String DecryptedText(String text, Integer key) {
        char[] chars = text.toCharArray();
        String decryptedString = "";
        for(char c : chars) {
            c -= key;
            decryptedString += c;
        }
        return decryptedString;
    }
}
