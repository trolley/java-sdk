package ca.paymentrails.paymentrails;

public class Gateway {

    Configuration config;
    RecipientGateway recipient;
    Client client;
    BatchGateway batch;
    RecipientAccountGateway recipientAccount;
    BalancesGateway balances;
    PaymentGateway payment;

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