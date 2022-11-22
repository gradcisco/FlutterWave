package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Meta{
    /*
    "meta":
    {
+           "sender": "James Arthur",
+           "sender_country": "ZA",
+           "mobile_number": "+23457558595"
    }
     */
    private String sender;
    private String sender_country;
    private String mobile_number;
}