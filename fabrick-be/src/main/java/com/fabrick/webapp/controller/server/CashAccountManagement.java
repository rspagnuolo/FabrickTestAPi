package com.fabrick.webapp.controller.server;

import com.fabrick.webapp.exception.ResourceErrorException;
import com.fabrick.webapp.model.json.cash.AccountBalance;
import com.fabrick.webapp.model.json.cash.AccountTransaction;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Spagnuolo Roberto on 03/03/20
 * <p>/api/gbs/banking/v4.0/accounts/{accountId}/balance</p>
 */
@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE )
public class CashAccountManagement {

  @Autowired
  private com.fabrick.webapp.service.client.CashAccountManagement cashAccountManagement;

  @RequestMapping(
          value = "gbs/banking/v4.0/accounts/{accountId}/balance",
          method = RequestMethod.GET)
  @ApiOperation(value = "Read like Client from Web Service Rest Account balance ,example 'accountId=65482159' or 'accountId=14537780'")
  @ResponseStatus(HttpStatus.OK)
  public AccountBalance getAccountBalance(@PathVariable Long accountId){

    AccountBalance accountBalance = cashAccountManagement.accountBalance(accountId);
    if (accountBalance != null) {
      return accountBalance;
    } else {
      throw new ResourceErrorException("Error ", HttpStatus.BAD_REQUEST);
    }
  }
  @RequestMapping(
          value = "gbs/banking/v4.0/accounts/{accountId}/transactions",
          method = RequestMethod.GET)
  @ApiOperation(value = "Read like Client from Web Service Rest Account balance ,example 'accountId=65482159' or 'accountId=14537780'")
  @ResponseStatus(HttpStatus.OK)
  public AccountTransaction getAccountTransaction(@PathVariable Long accountId,@RequestParam String fromAccountingDate,@RequestParam String toAccountingDate){

    AccountTransaction accountTransaction = cashAccountManagement.accountTransaction(accountId,fromAccountingDate,toAccountingDate);
    if (accountTransaction != null) {
      return accountTransaction;
    } else {
      throw new ResourceErrorException("Error ", HttpStatus.BAD_REQUEST);
    }
  }

}
