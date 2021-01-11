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
public final class TestServiceFlowGrpc {

  private TestServiceFlowGrpc() {}

  public static final String SERVICE_NAME = "TestServiceFlow";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestKotlinFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestKotlinFlow",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestKotlinFlowMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestKotlinFlowMethod;
    if ((getTestKotlinFlowMethod = TestServiceFlowGrpc.getTestKotlinFlowMethod) == null) {
      synchronized (TestServiceFlowGrpc.class) {
        if ((getTestKotlinFlowMethod = TestServiceFlowGrpc.getTestKotlinFlowMethod) == null) {
          TestServiceFlowGrpc.getTestKotlinFlowMethod = getTestKotlinFlowMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestKotlinFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceFlowMethodDescriptorSupplier("TestKotlinFlow"))
              .build();
        }
      }
    }
    return getTestKotlinFlowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestKotlinFlowCustomMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestKotlinFlowCustom",
      requestType = org.avlasov.grpc.TestRequest.class,
      responseType = org.avlasov.grpc.TestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest,
      org.avlasov.grpc.TestResponse> getTestKotlinFlowCustomMethod() {
    io.grpc.MethodDescriptor<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse> getTestKotlinFlowCustomMethod;
    if ((getTestKotlinFlowCustomMethod = TestServiceFlowGrpc.getTestKotlinFlowCustomMethod) == null) {
      synchronized (TestServiceFlowGrpc.class) {
        if ((getTestKotlinFlowCustomMethod = TestServiceFlowGrpc.getTestKotlinFlowCustomMethod) == null) {
          TestServiceFlowGrpc.getTestKotlinFlowCustomMethod = getTestKotlinFlowCustomMethod =
              io.grpc.MethodDescriptor.<org.avlasov.grpc.TestRequest, org.avlasov.grpc.TestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestKotlinFlowCustom"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.avlasov.grpc.TestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TestServiceFlowMethodDescriptorSupplier("TestKotlinFlowCustom"))
              .build();
        }
      }
    }
    return getTestKotlinFlowCustomMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServiceFlowStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFlowStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFlowStub>() {
        @java.lang.Override
        public TestServiceFlowStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFlowStub(channel, callOptions);
        }
      };
    return TestServiceFlowStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServiceFlowBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFlowBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFlowBlockingStub>() {
        @java.lang.Override
        public TestServiceFlowBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFlowBlockingStub(channel, callOptions);
        }
      };
    return TestServiceFlowBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServiceFlowFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestServiceFlowFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TestServiceFlowFutureStub>() {
        @java.lang.Override
        public TestServiceFlowFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TestServiceFlowFutureStub(channel, callOptions);
        }
      };
    return TestServiceFlowFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TestServiceFlowImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testKotlinFlow(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestKotlinFlowMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testKotlinFlowCustom(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getTestKotlinFlowCustomMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTestKotlinFlowMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST_KOTLIN_FLOW)))
          .addMethod(
            getTestKotlinFlowCustomMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                org.avlasov.grpc.TestRequest,
                org.avlasov.grpc.TestResponse>(
                  this, METHODID_TEST_KOTLIN_FLOW_CUSTOM)))
          .build();
    }
  }

  /**
   */
  public static final class TestServiceFlowStub extends io.grpc.stub.AbstractAsyncStub<TestServiceFlowStub> {
    private TestServiceFlowStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFlowStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFlowStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testKotlinFlow(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestKotlinFlowMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.avlasov.grpc.TestRequest> testKotlinFlowCustom(
        io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTestKotlinFlowCustomMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TestServiceFlowBlockingStub extends io.grpc.stub.AbstractBlockingStub<TestServiceFlowBlockingStub> {
    private TestServiceFlowBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFlowBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFlowBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class TestServiceFlowFutureStub extends io.grpc.stub.AbstractFutureStub<TestServiceFlowFutureStub> {
    private TestServiceFlowFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServiceFlowFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestServiceFlowFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TEST_KOTLIN_FLOW = 0;
  private static final int METHODID_TEST_KOTLIN_FLOW_CUSTOM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServiceFlowImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServiceFlowImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEST_KOTLIN_FLOW:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testKotlinFlow(
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
        case METHODID_TEST_KOTLIN_FLOW_CUSTOM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.testKotlinFlowCustom(
              (io.grpc.stub.StreamObserver<org.avlasov.grpc.TestResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TestServiceFlowBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServiceFlowBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.avlasov.grpc.TestProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestServiceFlow");
    }
  }

  private static final class TestServiceFlowFileDescriptorSupplier
      extends TestServiceFlowBaseDescriptorSupplier {
    TestServiceFlowFileDescriptorSupplier() {}
  }

  private static final class TestServiceFlowMethodDescriptorSupplier
      extends TestServiceFlowBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServiceFlowMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestServiceFlowGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServiceFlowFileDescriptorSupplier())
              .addMethod(getTestKotlinFlowMethod())
              .addMethod(getTestKotlinFlowCustomMethod())
              .build();
        }
      }
    }
    return result;
  }
}
