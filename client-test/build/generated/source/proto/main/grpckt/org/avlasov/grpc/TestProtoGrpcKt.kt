package org.avlasov.grpc

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.bidiStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.bidiStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import org.avlasov.grpc.TestServiceGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for TestService.
 */
object TestServiceGrpcKt {
  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = TestServiceGrpc.getServiceDescriptor()

  val testMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceGrpc.getTestMethod()

  val testArrayListMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceGrpc.getTestArrayListMethod()

  val testLinkedListMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceGrpc.getTestLinkedListMethod()

  val testChannelMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceGrpc.getTestChannelMethod()

  val testChannelChunkedCustomMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceGrpc.getTestChannelChunkedCustomMethod()

  /**
   * A stub for issuing RPCs to a(n) TestService service as suspending coroutines.
   */
  @StubFor(TestServiceGrpc::class)
  class TestServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<TestServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): TestServiceCoroutineStub =
        TestServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @return The single response from the server.
     */
    suspend fun test(request: TestRequest): TestResponse = unaryRpc(
      channel,
      TestServiceGrpc.getTestMethod(),
      request,
      callOptions,
      Metadata()
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun testArrayList(requests: Flow<TestRequest>): Flow<TestResponse> = bidiStreamingRpc(
      channel,
      TestServiceGrpc.getTestArrayListMethod(),
      requests,
      callOptions,
      Metadata()
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun testLinkedList(requests: Flow<TestRequest>): Flow<TestResponse> = bidiStreamingRpc(
      channel,
      TestServiceGrpc.getTestLinkedListMethod(),
      requests,
      callOptions,
      Metadata()
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun testChannel(requests: Flow<TestRequest>): Flow<TestResponse> = bidiStreamingRpc(
      channel,
      TestServiceGrpc.getTestChannelMethod(),
      requests,
      callOptions,
      Metadata()
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun testChannelChunkedCustom(requests: Flow<TestRequest>): Flow<TestResponse> =
        bidiStreamingRpc(
      channel,
      TestServiceGrpc.getTestChannelChunkedCustomMethod(),
      requests,
      callOptions,
      Metadata()
    )}

  /**
   * Skeletal implementation of the TestService service based on Kotlin coroutines.
   */
  abstract class TestServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for TestService.Test.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun test(request: TestRequest): TestResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestService.Test is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for TestService.TestArrayList.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun testArrayList(requests: Flow<TestRequest>): Flow<TestResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestService.TestArrayList is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for TestService.TestLinkedList.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun testLinkedList(requests: Flow<TestRequest>): Flow<TestResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestService.TestLinkedList is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for TestService.TestChannel.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun testChannel(requests: Flow<TestRequest>): Flow<TestResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestService.TestChannel is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for TestService.TestChannelChunkedCustom.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun testChannelChunkedCustom(requests: Flow<TestRequest>): Flow<TestResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestService.TestChannelChunkedCustom is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceGrpc.getTestMethod(),
      implementation = ::test
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceGrpc.getTestArrayListMethod(),
      implementation = ::testArrayList
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceGrpc.getTestLinkedListMethod(),
      implementation = ::testLinkedList
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceGrpc.getTestChannelMethod(),
      implementation = ::testChannel
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceGrpc.getTestChannelChunkedCustomMethod(),
      implementation = ::testChannelChunkedCustom
    )).build()
  }
}

/**
 * Holder for Kotlin coroutine-based client and server APIs for TestServiceFlow.
 */
object TestServiceFlowGrpcKt {
  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = TestServiceFlowGrpc.getServiceDescriptor()

  val testKotlinFlowMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceFlowGrpc.getTestKotlinFlowMethod()

  val testKotlinFlowCustomMethod: MethodDescriptor<TestRequest, TestResponse>
    @JvmStatic
    get() = TestServiceFlowGrpc.getTestKotlinFlowCustomMethod()

  /**
   * A stub for issuing RPCs to a(n) TestServiceFlow service as suspending coroutines.
   */
  @StubFor(TestServiceFlowGrpc::class)
  class TestServiceFlowCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<TestServiceFlowCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): TestServiceFlowCoroutineStub =
        TestServiceFlowCoroutineStub(channel, callOptions)

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun testKotlinFlow(requests: Flow<TestRequest>): Flow<TestResponse> = bidiStreamingRpc(
      channel,
      TestServiceFlowGrpc.getTestKotlinFlowMethod(),
      requests,
      callOptions,
      Metadata()
    )
    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * The [Flow] of requests is collected once each time the [Flow] of responses is
     * collected. If collection of the [Flow] of responses completes normally or
     * exceptionally before collection of `requests` completes, the collection of
     * `requests` is cancelled.  If the collection of `requests` completes
     * exceptionally for any other reason, then the collection of the [Flow] of responses
     * completes exceptionally for the same reason and the RPC is cancelled with that reason.
     *
     * @param requests A [Flow] of request messages.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    fun testKotlinFlowCustom(requests: Flow<TestRequest>): Flow<TestResponse> = bidiStreamingRpc(
      channel,
      TestServiceFlowGrpc.getTestKotlinFlowCustomMethod(),
      requests,
      callOptions,
      Metadata()
    )}

  /**
   * Skeletal implementation of the TestServiceFlow service based on Kotlin coroutines.
   */
  abstract class TestServiceFlowCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns a [Flow] of responses to an RPC for TestServiceFlow.TestKotlinFlow.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun testKotlinFlow(requests: Flow<TestRequest>): Flow<TestResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestServiceFlow.TestKotlinFlow is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for TestServiceFlow.TestKotlinFlowCustom.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param requests A [Flow] of requests from the client.  This flow can be
     *        collected only once and throws [java.lang.IllegalStateException] on attempts to
     * collect
     *        it more than once.
     */
    open fun testKotlinFlowCustom(requests: Flow<TestRequest>): Flow<TestResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method TestServiceFlow.TestKotlinFlowCustom is unimplemented"))

    final override fun bindService(): ServerServiceDefinition =
        builder(TestServiceFlowGrpc.getServiceDescriptor())
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceFlowGrpc.getTestKotlinFlowMethod(),
      implementation = ::testKotlinFlow
    ))
      .addMethod(bidiStreamingServerMethodDefinition(
      context = this.context,
      descriptor = TestServiceFlowGrpc.getTestKotlinFlowCustomMethod(),
      implementation = ::testKotlinFlowCustom
    )).build()
  }
}
