package com.mydemoapp.springbootgrpc;

import com.mydemoapp.springbootgrpc.service.grpc.impl.GreetingServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringBootGrpcServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SpringBootGrpcServerApplication.class, args);

		Server server = ServerBuilder
				.forPort(8080)
				.addService(new GreetingServiceImpl()).build();

		server.start();
		server.awaitTermination();
	}

}
