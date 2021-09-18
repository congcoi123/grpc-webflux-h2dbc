package com.congcoi123.example.backend.skill;

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
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: skill_api.proto")
public final class SkillAPIGrpc {

  private SkillAPIGrpc() {}

  public static final String SERVICE_NAME = "com.congcoi123.example.backend.skill.SkillAPI";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.congcoi123.example.backend.skill.CastSkillRequest,
      com.congcoi123.example.backend.skill.CastSkillRequestResponse> getCastSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CastSkill",
      requestType = com.congcoi123.example.backend.skill.CastSkillRequest.class,
      responseType = com.congcoi123.example.backend.skill.CastSkillRequestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.congcoi123.example.backend.skill.CastSkillRequest,
      com.congcoi123.example.backend.skill.CastSkillRequestResponse> getCastSkillMethod() {
    io.grpc.MethodDescriptor<com.congcoi123.example.backend.skill.CastSkillRequest, com.congcoi123.example.backend.skill.CastSkillRequestResponse> getCastSkillMethod;
    if ((getCastSkillMethod = SkillAPIGrpc.getCastSkillMethod) == null) {
      synchronized (SkillAPIGrpc.class) {
        if ((getCastSkillMethod = SkillAPIGrpc.getCastSkillMethod) == null) {
          SkillAPIGrpc.getCastSkillMethod = getCastSkillMethod = 
              io.grpc.MethodDescriptor.<com.congcoi123.example.backend.skill.CastSkillRequest, com.congcoi123.example.backend.skill.CastSkillRequestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.congcoi123.example.backend.skill.SkillAPI", "CastSkill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.congcoi123.example.backend.skill.CastSkillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.congcoi123.example.backend.skill.CastSkillRequestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SkillAPIMethodDescriptorSupplier("CastSkill"))
                  .build();
          }
        }
     }
     return getCastSkillMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.congcoi123.example.backend.skill.CastSkillRequest,
      com.congcoi123.example.backend.skill.CastSkillRequestResponse> getCastMultipleSkillMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CastMultipleSkill",
      requestType = com.congcoi123.example.backend.skill.CastSkillRequest.class,
      responseType = com.congcoi123.example.backend.skill.CastSkillRequestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.congcoi123.example.backend.skill.CastSkillRequest,
      com.congcoi123.example.backend.skill.CastSkillRequestResponse> getCastMultipleSkillMethod() {
    io.grpc.MethodDescriptor<com.congcoi123.example.backend.skill.CastSkillRequest, com.congcoi123.example.backend.skill.CastSkillRequestResponse> getCastMultipleSkillMethod;
    if ((getCastMultipleSkillMethod = SkillAPIGrpc.getCastMultipleSkillMethod) == null) {
      synchronized (SkillAPIGrpc.class) {
        if ((getCastMultipleSkillMethod = SkillAPIGrpc.getCastMultipleSkillMethod) == null) {
          SkillAPIGrpc.getCastMultipleSkillMethod = getCastMultipleSkillMethod = 
              io.grpc.MethodDescriptor.<com.congcoi123.example.backend.skill.CastSkillRequest, com.congcoi123.example.backend.skill.CastSkillRequestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.congcoi123.example.backend.skill.SkillAPI", "CastMultipleSkill"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.congcoi123.example.backend.skill.CastSkillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.congcoi123.example.backend.skill.CastSkillRequestResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SkillAPIMethodDescriptorSupplier("CastMultipleSkill"))
                  .build();
          }
        }
     }
     return getCastMultipleSkillMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SkillAPIStub newStub(io.grpc.Channel channel) {
    return new SkillAPIStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SkillAPIBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SkillAPIBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SkillAPIFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SkillAPIFutureStub(channel);
  }

  /**
   */
  public static abstract class SkillAPIImplBase implements io.grpc.BindableService {

    /**
     */
    public void castSkill(com.congcoi123.example.backend.skill.CastSkillRequest request,
        io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCastSkillMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequest> castMultipleSkill(
        io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCastMultipleSkillMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCastSkillMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.congcoi123.example.backend.skill.CastSkillRequest,
                com.congcoi123.example.backend.skill.CastSkillRequestResponse>(
                  this, METHODID_CAST_SKILL)))
          .addMethod(
            getCastMultipleSkillMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.congcoi123.example.backend.skill.CastSkillRequest,
                com.congcoi123.example.backend.skill.CastSkillRequestResponse>(
                  this, METHODID_CAST_MULTIPLE_SKILL)))
          .build();
    }
  }

  /**
   */
  public static final class SkillAPIStub extends io.grpc.stub.AbstractStub<SkillAPIStub> {
    private SkillAPIStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SkillAPIStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SkillAPIStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SkillAPIStub(channel, callOptions);
    }

    /**
     */
    public void castSkill(com.congcoi123.example.backend.skill.CastSkillRequest request,
        io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCastSkillMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequest> castMultipleSkill(
        io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCastMultipleSkillMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class SkillAPIBlockingStub extends io.grpc.stub.AbstractStub<SkillAPIBlockingStub> {
    private SkillAPIBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SkillAPIBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SkillAPIBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SkillAPIBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.congcoi123.example.backend.skill.CastSkillRequestResponse castSkill(com.congcoi123.example.backend.skill.CastSkillRequest request) {
      return blockingUnaryCall(
          getChannel(), getCastSkillMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SkillAPIFutureStub extends io.grpc.stub.AbstractStub<SkillAPIFutureStub> {
    private SkillAPIFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SkillAPIFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SkillAPIFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SkillAPIFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.congcoi123.example.backend.skill.CastSkillRequestResponse> castSkill(
        com.congcoi123.example.backend.skill.CastSkillRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCastSkillMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CAST_SKILL = 0;
  private static final int METHODID_CAST_MULTIPLE_SKILL = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SkillAPIImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SkillAPIImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CAST_SKILL:
          serviceImpl.castSkill((com.congcoi123.example.backend.skill.CastSkillRequest) request,
              (io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>) responseObserver);
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
        case METHODID_CAST_MULTIPLE_SKILL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.castMultipleSkill(
              (io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SkillAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SkillAPIBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.congcoi123.example.backend.skill.SkillApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SkillAPI");
    }
  }

  private static final class SkillAPIFileDescriptorSupplier
      extends SkillAPIBaseDescriptorSupplier {
    SkillAPIFileDescriptorSupplier() {}
  }

  private static final class SkillAPIMethodDescriptorSupplier
      extends SkillAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SkillAPIMethodDescriptorSupplier(String methodName) {
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
      synchronized (SkillAPIGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SkillAPIFileDescriptorSupplier())
              .addMethod(getCastSkillMethod())
              .addMethod(getCastMultipleSkillMethod())
              .build();
        }
      }
    }
    return result;
  }
}
