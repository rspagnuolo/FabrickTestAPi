package com.fabrick.webapp.service.client.impl;

import com.fabrick.webapp.service.client.PaymentMoneyTransfers;
import com.fabrick.webapp.model.json.payment.MoneyTransfersRequest;
import com.fabrick.webapp.model.json.payment.MoneyTransfersResponse;
import com.fabrick.webapp.utility.InitHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/** @author Spagnuolo Roberto on 03/03/20 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PaymentMoneyTransfersImpl implements PaymentMoneyTransfers {

  private static final Logger log = LoggerFactory.getLogger(PaymentMoneyTransfersImpl.class);

  @Value("${platfr.io.auth.endpoint.moneyTransfers}")
  private String endpoint;

  @Autowired private RestTemplate restTemplate;

  @Override
  public MoneyTransfersResponse moneyTransfers(
      Long accountId, MoneyTransfersRequest moneyTransfersRequest) {

    Map<String, Long> params = new HashMap<String, Long>();
    params.put("accountId", accountId);

    HttpHeaders headers = new InitHeaders().invoke();

    HttpEntity<MoneyTransfersRequest> entity = new HttpEntity(moneyTransfersRequest, headers);

    ResponseEntity<MoneyTransfersResponse> response =
        restTemplate.exchange(
            endpoint, HttpMethod.POST, entity, MoneyTransfersResponse.class, params);

    if (response != null) {
      return response.getBody();
    } else {
      return null;
    }
  }
}
