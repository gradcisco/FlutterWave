package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Branch {
    /*
    {
         "id":2836,
         "branch_code":"1812051EVH",
         "branch_name":"Canara Bk (Tanzania) Ltd",
         "swift_code":null,
         "bic":null,
         "bank_id":879
      }
     */

    private int id;
    private String branch_code;
    private String branch_name;
    private String swift_code;
    private String bic;
    private int bank_id;
}
