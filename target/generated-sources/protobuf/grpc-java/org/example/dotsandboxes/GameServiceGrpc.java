package org.example.dotsandboxes;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Сервис для игры Dots and Boxes
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: dotsandboxes.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GameServiceGrpc {

  private GameServiceGrpc() {}

  public static final String SERVICE_NAME = "org.example.dotsandboxes.GameService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.StartGameRequest,
      org.example.dotsandboxes.Dotsandboxes.StartGameResponse> getStartGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startGame",
      requestType = org.example.dotsandboxes.Dotsandboxes.StartGameRequest.class,
      responseType = org.example.dotsandboxes.Dotsandboxes.StartGameResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.StartGameRequest,
      org.example.dotsandboxes.Dotsandboxes.StartGameResponse> getStartGameMethod() {
    io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.StartGameRequest, org.example.dotsandboxes.Dotsandboxes.StartGameResponse> getStartGameMethod;
    if ((getStartGameMethod = GameServiceGrpc.getStartGameMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getStartGameMethod = GameServiceGrpc.getStartGameMethod) == null) {
          GameServiceGrpc.getStartGameMethod = getStartGameMethod =
              io.grpc.MethodDescriptor.<org.example.dotsandboxes.Dotsandboxes.StartGameRequest, org.example.dotsandboxes.Dotsandboxes.StartGameResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "startGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.StartGameRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.StartGameResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("startGame"))
              .build();
        }
      }
    }
    return getStartGameMethod;
  }

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
      org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse> getGetCurrentPlayerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentPlayer",
      requestType = org.example.dotsandboxes.Dotsandboxes.Empty.class,
      responseType = org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty,
      org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse> getGetCurrentPlayerMethod() {
    io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty, org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse> getGetCurrentPlayerMethod;
    if ((getGetCurrentPlayerMethod = GameServiceGrpc.getGetCurrentPlayerMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getGetCurrentPlayerMethod = GameServiceGrpc.getGetCurrentPlayerMethod) == null) {
          GameServiceGrpc.getGetCurrentPlayerMethod = getGetCurrentPlayerMethod =
              io.grpc.MethodDescriptor.<org.example.dotsandboxes.Dotsandboxes.Empty, org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentPlayer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("getCurrentPlayer"))
              .build();
        }
      }
    }
    return getGetCurrentPlayerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty,
      org.example.dotsandboxes.Dotsandboxes.WinnerResponse> getGetWinnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getWinner",
      requestType = org.example.dotsandboxes.Dotsandboxes.Empty.class,
      responseType = org.example.dotsandboxes.Dotsandboxes.WinnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty,
      org.example.dotsandboxes.Dotsandboxes.WinnerResponse> getGetWinnerMethod() {
    io.grpc.MethodDescriptor<org.example.dotsandboxes.Dotsandboxes.Empty, org.example.dotsandboxes.Dotsandboxes.WinnerResponse> getGetWinnerMethod;
    if ((getGetWinnerMethod = GameServiceGrpc.getGetWinnerMethod) == null) {
      synchronized (GameServiceGrpc.class) {
        if ((getGetWinnerMethod = GameServiceGrpc.getGetWinnerMethod) == null) {
          GameServiceGrpc.getGetWinnerMethod = getGetWinnerMethod =
              io.grpc.MethodDescriptor.<org.example.dotsandboxes.Dotsandboxes.Empty, org.example.dotsandboxes.Dotsandboxes.WinnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getWinner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.dotsandboxes.Dotsandboxes.WinnerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GameServiceMethodDescriptorSupplier("getWinner"))
              .build();
        }
      }
    }
    return getGetWinnerMethod;
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
   * <pre>
   * Сервис для игры Dots and Boxes
   * </pre>
   */
  public static abstract class GameServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Метод для начала игры
     * </pre>
     */
    public void startGame(org.example.dotsandboxes.Dotsandboxes.StartGameRequest request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.StartGameResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartGameMethod(), responseObserver);
    }

    /**
     * <pre>
     * Метод для выполнения хода
     * </pre>
     */
    public void makeMove(org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMakeMoveMethod(), responseObserver);
    }

    /**
     * <pre>
     * Метод для получения текущего игрока
     * </pre>
     */
    public void getCurrentPlayer(org.example.dotsandboxes.Dotsandboxes.Empty request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCurrentPlayerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Метод для получения победителя
     * </pre>
     */
    public void getWinner(org.example.dotsandboxes.Dotsandboxes.Empty request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.WinnerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWinnerMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartGameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.dotsandboxes.Dotsandboxes.StartGameRequest,
                org.example.dotsandboxes.Dotsandboxes.StartGameResponse>(
                  this, METHODID_START_GAME)))
          .addMethod(
            getMakeMoveMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest,
                org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse>(
                  this, METHODID_MAKE_MOVE)))
          .addMethod(
            getGetCurrentPlayerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.dotsandboxes.Dotsandboxes.Empty,
                org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse>(
                  this, METHODID_GET_CURRENT_PLAYER)))
          .addMethod(
            getGetWinnerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.example.dotsandboxes.Dotsandboxes.Empty,
                org.example.dotsandboxes.Dotsandboxes.WinnerResponse>(
                  this, METHODID_GET_WINNER)))
          .build();
    }
  }

  /**
   * <pre>
   * Сервис для игры Dots and Boxes
   * </pre>
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
     * <pre>
     * Метод для начала игры
     * </pre>
     */
    public void startGame(org.example.dotsandboxes.Dotsandboxes.StartGameRequest request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.StartGameResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Метод для выполнения хода
     * </pre>
     */
    public void makeMove(org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Метод для получения текущего игрока
     * </pre>
     */
    public void getCurrentPlayer(org.example.dotsandboxes.Dotsandboxes.Empty request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCurrentPlayerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Метод для получения победителя
     * </pre>
     */
    public void getWinner(org.example.dotsandboxes.Dotsandboxes.Empty request,
        io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.WinnerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWinnerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Сервис для игры Dots and Boxes
   * </pre>
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
     * <pre>
     * Метод для начала игры
     * </pre>
     */
    public org.example.dotsandboxes.Dotsandboxes.StartGameResponse startGame(org.example.dotsandboxes.Dotsandboxes.StartGameRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartGameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Метод для выполнения хода
     * </pre>
     */
    public org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse makeMove(org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMakeMoveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Метод для получения текущего игрока
     * </pre>
     */
    public org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse getCurrentPlayer(org.example.dotsandboxes.Dotsandboxes.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCurrentPlayerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Метод для получения победителя
     * </pre>
     */
    public org.example.dotsandboxes.Dotsandboxes.WinnerResponse getWinner(org.example.dotsandboxes.Dotsandboxes.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWinnerMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Сервис для игры Dots and Boxes
   * </pre>
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
     * <pre>
     * Метод для начала игры
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.dotsandboxes.Dotsandboxes.StartGameResponse> startGame(
        org.example.dotsandboxes.Dotsandboxes.StartGameRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Метод для выполнения хода
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse> makeMove(
        org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMakeMoveMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Метод для получения текущего игрока
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse> getCurrentPlayer(
        org.example.dotsandboxes.Dotsandboxes.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCurrentPlayerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Метод для получения победителя
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.dotsandboxes.Dotsandboxes.WinnerResponse> getWinner(
        org.example.dotsandboxes.Dotsandboxes.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWinnerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_GAME = 0;
  private static final int METHODID_MAKE_MOVE = 1;
  private static final int METHODID_GET_CURRENT_PLAYER = 2;
  private static final int METHODID_GET_WINNER = 3;

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
        case METHODID_START_GAME:
          serviceImpl.startGame((org.example.dotsandboxes.Dotsandboxes.StartGameRequest) request,
              (io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.StartGameResponse>) responseObserver);
          break;
        case METHODID_MAKE_MOVE:
          serviceImpl.makeMove((org.example.dotsandboxes.Dotsandboxes.MakeMoveRequest) request,
              (io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.MakeMoveResponse>) responseObserver);
          break;
        case METHODID_GET_CURRENT_PLAYER:
          serviceImpl.getCurrentPlayer((org.example.dotsandboxes.Dotsandboxes.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.CurrentPlayerResponse>) responseObserver);
          break;
        case METHODID_GET_WINNER:
          serviceImpl.getWinner((org.example.dotsandboxes.Dotsandboxes.Empty) request,
              (io.grpc.stub.StreamObserver<org.example.dotsandboxes.Dotsandboxes.WinnerResponse>) responseObserver);
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
              .addMethod(getStartGameMethod())
              .addMethod(getMakeMoveMethod())
              .addMethod(getGetCurrentPlayerMethod())
              .addMethod(getGetWinnerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
