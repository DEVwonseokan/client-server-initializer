package com.devwon.clientserverinitializer.adapter.server.tcp.decoder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class TestDecoder extends ByteToMessageDecoder {
    private int DATA_LENGTH = 10;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < DATA_LENGTH) {
            return;
        }

        out.add(in.readBytes(DATA_LENGTH));
    }
}