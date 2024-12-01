package org.example.dotsandboxes;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: dotsandboxes.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameServiceGrpc {

  private GameServiceGrpc() {}

  public static final String SERVICE_NAME = "org.example.dotsandboxes.GameService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest,
      org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> getMakeMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "makeMove",
      requestType = org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest.class,
      responseType = org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest,
      org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> getMakeMoveMethod() {
    io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest, org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> getMakeMoveMethod;
    if ((getMakeMoveMethod = GameServiceGrpc.getMakeMoveMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getMakeMoveMethod = GameServiceGrpc.getMakeMoveMethod) == null) {
          GameServiceGrpc.getMakeMoveMethod = getMakeMoveMethod =
              io.grpc.MethodDescriptor.<org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest, org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "makeMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("makeMove"))
              .build();
        }
      }
    }
    return getMakeMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty,
      org.example.dotsandboxes.Dotsandboxes.GameState> getWatchGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "watchGame",
      requestType = org.example.dotsandboxes.Dotsandboxes.Empty.class,
      responseType = org.example.dotsandboxes.Dotsandboxes.GameState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty,
      org.example.dotsandboxes.Dotsandboxes.GameState> getWatchGameMethod() {
    io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty, org.example.dotsandboxes.Dotsandboxes.GameState> getWatchGameMethod;
    if ((getWatchGameMethod = GameServiceGrpc.getWatchGameMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getWatchGameMethod = GameServiceGrpc.getWatchGameMethod) == null) {
          GameServiceGrpc.getWatchGameMethod = getWatchGameMethod =
              io.grpc.MethodDescriptor.<org.example.dotsandboxes.Dotsandboxes.Empty, org.example.dotsandboxes.Dotsandboxes.GameState>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "watchGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.GameState.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("watchGame"))
              .build();
        }
      }
    }
    return getWatchGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GameServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServiceStub>() {
        @java.lang.Override
        public GameServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServiceStub(channel, callOptions);
        }
      };
    return GameServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GameServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServiceBlockingStub>() {
        @java.lang.Override
        public GameServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServiceBlockingStub(channel, callOptions);
        }
      };
    return GameServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GameServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GameServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GameServiceFutureStub>() {
        @java.lang.Override
        public GameServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GameServiceFutureStub(channel, callOptions);
        }
      };
    return GameServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GameServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void makeMove(org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMakeMoveMethod(), responseObserver);
    }

    /**
     */
    public void watchGame(org.example.dotsandboxes.Dotsandboxes.Empty request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.GameState> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWatchGameMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getMakeMoveMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest,
                org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse>(
                  this, METHODID_MAKE_MOVE)))
          .addMethod(
            getWatchGameMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                org.example.dotsandboxes.Dotsandboxes.Empty,
                org.example.dotsandboxes.Dotsandboxes.GameState>(
                  this, METHODID_WATCH_GAME)))
          .build();
    }
  }

  /**
   */
  public static final class GameServiceStub extends io.grpc.stub.AbstractAsyncStub<GameServiceStub> {
    private GameServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServiceStub(channel, callOptions);
    }

    /**
     */
    public void makeMove(org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void watchGame(org.example.dotsandboxes.Dotsandboxes.Empty request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.GameState> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getWatchGameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GameServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GameServiceBlockingStub> {
    private GameServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse makeMove(org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMakeMoveMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<org.example.dotsandboxes.Dotsandboxes.GameState> watchGame(
        org.example.dotsandboxes.Dotsandboxes.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getWatchGameMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GameServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GameServiceFutureStub> {
    private GameServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GameServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GameServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> makeMove(
        org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MAKE_MOVE = 0;
  private static final int METHODID_WATCH_GAME = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GameServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GameServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MAKE_MOVE:
          serviceImpl.makeMove((org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest) request,
              (io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse>) responseObserver);
          break;
        case METHODID_WATCH_GAME:
          serviceImpl.watchGame((org.example.dotsandboxes.Dotsandboxes.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.GameState>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GameServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GameServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.dotsandboxes.Dotsandboxes.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GameService");
    }
  }

  private static final class GameServiceFileDescriptorSupplier
      extends GameServiceBaseDescriptorSupplier {
    GameServiceFileDescriptorSupplier() {}
  }

  private static final class GameServiceMethodDescriptorSupplier
      extends GameServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GameServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GameServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GameServiceFileDescriptorSupplier())
              .addMethod(getMakeMoveMethod())
              .addMethod(getWatchGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
