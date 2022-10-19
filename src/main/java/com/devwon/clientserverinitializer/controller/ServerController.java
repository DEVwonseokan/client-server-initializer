package com.devwon.clientserverinitializer.controller;

import com.devwon.clientserverinitializer.domain.server.TCPServer;
import com.devwon.clientserverinitializer.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServerController {
    private final ServerService serverService;

    @Autowired
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }


    @GetMapping("/server/tcp/new")
    public String createForm() {
        return "server/tcp/createServerForm";
    }

    @PostMapping("/server/tcp/new")
    public String createTCPServer(TCPServerForm serverForm) {
        TCPServer tcpServer = new TCPServer();
        tcpServer.setPort(serverForm.getPort());
        tcpServer.setBoosCount(serverForm.getBoosCount());

        serverService.create(tcpServer);
        return "redirect:/";
    }
}
