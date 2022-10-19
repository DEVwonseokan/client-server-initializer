package com.devwon.clientserverinitializer.domain.telegram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

class FixedTelegramTest {
    FixedTelegram fixedTgrm = null;

    @BeforeEach
    void  beforeEach() {
        fixedTgrm = new FixedTelegram("1234567890".getBytes(StandardCharsets.UTF_8), 4, true);
    }

    @Test
    void getLengthPart() {
        //길이부 포함
        assertThat(fixedTgrm.getLengthPart()).isEqualTo("0014".getBytes(StandardCharsets.UTF_8));

        //길이부 미포함
        fixedTgrm.setIncludeLengthPart(false);
        assertThat(fixedTgrm.getLengthPart()).isEqualTo("0010".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void getTgrmDataWithLength() {
        //길이부 포함
        assertThat(fixedTgrm.getTgrmDataWithLength()).isEqualTo("00141234567890".getBytes(StandardCharsets.UTF_8));

        //길이부 미포함
        fixedTgrm.setIncludeLengthPart(false);
        assertThat(fixedTgrm.getTgrmDataWithLength()).isEqualTo("00101234567890".getBytes(StandardCharsets.UTF_8));
    }
}