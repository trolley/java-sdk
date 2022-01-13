package com.trolley.trolley;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Detail {

    @JsonProperty("bank-transfer")
    public BankTransfer bankTransfer;

}