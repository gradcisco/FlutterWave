package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class DataElem {
    /* {
        "id":878,
            "code":"11274858",
            "name":"TIB Corporate Bank Limited"
    }*/
    private int id;
    private String code;
    private String name;
}
