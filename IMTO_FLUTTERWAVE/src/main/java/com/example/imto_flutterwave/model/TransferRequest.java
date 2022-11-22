package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TransferRequest {
    /*
    {
    "account_bank": "GH280100",
    "account_number": "0031625807099",
    "amount": 500,
    "narration": "Test Uganda bank bank transfers",
    "currency": "UGX",
+   "destination_branch_code": "UG280103",
+   "beneficiary_name": "Kwame Adew"
}
     */
    private String account_bank;
    private String account_number;
    private BigDecimal amount;
    private String narration;
    private String currency;
    private String destination_branch_code;
    private String beneficiary_name;
    private String callback_url;
    private Meta meta;

}
