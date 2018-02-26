package ca.paymentrails.paymentrails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Detail {

    @JsonProperty("bank-transfer")
    public BankTransfer bankTransfer;

}