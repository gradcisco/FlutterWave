package com.example.imto_flutterwave.controllers;

import com.example.imto_flutterwave.model.Banks;
import com.example.imto_flutterwave.model.Branches;
import com.example.imto_flutterwave.model.TransferRequest;
import com.example.imto_flutterwave.model.TransferResponse;
import com.example.imto_flutterwave.service.TransfersImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    TransfersImpl transfers;

    @PostMapping("/imto/callback")
    public void getTransferStatus(TransferResponse transferResponse){
        //asyncronously respond to flutter quickly
        processCallback(transferResponse);
    }

    @Async
    public void processCallback(TransferResponse transferResponse){
        System.out.println(transferResponse);
        //TO DO - Process response
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferResponse> getTransferStatus(TransferRequest transferRequest){
        System.out.println(transferRequest);
        TransferResponse transferResponse = transfers.transfer(transferRequest);
        return new ResponseEntity<>(transferResponse,HttpStatus.CREATED);
    }

    @GetMapping("/banks/{countryCode}")
    public ResponseEntity<Banks> getBanks(@PathVariable String countryCode){
        System.out.println(countryCode);
        Banks banks = transfers.getBanks(countryCode);

        return new ResponseEntity<>(banks, HttpStatus.OK);

    }

    @GetMapping("/bank/branches/{id}")
    public ResponseEntity<Branches> getBankBranches(@PathVariable String id){
        System.out.println(id);
        Branches branches = transfers.getBranches(id);

        return new ResponseEntity<>(branches, HttpStatus.OK);

    }

    @GetMapping("/transfer/{id}")
    public ResponseEntity<TransferResponse> getTransfer(@PathVariable String id){
        System.out.println(id);
        TransferResponse transferResponse = transfers.getTransfer(id);

        return new ResponseEntity<>(transferResponse, HttpStatus.OK);

    }

}

