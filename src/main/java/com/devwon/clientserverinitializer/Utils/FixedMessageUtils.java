package com.devwon.clientserverinitializer.Utils;


import java.io.UnsupportedEncodingException;

import static com.devwon.clientserverinitializer.Utils.StringUtils.padLeft;

public class FixedMessageUtils {

    /**
     * message의 길이부를 구하고 세팅합니다.
     * @param message
     * @param lengthPartOffset 길이부 시작위치
     * @param lengthPartSize 길이부 길이
     * @param isInclude 길이부에 길이부의 길이까지 포함하면 true, 아니면 false
     * @param isAppend 길이부를 message에 붙힌다면 true, 덮어 씌운다면 false
     * @return 길이부가 세팅된 message 반환
     */
    public static byte[] attachLengthPart(byte[] message, int lengthPartOffset, int lengthPartSize, boolean isInclude, boolean isAppend) {
        int msgLength = getMsgLength(message, lengthPartSize, isInclude);
        byte[] lengthPart = padLeft(Integer.toString(msgLength),lengthPartSize).getBytes();

        int msgWithLengthPartSize = getMsgWithLengthPartSize(message, lengthPartSize, isAppend);
        byte[] msgWithLengthPart = new byte[msgWithLengthPartSize];

        if(isAppend) {
            System.arraycopy(message, 0, msgWithLengthPart, 0, lengthPartOffset);
            System.arraycopy(message, lengthPartOffset, msgWithLengthPart, lengthPartOffset + lengthPartSize, message.length - lengthPartOffset);
            System.arraycopy(lengthPart, 0, msgWithLengthPart, lengthPartOffset, lengthPartSize);
        } else {
            System.arraycopy(message,0,msgWithLengthPart,0,msgWithLengthPartSize);
            System.arraycopy(lengthPart,0,msgWithLengthPart,lengthPartOffset,lengthPartSize);
        }
        return msgWithLengthPart;
    }
    private static int getMsgLength(byte[] message, int lengthPartSize, boolean isInclude) {
        if (isInclude) {
            return message.length + lengthPartSize;
        }
        return message.length;
    }

    private static int getMsgWithLengthPartSize(byte[] message, int lengthPartSize, boolean isAppend) {
        if (isAppend) {
            return message.length + lengthPartSize;
        }
        return message.length;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] msg = "helloWorld".getBytes();
        int lengthPartOffset = 0;
        int lengthPartSize = 4;
        boolean isInclude = false;
        boolean isAppend = false;
        System.out.println("addMsgLengthPart() = " + new String(attachLengthPart(msg, lengthPartOffset, lengthPartSize, isInclude, isAppend)));
    }

}
