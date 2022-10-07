package com.devwon.clientserverinitializer.Utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FixedMessageUtilsTest {

    private byte[] msg = "helloAnWonseokWorld!!안녕 반가워".getBytes();


    @Test
    @DisplayName("바이트에 길이부 추가(Append, Include)")
    void attachLengthPartAppendAndInclude() {
        boolean isInclude = true;
        boolean isAppend = true;

        int lengthPartOffset = 0;
        int lengthPartSize = 4;
        byte[] result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        byte[] expected = "0041helloAnWonseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);

        lengthPartOffset = 4;
        lengthPartSize = 4;
        result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        expected = "hell0041oAnWonseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("바이트에 길이부 추가(Not Append, Not Include)")
    void attachLengthPartNoAppendAndNoInclude() {
        boolean isInclude = false;
        boolean isAppend = false;

        int lengthPartOffset = 0;
        int lengthPartSize = 4;

        byte[] result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        byte[] expected = "0037oAnWonseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);

        lengthPartOffset = 4;
        lengthPartSize = 4;
        result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        expected = "hell0037onseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("바이트에 길이부 추가(Append, Not Include)")
    void attachLengthPartAppendAndNoInclude() {
        boolean isInclude = true;
        boolean isAppend = false;

        int lengthPartOffset = 0;
        int lengthPartSize = 4;

        byte[] result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        byte[] expected = "0041oAnWonseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);

        lengthPartOffset = 4;
        lengthPartSize = 4;
        result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        expected = "hell0041onseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("바이트에 길이부 추가(Not Append, Include)")
    void attachLengthPartNoAppendAndInclude() {
        boolean isInclude = false;
        boolean isAppend = true;

        int lengthPartOffset = 0;
        int lengthPartSize = 4;

        byte[] result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        byte[] expected = "0037helloAnWonseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);

        lengthPartOffset = 4;
        lengthPartSize = 4;
        result = FixedMessageUtils.attachLengthPart(msg,lengthPartOffset,lengthPartSize,isInclude,isAppend);
        expected = "hell0037oAnWonseokWorld!!안녕 반가워".getBytes();
        assertThat(result).isEqualTo(expected);
    }
}