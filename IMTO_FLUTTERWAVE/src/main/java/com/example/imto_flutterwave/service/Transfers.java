package com.example.imto_flutterwave.service;

import com.example.imto_flutterwave.model.Banks;
import com.example.imto_flutterwave.model.Branches;
import com.example.imto_flutterwave.model.TransferRequest;
import com.example.imto_flutterwave.model.TransferResponse;

public interface Transfers {

    Banks getBanks(String countryCode);
    Branches getBranches(String bankId);

    TransferResponse transfer(TransferRequest transferRequest);

    TransferResponse getTransfer(String id);
}
