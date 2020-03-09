package com.fabrick.webapp.service.client.impl;

import com.fabrick.webapp.model.json.cash.AccountBalance;
import com.fabrick.webapp.model.json.cash.AccountTransaction;
import com.fabrick.webapp.service.client.CashAccountManagementService;
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

/** @authorSpagnuolo Roberto on 12/05/19 */

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CashAccountManagementImpl implements CashAccountManagementService {

  private static final Logger log = LoggerFactory.getLogger(CashAccountManagementImpl.class);

  @Value("${platfr.io.rest.endpoint.Transaction}")
  private String endpointTransaction;

  @Value("${platfr.io.rest.endpoint.balance}")
  private String endpointBalance;


  @Autowired
  private RestTemplate restTemplate;

  @Override
  public AccountBalance accountBalance(Long accountId) {

    Map<String, Long> params = new HashMap<String, Long>();
    params.put("accountId", accountId);
    HttpHeaders headers = new InitHeaders().invoke();
    HttpEntity entity = new HttpEntity(headers);

    ResponseEntity<AccountBalance> response =
        restTemplate.exchange(endpointBalance, HttpMethod.GET, entity, AccountBalance.class, params);
    if (response != null) {
      return response.getBody();
    } else {
      return null;
    }
  }

  @Override
  public AccountTransaction accountTransaction(Long accountId, String fromAccountingDate, String toAccountingDate) {
    Map<String, String> params = new HashMap<String, String>();
    params.put("accountId", accountId.toString());
    params.put("fromAccountingDate", fromAccountingDate );
    params.put("toAccountingDate", toAccountingDate );
    HttpHeaders headers = new InitHeaders().invoke();
    HttpEntity entity = new HttpEntity(headers);

    ResponseEntity<AccountTransaction> response =
            restTemplate.exchange(endpointTransaction, HttpMethod.GET, entity, AccountTransaction.class, params);
    if (response != null) {
      return response.getBody();
    } else {
      return null;
    }
  }
}
