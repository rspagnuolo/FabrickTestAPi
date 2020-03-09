package com.fabrick.webapp.service.client;

import com.fabrick.webapp.model.json.cash.AccountBalance;
import com.fabrick.webapp.model.json.cash.AccountTransaction;

/**
 * @author Spagnuolo Roberto on 12/05/19
 */

public interface CashAccountManagementService {

    AccountBalance accountBalance(Long accountId);

    AccountTransaction accountTransaction(Long accountId, String fromAccountingDate, String toAccountingDate);
}
