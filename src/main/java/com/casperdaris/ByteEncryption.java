package com.casperdaris;

public class ByteEncryption {

    public byte[] encrypt(byte[] data, int key) {

        byte[] enc = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            enc[i] = (byte) ((i % 2 == 0) ? data[i] + key : data[i] - key);
        }

        return enc;
    }

    public byte[] decrypt(byte[] data, int key) {

        byte[] dec = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            dec[i] = (byte) ((i % 2 == 0) ? data[i] - key : data[i] + key);
        }

        return dec;
    }

}
