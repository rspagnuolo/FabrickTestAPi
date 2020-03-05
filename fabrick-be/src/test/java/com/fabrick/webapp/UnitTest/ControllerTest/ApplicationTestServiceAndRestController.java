package com.fabrick.webapp.UnitTest.ControllerTest;
import com.fabrick.webapp.UnitTest.AbstractTest;
import com.fabrick.webapp.model.json.cash.AccountBalance;
import com.fabrick.webapp.model.json.payment.MoneyTransfersRequest;
import com.fabrick.webapp.model.json.payment.MoneyTransfersResponse;
import com.fabrick.webapp.service.client.CashAccountManagement;
import com.fabrick.webapp.service.client.PaymentMoneyTransfers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author Spagnuolo Roberto on 03/03/20
 *
 * */


public class ApplicationTestServiceAndRestController extends AbstractTest {

  private static final Logger logger =
      Logger.getLogger(ApplicationTestServiceAndRestController.class);
      private static final String PATH_FILE_NAME = "/json/moneyTransferRequest.json";

  @Autowired private CashAccountManagement cashAccountManagement;
  @Autowired private PaymentMoneyTransfers paymentMoneyTransfers;

  @Override
  @Before
  public void setUp() {
    super.setUp();
  }

  /** Start Service Test */
  @Test
  public void accountBalanceService() {
    Long accountId = 14537780L;
    AccountBalance accountBalance = cashAccountManagement.accountBalance(accountId);
    assertThat(accountBalance.getStatus().equals("OK"));
    assertThat(accountBalance.getPayload().getBalance()).isEqualTo(-256.32);
    assertThat(accountBalance.getPayload().getAvailableBalance()).isEqualTo(-256.32);
    assertThat(accountBalance.getPayload().getCurrency().equals("EUR"));

    String str = getString(accountBalance);

    logger.info(str);
  }


  @Test
  public void createMoneyTransfersRequestService() {

    Long accountId = 14537780L;

    MoneyTransfersRequest moneyTransfersRequest = getCreateMoneyTransfersRequest();

    MoneyTransfersResponse moneyTransfersResponse =
        paymentMoneyTransfers.moneyTransfers(accountId, moneyTransfersRequest);

    assertThat(moneyTransfersResponse.getStatus().equals("OK"));
    String str = getString(moneyTransfersResponse);
    logger.info(str);
  }

  /** End Service Test */

  /** Start WebService Rest Test */

  @Test
  public void shouldGetAccountBalance() throws Exception {
    String uri = "/api/gbs/banking/v4.0/accounts/14537780/balance";

    MvcResult mvcResult =
        mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();

    int status = mvcResult.getResponse().getStatus();
    String content = mvcResult.getResponse().getContentAsString();
    AccountBalance accountBalance = super.mapFromJson(content, AccountBalance.class);

    assertEquals(200, status);
    assertThat(accountBalance.getStatus().equals("OK"));
    assertThat(accountBalance.getPayload().getBalance()).isEqualTo(-256.32);
    assertThat(accountBalance.getPayload().getAvailableBalance()).isEqualTo(-256.32);

    logger.info(mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void shouldCreateMoneyTransfersRequest() throws Exception {

    String uri = "/api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers";

    MoneyTransfersRequest MoneyTransfersRequest = getCreateMoneyTransfersRequest();
    String inputJson = super.mapToJson(MoneyTransfersRequest);
    MvcResult mvcResult =
        mvc.perform(
                MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson))
            .andReturn();

    int status = mvcResult.getResponse().getStatus();
    String str = mvcResult.getResponse().getContentAsString();
    MoneyTransfersResponse moneyTransfersResponse =
        super.mapFromJson(str, MoneyTransfersResponse.class);

    assertEquals(500, status);
    assertThat(moneyTransfersResponse.getStatus().equals("KO"));

    logger.info(mvcResult.getResponse().getContentAsString());
  }

  /** End WebService Rest Test */

  private MoneyTransfersRequest getCreateMoneyTransfersRequest() {
    MoneyTransfersRequest moneyTransfersRequest = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      moneyTransfersRequest =
              objectMapper.readValue(
                      getClass().getResourceAsStream(PATH_FILE_NAME), MoneyTransfersRequest.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return moneyTransfersRequest;
  }

  private String getString(Object object) {
    String str = null;
    try {
      str = super.mapToJson(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return str;
  }
}
