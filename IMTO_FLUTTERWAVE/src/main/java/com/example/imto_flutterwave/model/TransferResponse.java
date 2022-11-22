package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TransferResponse {
    /*
    {
   "status":"success",
   "message":"Transfer Queued Successfully",
   "data":{
      "id":376595,
      "account_number":"account_number",
      "bank_code":"GH280100",
      "full_name":"Dennis Mutegi",
      "created_at":"2022-11-20T09:37:22.000Z",
      "currency":"UGX",
      "amount":1000,
      "fee":5000,
      "status":"NEW",
      "reference":"fc36a2e02e6456bb",
      "meta":null,
      "narration":"Test Uganda bank bank transfers",
      "complete_message":"",
      "requires_approval":0,
      "is_approved":1,
      "bank_name":"FA-BANK"
   }
}
     */
    private String status;
    private String message;
    private TxnResponse data;

    private class ResponseElement{
        private int id;
        private String account_number;
        private String bank_code;
        private String full_name;
        private String created_at;
        private String currency;
        private int amount;
        private int fee;
        private String status;
        private String reference;
      //  private String meta;
        private String narration;
        private String complete_message;
        private String message;
        private int requires_approval;
        private int is_approved;
        private String bank_name;


    }
}
