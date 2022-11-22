package com.example.imto_flutterwave.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Banks {
    private String status;
    private String message;
    private List<DataElem> data;
}
