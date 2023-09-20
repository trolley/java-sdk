package com.trolley.types;

import com.trolley.Configuration;
import com.trolley.types.supporting.CAD;
import com.trolley.types.supporting.EUR;
import com.trolley.types.supporting.USD;

public class Balances
{
    public EUR EUR;
    public USD USD;
    public CAD CAD;
    
    public EUR getEUR() {
        return this.EUR;
    }
    
    public void setEUR(final EUR EUR) {
        this.EUR = EUR;
    }
    
    public USD getUSD() {
        return this.USD;
    }
    
    public void setUSD(final USD USD) {
        this.USD = USD;
    }
    
    public CAD getCAD() {
        return this.CAD;
    }
    
    public void setCAD(final CAD CAD) {
        this.CAD = CAD;
    }
    
    public static String find() throws Exception {
        return find("");
    }
    
    public static String find(final String term) throws Exception {
        return Configuration.gateway().balances.find(term);
    }
}
