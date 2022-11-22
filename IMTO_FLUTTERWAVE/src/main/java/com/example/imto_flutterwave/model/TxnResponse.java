package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TxnResponse {
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
   // private String meta;
    private String narration;
    private String complete_message;
    private String message;
    private int requires_approval;
    private int is_approved;
    private String bank_name;
}
