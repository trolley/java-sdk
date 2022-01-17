package com.trolley.trolley;

/**
 * <p>Gateway class.</p>
 *
 * @author joshua
 * @version $Id: $Id
 */
public class Gateway {

    public Configuration config;
    public RecipientGateway recipient;
    public Client client;
    public BatchGateway batch;
    public RecipientAccountGateway recipientAccount;
    public BalancesGateway balances;
    public PaymentGateway payment;

    /**
     * <p>Constructor for Gateway.</p>
     *
     * @param config a {@link com.trolley.trolley.Configuration} object.
     */
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
