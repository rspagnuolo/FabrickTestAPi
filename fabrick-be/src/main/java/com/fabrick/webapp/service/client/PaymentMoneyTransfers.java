package com.fabrick.webapp.service.client;

import com.fabrick.webapp.model.json.payment.MoneyTransfersRequest;
import com.fabrick.webapp.model.json.payment.MoneyTransfersResponse;

/**
 * @author Spagnuolo Roberto on 03/03/20
 */

public interface PaymentMoneyTransfers {

    MoneyTransfersResponse moneyTransfers(Long accountId , MoneyTransfersRequest moneyTransfersRequest);
}
