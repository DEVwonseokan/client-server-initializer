package com.devwon.clientserverinitializer.domain.telegram;

import lombok.Getter;
import lombok.Setter;

import static com.devwon.clientserverinitializer.Utils.StringUtils.padLeft;

@Getter
@Setter
public class FixedTelegram extends Telegram<byte[]> {
    private byte[] lengthPart;
    private int lengthPartSize;
    private boolean isIncludeLengthPart;

    public FixedTelegram(byte[] tgrmData, int lengthPartSize, boolean isIncludeLengthPart) {
        this.tgrmData = tgrmData;
        this.lengthPartSize = lengthPartSize;
        this.isIncludeLengthPart = isIncludeLengthPart;
    }

    public byte[] getLengthPart(){
        if(isIncludeLengthPart){
            return padLeft(Integer.toString(getTgrmData().length + lengthPartSize) ,lengthPartSize).getBytes();
        } else {
            return padLeft(Integer.toString(getTgrmData().length), lengthPartSize).getBytes();
        }
    }

    public byte[] getTgrmDataWithLength() {
        byte[] result = new byte[tgrmData.length + lengthPartSize];
        System.arraycopy(getLengthPart(), 0, result, 0, lengthPartSize);
        System.arraycopy(tgrmData,0,result,lengthPartSize, tgrmData.length);
        return result;
    }
}

