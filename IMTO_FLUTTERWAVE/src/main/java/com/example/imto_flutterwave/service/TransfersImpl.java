package com.example.imto_flutterwave.service;

import com.example.imto_flutterwave.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
@Service
public class TransfersImpl implements Transfers{

    RestTemplate restTemplate = new RestTemplate();
    @Value("${flutterwave.getbank.url}")
    String getBankUrl = "https://api.flutterwave.com/v3/banks/<<Ccode>>";
    @Value("${flutterwave.getbank.branches.url}")
    String getBranchesUrl = "https://api.flutterwave.com/v3/banks/:id/branches";
    @Value("${flutterwave.secret}")
    String secret = "FLWSECK_TEST-42d145f0da1271c9df6dca22be6ef711-X";
    @Value("${flutterwave.transfer.get.url}")
    String transferUrl = "https://api.flutterwave.com/v3/transfers";

    @Value("${flutterwave.transfer.url}")
    String transferGetUrl = "https://api.flutterwave.com/v3/transfers/:id";


    /**
     * Get all banks for a given country code
     * @param countryCode - Two letter code representing a country eg KE - Kenya
     * @return
     */
    @Override
    public Banks getBanks(String countryCode) {
        //String url = "";
        String url = getBankUrl.replace("<<Ccode>>",countryCode);
        String secret = "FLWSECK_TEST-42d145f0da1271c9df6dca22be6ef711-X";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + secret);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Banks> response = restTemplate.exchange(url, HttpMethod.GET, request, Banks.class);

        return response.getBody();
    }

    /**
     * Request to get all branches for given bank id
     * @param bankId - Bank id obtained from the request for get banks given country
     * @return Branches.
     */
    @Override
    public Branches getBranches(String bankId) {

        String url = getBranchesUrl.replace(":id",bankId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + secret);

        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Branches> branches = restTemplate.exchange(url, HttpMethod.GET, request, Branches.class);

        return branches.getBody();
    }

    /**
     * Create a transfer(bank or mobile)
     * @param transferRequest
     * @return
     */
    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + secret);

        HttpEntity<TransferRequest> request = new HttpEntity(transferRequest, headers);
        ResponseEntity<TransferResponse> response = restTemplate.exchange(transferUrl, HttpMethod.POST, request,
                TransferResponse.class);
        return response.getBody();
    }

    /**
     * Get status of a pending transactions given the id of the transactions
     * @param id
     * @return
     */
    @Override
    public TransferResponse getTransfer(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + secret);

        HttpEntity<TransferRequest> request = new HttpEntity(headers);
        ResponseEntity<TransferResponse> response = restTemplate.exchange(transferGetUrl.replace(":id", id),
                HttpMethod.GET, request, TransferResponse.class);
        return response.getBody();
    }

    public static void main(String[] args) {
        TransfersImpl transfers = new TransfersImpl();
        Banks banks =  transfers.getBanks("TZ");

        System.out.println(banks);

        Branches branches = transfers.getBranches("879");
        System.out.println(branches);

        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setAccount_bank("GH280100");
        transferRequest.setAccount_number("account_number");
        transferRequest.setAmount(new BigDecimal(1000));
        transferRequest.setNarration("Test Uganda bank bank transfers");
        transferRequest.setCurrency("UGX");
        transferRequest.setBeneficiary_name("Dennis Mutegi");
      //  transferRequest.setCallback_url("https://webhook.site/dfc69038-075c-4bfe-88f8-d3fab60fe046");

        TransferResponse transferResponse = transfers.transfer(transferRequest);
        System.out.println(transferResponse);
//Mpesa transfer
        TransferRequest mpesaRequest = new TransferRequest();
        mpesaRequest.setAccount_bank("MPS");
        mpesaRequest.setAccount_number("+254726006531");
        mpesaRequest.setAmount(new BigDecimal(1000));
        mpesaRequest.setNarration("Test Uganda bank bank transfers");
        mpesaRequest.setCurrency("KES");
        mpesaRequest.setBeneficiary_name("Dennis Mutegi");
      //  mpesaRequest.setCallback_url("https://webhook.site/dfc69038-075c-4bfe-88f8-d3fab60fe046");

        Meta meta = new Meta("James Arthur","ZA","\"+23457558595");
        mpesaRequest.setMeta(meta);
        transferResponse = transfers.transfer(mpesaRequest);
        System.out.println(transferResponse);
        System.out.println(transfers.getTransfer("376637"));

    }
}
