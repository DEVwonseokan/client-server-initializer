package com.devwon.clientserverinitializer.service;

import com.devwon.clientserverinitializer.adapter.server.tcp.socket.NettyServerSocket;
import com.devwon.clientserverinitializer.domain.server.TCPServer;
import io.netty.bootstrap.ServerBootstrap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;

@Service
@RequiredArgsConstructor
public class ServerService {

    public void create(TCPServer tcpServer) {
        NettyServerSocket socket = new NettyServerSocket();
        socket.start();
    }
}
