package com.devwon.clientserverinitializer.domain.server;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TCPServer {
    private int port;
    private int boosCount;
}
