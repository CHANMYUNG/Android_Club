package com.example.www.android_club.HttpClient;

/**
 * Created by NooHeat on 15/05/2017.
 */
public class HttpClientConfig extends Config {
    private String targetAddress = null;
    private int targetPort = 80;

    private int readTimeout = 3000;
    private int connectTimeout = 3000;

    public void setTargetAddress(String address) {
        this.targetAddress = address;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetPort(int port) {
        this.targetPort = port;
    }

    public int getTargetPort() {
        return targetPort;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }
}