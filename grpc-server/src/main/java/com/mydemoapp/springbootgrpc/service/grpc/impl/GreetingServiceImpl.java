package com.mydemoapp.springbootgrpc.service.grpc.impl;

import com.mydemoapp.springbootgrpc.grpc.GreetingServiceGrpc;
import com.mydemoapp.springbootgrpc.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;


public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request, StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setMessage("Response from server")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
