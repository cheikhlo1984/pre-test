package com.priceminister.account;

import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;

/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass. Then focus
 * on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a
 * simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send
 * it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {

	Account customerAccount;
	AccountRule rule;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		customerAccount = new CustomerAccount();
	}

	/**
	 * Tests that an empty account always has a balance of 0.0, not a NULL.
	 * getBalance()
	 */
	@Test
	public void testAccountWithoutMoneyHasZeroBalance() {

		// act
		Double balance = customerAccount.getBalance();

		// assert
		assertTrue(balance==0.0d);
		assertNotNull(balance);
	}

	/**
	 * Adds money to the account and checks that the new balance is as expected.
	 */
	@Test
	public void testAddPositiveAmount() {

		// act
		customerAccount.add(50d);
		customerAccount.add(100d);

		// assert
		assertTrue(customerAccount.getBalance().equals(150d));
	}

	/**
	 * Tests that an illegal withdrawal throws the expected exception. Use the logic
	 * contained in CustomerAccountRule; feel free to refactor the existing code.
	 * 
	 * @throws IllegalBalanceException
	 */
	@Test
	public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {

		// act & arrange
		rule = new CustomerAccountRule();
		
		Double currentBalance = 100d;
		customerAccount.add(currentBalance);
		Double withdrawAmount = 70d;

		customerAccount.withdrawAndReportBalance(withdrawAmount, rule);
	}

	// Also implement missing unit tests for the above functionalities.

}
