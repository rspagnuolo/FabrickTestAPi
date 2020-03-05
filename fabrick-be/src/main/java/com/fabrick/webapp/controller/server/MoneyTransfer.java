package com.fabrick.webapp.controller.server;

import com.fabrick.webapp.exception.ResourceErrorException;
import com.fabrick.webapp.model.json.payment.MoneyTransfersRequest;
import com.fabrick.webapp.model.json.payment.MoneyTransfersResponse;
import com.fabrick.webapp.service.client.PaymentMoneyTransfers;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/** @author Spagnuolo Roberto on 03/03/20 */
@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoneyTransfer {

  @Autowired private PaymentMoneyTransfers paymentMoneyTransfers;

  @RequestMapping(
      value = "gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "Money Transfer like Client from Web Service Rest Banking Account ",
      code = 201)
  @ResponseStatus(HttpStatus.CREATED)
  public MoneyTransfersResponse moneyTransfer(
      @PathVariable Long accountId,
      @ApiParam(value = "Contains the json representation of the moneyTransfer", required = true)
          @RequestBody
              MoneyTransfersRequest moneyTransfersRequest) {

    MoneyTransfersResponse moneyTransfersResponse =
        paymentMoneyTransfers.moneyTransfers(accountId, moneyTransfersRequest);

    if (moneyTransfersResponse != null) {
      return moneyTransfersResponse;
    } else {
      throw new ResourceErrorException("Error ", HttpStatus.BAD_REQUEST);
    }
  }
}
