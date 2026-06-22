package com.pm.billingservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    @Override
    public void createBillingAccount(BillingRequest billingRequest, StreamObserver<BillingResponse> responseObserver) {

        log.info("Received createBillingAccount request: {}", billingRequest.toString());

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("ACC123456")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
