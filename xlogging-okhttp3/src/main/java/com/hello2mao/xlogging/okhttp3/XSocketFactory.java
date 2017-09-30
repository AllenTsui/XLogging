package com.hello2mao.xlogging.okhttp3;

import com.hello2mao.xlogging.okhttp3.internal.bean.NetworkData;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

public class XSocketFactory extends SocketFactory {

    private SocketFactory impl;
    private NetworkData networkData;

    public XSocketFactory(SocketFactory socketFactory, NetworkData networkData) {
        this.impl = socketFactory;
        this.networkData = networkData;
    }

    @Override
    public Socket createSocket() throws IOException {
        return new XSocket(impl.createSocket(), networkData);
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
        return impl.createSocket(host, port);
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort)
            throws IOException, UnknownHostException {
        return impl.createSocket(host, port, localHost, localPort);
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return impl.createSocket(host, port);
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int
            localPort) throws IOException {
        return impl.createSocket(address, port, localAddress, localPort);
    }
}