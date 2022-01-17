package com.trolley.trolley;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Detail class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Detail {

    @JsonProperty("bank-transfer")
    public BankTransfer bankTransfer;

}
