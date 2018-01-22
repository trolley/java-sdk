package ca.paymentrails.paymentrails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Detail {

    @JsonProperty("bank-transfer")
    public BankTransfer bankTransfer;

}