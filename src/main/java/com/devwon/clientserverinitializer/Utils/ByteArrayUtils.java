package com.devwon.clientserverinitializer.Utils;

public class ByteArrayUtils {
    /**
     * Add padding to a byte array.
     * @param buffer
     * @param paddingByte
     * @param paddingLength
     * @return
     */
    public static byte[] pad(byte[] buffer, byte paddingByte, int paddingLength) {
        return concat(buffer, createPaddingBuffer(paddingByte, paddingLength));
    }

    public static byte[] concat(byte[] buffer1, byte[] buffer2) {
        byte[] resultArray = new byte[buffer1.length + buffer2.length];
        System.arraycopy(buffer1, 0, resultArray, 0, buffer1.length);
        System.arraycopy(buffer2, 0, resultArray, buffer1.length,
                buffer2.length);
        return resultArray;

    }

    /**
     * Create a padding buffer.
     * @param paddingByte
     * @param paddingLength
     * @return
     */
    public static byte[] createPaddingBuffer(byte paddingByte, int paddingLength) {
        byte[] padding = new byte[paddingLength];
        for (int i = 0; i < padding.length; i++) {
            padding[i] = paddingByte;
        }
        return padding;
    }
}
