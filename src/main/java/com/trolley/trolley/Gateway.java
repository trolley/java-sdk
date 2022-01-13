package com.trolley.trolley;

public class Gateway {

    public Configuration config;
    public RecipientGateway recipient;
    public Client client;
    public BatchGateway batch;
    public RecipientAccountGateway recipientAccount;
    public BalancesGateway balances;
    public PaymentGateway payment;

    public Gateway(Configuration config) {
        this.config = config;
        this.client = new Client(config);
        this.recipient = new RecipientGateway(config);
        this.batch = new BatchGateway(config);
        this.recipientAccount = new RecipientAccountGateway(config);
        this.balances = new BalancesGateway(config);
        this.payment = new PaymentGateway(config);

    }
}