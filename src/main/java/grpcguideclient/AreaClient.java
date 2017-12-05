package grpcguideclient;

import com.example.server.area.AreaFor;
import com.example.server.area.AreaRequest;
import com.example.server.area.AreaResponse;
import com.example.server.area.AreaServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AreaClient {

  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
        .usePlaintext(true)
        .build();
    
      
      AreaServiceGrpc.AreaServiceBlockingStub stub = AreaServiceGrpc.newBlockingStub(channel);
      
      AreaResponse circleArea = stub.getArea(AreaRequest.newBuilder().setAreafor(AreaFor.CIRCLE).setRadius(15).build());
      
      System.out.println("Area for circle ... "+circleArea);
      
      AreaResponse rectangleArea = stub.getArea(AreaRequest.newBuilder().setAreafor(AreaFor.RECTANGLE).setLength(15.0).setWidth(10.0).build());
      
      System.out.println("Area for RECTANGLE ... "+rectangleArea);
      
      AreaResponse squareArea = stub.getArea(AreaRequest.newBuilder().setAreafor(AreaFor.SQUARE).setLength(15).build());
      
      System.out.println("Area for SQUARE ... "+squareArea.getArea());
      
  }

}
