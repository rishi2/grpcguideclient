package grpcguideclient;


import com.example.server.GreetingServiceGrpc;
import com.example.server.HelloRequest;
import com.example.server.HelloResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {

  
  public static void main(String[] args) {
    
//    1. Channel, ManagedChannel, usePlainText
    
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext(true)
        .build();
    
    GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
    
    try{
      HelloResponse response = stub.greeting(HelloRequest.newBuilder().setName("Hrishikesh").build());
      
      System.out.println(response);
    }catch(Exception e){
      e.printStackTrace();
    }
    
    
    
//    2. Load Balancing, Name Resolver
//    3. Blocking vs Non-blocking Stubs
//    4. Builders
    
    
    
    
  }

}
