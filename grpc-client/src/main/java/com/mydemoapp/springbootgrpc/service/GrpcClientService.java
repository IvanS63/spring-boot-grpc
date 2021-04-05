package com.mydemoapp.springbootgrpc.service;

import com.mydemoapp.springbootgrpc.grpc.GreetingServiceGrpc;
import com.mydemoapp.springbootgrpc.grpc.GrpcService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GrpcClientService {

    @Value("${grpc-client.host}")
    private String host;

    @Value("${grpc-client.port}")
    private Integer port;

    public String ping() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub
                = GreetingServiceGrpc.newBlockingStub(channel);

        GrpcService.HelloRequest request = GrpcService.HelloRequest.newBuilder().setMessage("test").build();
        String response = stub.greeting(request).getMessage();

        channel.shutdown();
        return response;
    }
}
