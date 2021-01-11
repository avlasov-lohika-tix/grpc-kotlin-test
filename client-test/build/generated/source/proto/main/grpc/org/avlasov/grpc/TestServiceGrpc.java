package org.avlasov.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.30.1)",
    comments = "Source: test.proto")
public final class TestServiceGrpc {

  private TestServiceGrpc() {}

  public static final String SERVICE_NAME = "TestService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Test",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestMethod;
    if ((getTestMethod = TestServiceGrpc.getTestMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestMethod = TestServiceGrpc.getTestMethod) == null) {
          TestServiceGrpc.getTestMethod = getTestMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Test"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("Test"))
              .build();
        }
      }
    }
    return getTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestArrayListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestArrayList",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestArrayListMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestArrayListMethod;
    if ((getTestArrayListMethod = TestServiceGrpc.getTestArrayListMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestArrayListMethod = TestServiceGrpc.getTestArrayListMethod) == null) {
          TestServiceGrpc.getTestArrayListMethod = getTestArrayListMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestArrayList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestArrayList"))
              .build();
        }
      }
    }
    return getTestArrayListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestLinkedListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestLinkedList",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestLinkedListMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestLinkedListMethod;
    if ((getTestLinkedListMethod = TestServiceGrpc.getTestLinkedListMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestLinkedListMethod = TestServiceGrpc.getTestLinkedListMethod) == null) {
          TestServiceGrpc.getTestLinkedListMethod = getTestLinkedListMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestLinkedList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestLinkedList"))
              .build();
        }
      }
    }
    return getTestLinkedListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestChannel",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestChannelMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestChannelMethod;
    if ((getTestChannelMethod = TestServiceGrpc.getTestChannelMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestChannelMethod = TestServiceGrpc.getTestChannelMethod) == null) {
          TestServiceGrpc.getTestChannelMethod = getTestChannelMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestChannel"))
              .build();
        }
      }
    }
    return getTestChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestChannelChunkedCustomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestChannelChunkedCustom",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestChannelChunkedCustomMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestChannelChunkedCustomMethod;
    if ((getTestChannelChunkedCustomMethod = TestServiceGrpc.getTestChannelChunkedCustomMethod) == null) {
      synchronized (TestServiceGrpc.class) {
        if ((getTestChannelChunkedCustomMethod = TestServiceGrpc.getTestChannelChunkedCustomMethod) == null) {
          TestServiceGrpc.getTestChannelChunkedCustomMethod = getTestChannelChunkedCustomMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestChannelChunkedCustom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceMethodDescriptorSupplier("TestChannelChunkedCustom"))
              .build();
        }
      }
    }
    return getTestChannelChunkedCustomMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceStub>() {
        @java.lang.Override
        public TestServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceStub(channel, callOptions);
        }
      };
    return TestServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceBlockingStub>() {
        @java.lang.Override
        public TestServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceBlockingStub(channel, callOptions);
        }
      };
    return TestServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFutureStub>() {
        @java.lang.Override
        public TestServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFutureStub(channel, callOptions);
        }
      };
    return TestServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TestServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void test(org.avlasov.grpc.TestRequest request,
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getTestMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testArrayList(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestArrayListMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testLinkedList(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestLinkedListMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testChannel(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestChannelMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testChannelChunkedCustom(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestChannelChunkedCustomMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST)))
          .addMethod(
            getTestArrayListMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST_ARRAY_LIST)))
          .addMethod(
            getTestLinkedListMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST_LINKED_LIST)))
          .addMethod(
            getTestChannelMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST_CHANNEL)))
          .addMethod(
            getTestChannelChunkedCustomMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST_CHANNEL_CHUNKED_CUSTOM)))
          .build();
    }
  }

  /**
   */
  public static final class TestServiceStub extends io.grpc.stub.AbstractAsyncStub<TestServiceStub> {
    private TestServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceStub(channel, callOptions);
    }

    /**
     */
    public void test(org.avlasov.grpc.TestRequest request,
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testArrayList(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestArrayListMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testLinkedList(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestLinkedListMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testChannel(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestChannelMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testChannelChunkedCustom(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestChannelChunkedCustomMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TestServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceBlockingStub> {
    private TestServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.avlasov.grpc.TestResponse test(org.avlasov.grpc.TestRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFutureStub> {
    private TestServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.avlasov.grpc.TestResponse> test(
        org.avlasov.grpc.TestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEST = 0;
  private static final int METHODID_TEST_ARRAY_LIST = 1;
  private static final int METHODID_TEST_LINKED_LIST = 2;
  private static final int METHODID_TEST_CHANNEL = 3;
  private static final int METHODID_TEST_CHANNEL_CHUNKED_CUSTOM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST:
          serviceImpl.test((org.avlasov.grpc.TestRequest) request,
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
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
        case METHODID_TEST_ARRAY_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testArrayList(
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
        case METHODID_TEST_LINKED_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testLinkedList(
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
        case METHODID_TEST_CHANNEL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testChannel(
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
        case METHODID_TEST_CHANNEL_CHUNKED_CUSTOM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testChannelChunkedCustom(
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.avlasov.grpc.TestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestService");
    }
  }

  private static final class TestServiceFileDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier {
    TestServiceFileDescriptorSupplier() {}
  }

  private static final class TestServiceMethodDescriptorSupplier
      extends TestServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFileDescriptorSupplier())
              .addMethod(getTestMethod())
              .addMethod(getTestArrayListMethod())
              .addMethod(getTestLinkedListMethod())
              .addMethod(getTestChannelMethod())
              .addMethod(getTestChannelChunkedCustomMethod())
              .build();
        }
      }
    }
    return result;
  }
}
