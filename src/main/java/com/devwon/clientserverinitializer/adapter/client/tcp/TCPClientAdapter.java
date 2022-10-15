package com.devwon.clientserverinitializer.adapter.client.tcp;

import com.devwon.clientserverinitializer.adapter.client.ClientAdapter;
import lombok.Data;

@Data
public class TCPClientAdapter implements ClientAdapter {
    private String ip;
    private int port;


    @Override
    public boolean send() {
        return false;
    }
}
