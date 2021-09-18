package com.congcoi123.example.backend.skill;

import static com.congcoi123.example.backend.skill.SkillAPIGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by RxGrpc generator",
comments = "Source: skill_api.proto")
public final class RxSkillAPIGrpc {
    private RxSkillAPIGrpc() {}

    public static RxSkillAPIStub newRxStub(io.grpc.Channel channel) {
        return new RxSkillAPIStub(channel);
    }

    public static final class RxSkillAPIStub extends io.grpc.stub.AbstractStub<RxSkillAPIStub> {
        private SkillAPIGrpc.SkillAPIStub delegateStub;

        private RxSkillAPIStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = SkillAPIGrpc.newStub(channel);
        }

        private RxSkillAPIStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = SkillAPIGrpc.newStub(channel).build(channel, callOptions);
        }

        @java.lang.Override
        protected RxSkillAPIStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RxSkillAPIStub(channel, callOptions);
        }

        public io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequestResponse> castSkill(io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequest> rxRequest) {
            return com.salesforce.rxgrpc.stub.ClientCalls.oneToOne(rxRequest,
                new com.salesforce.reactivegrpc.common.BiConsumer<com.congcoi123.example.backend.skill.CastSkillRequest, io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>>() {
                    @java.lang.Override
                    public void accept(com.congcoi123.example.backend.skill.CastSkillRequest request, io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> observer) {
                        delegateStub.castSkill(request, observer);
                    }
                }, getCallOptions());
        }

        public io.reactivex.Flowable<com.congcoi123.example.backend.skill.CastSkillRequestResponse> castMultipleSkill(io.reactivex.Flowable<com.congcoi123.example.backend.skill.CastSkillRequest> rxRequest) {
            return com.salesforce.rxgrpc.stub.ClientCalls.manyToMany(rxRequest,
                new com.salesforce.reactivegrpc.common.Function<io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>, io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequest>>() {
                    @java.lang.Override
                    public io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequest> apply(io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> observer) {
                        return delegateStub.castMultipleSkill(observer);
                    }
                }, getCallOptions());
        }

        public io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequestResponse> castSkill(com.congcoi123.example.backend.skill.CastSkillRequest rxRequest) {
            return com.salesforce.rxgrpc.stub.ClientCalls.oneToOne(io.reactivex.Single.just(rxRequest),
                new com.salesforce.reactivegrpc.common.BiConsumer<com.congcoi123.example.backend.skill.CastSkillRequest, io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>>() {
                    @java.lang.Override
                    public void accept(com.congcoi123.example.backend.skill.CastSkillRequest request, io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse> observer) {
                        delegateStub.castSkill(request, observer);
                    }
                }, getCallOptions());
        }

    }

    public static abstract class SkillAPIImplBase implements io.grpc.BindableService {

        public io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequestResponse> castSkill(io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.reactivex.Flowable<com.congcoi123.example.backend.skill.CastSkillRequestResponse> castMultipleSkill(io.reactivex.Flowable<com.congcoi123.example.backend.skill.CastSkillRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            com.congcoi123.example.backend.skill.SkillAPIGrpc.getCastSkillMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            com.congcoi123.example.backend.skill.CastSkillRequest,
                                            com.congcoi123.example.backend.skill.CastSkillRequestResponse>(
                                            this, METHODID_CAST_SKILL)))
                    .addMethod(
                            com.congcoi123.example.backend.skill.SkillAPIGrpc.getCastMultipleSkillMethod(),
                            asyncBidiStreamingCall(
                                    new MethodHandlers<
                                            com.congcoi123.example.backend.skill.CastSkillRequest,
                                            com.congcoi123.example.backend.skill.CastSkillRequestResponse>(
                                            this, METHODID_CAST_MULTIPLE_SKILL)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_CAST_SKILL = 0;
    public static final int METHODID_CAST_MULTIPLE_SKILL = 1;

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
                    com.salesforce.rxgrpc.stub.ServerCalls.oneToOne((com.congcoi123.example.backend.skill.CastSkillRequest) request,
                            (io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>) responseObserver,
                            new com.salesforce.reactivegrpc.common.Function<io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequest>, io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequestResponse>>() {
                                @java.lang.Override
                                public io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequestResponse> apply(io.reactivex.Single<com.congcoi123.example.backend.skill.CastSkillRequest> single) {
                                    return serviceImpl.castSkill(single);
                                }
                            });
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CAST_MULTIPLE_SKILL:
                    return (io.grpc.stub.StreamObserver<Req>) com.salesforce.rxgrpc.stub.ServerCalls.manyToMany(
                            (io.grpc.stub.StreamObserver<com.congcoi123.example.backend.skill.CastSkillRequestResponse>) responseObserver,
                            serviceImpl::castMultipleSkill, serviceImpl.getCallOptions(methodId));
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
