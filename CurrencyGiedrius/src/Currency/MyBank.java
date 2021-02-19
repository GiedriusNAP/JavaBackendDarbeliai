package Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lt.itakademija.exam.Account;
import lt.itakademija.exam.AccountCreateException;
import lt.itakademija.exam.Bank;
import lt.itakademija.exam.Currency;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.Customer;
import lt.itakademija.exam.CustomerCreateException;
import lt.itakademija.exam.InsufficientFundsException;
import lt.itakademija.exam.Money;
import lt.itakademija.exam.Operation;
import lt.itakademija.exam.PersonCode;
import lt.itakademija.exam.PersonName;
import lt.itakademija.exam.SequenceGenerator;

public class MyBank implements Bank {
	private CurrencyConverter currencyConverter;
	private SequenceGenerator sequenceGenerator = new SequenceGenerator();
	private List<Account> accounts = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();
	private Long accountID = 1L;
	private Long operationID = 1L;

	public MyBank(CurrencyConverter currencyConverter) {
		this.currencyConverter = currencyConverter;
	}

	@Override
	public Account createAccount(Customer customer, Currency currency) {
		if (customer == null || currency == null) {
			throw new NullPointerException();
		}
		if (!customers.stream().anyMatch(cus -> cus.equals(customer))) {
			throw new AccountCreateException("Can't create account for non existing customer.");
		}
		Account newAccount = new Account(accountID++, customer, currency, new Money(0.0));
		accounts.add(newAccount);
		customer.addAccount(newAccount);
		return newAccount;
	}

	@Override
	public Customer createCustomer(PersonCode personCode, PersonName personName) {
		if (customers.stream().map(c -> c.getPersonCode()).anyMatch(pc -> pc.equals(personCode))) {
			throw new CustomerCreateException("Customer with this Person Code exists in database");
		}
		if (personCode == null || personName == null) {
			throw new NullPointerException();
		}
		Customer newCustomer = new Customer(sequenceGenerator.getNext(), personCode, personName);
		customers.add(newCustomer);
		return newCustomer;
	}

	@Override
	public Money getBalance(Currency currency) {
		Money amount = new Money(0);
		List<Money> allConvertedBalances = accounts.stream()
				.map(acc -> currencyConverter.convert(acc.getCurrency(), currency, acc.getBalance()))
				.collect(Collectors.toList());
		for (Money money : allConvertedBalances) {
			amount = amount.add(money);
		}
		return amount;
	}

	@Override
	public Operation transferMoney(Account debitAccount, Account creditAccount, Money debitAmount) {
		if (debitAmount.isGreaterThan(debitAccount.getBalance())) {
			throw new InsufficientFundsException("Not enough money");
		}
		if (debitAccount.getCurrency().equals(creditAccount.getCurrency())) {
			return new Operation(operationID++, debitAccount, creditAccount, debitAmount);
		} else {
			Money convertedMoney = currencyConverter.convert(debitAccount.getCurrency(), creditAccount.getCurrency(),
					debitAmount);
			debitAccount.setBalance(debitAccount.getBalance().substract(debitAmount));
			creditAccount.setBalance(creditAccount.getBalance().add(convertedMoney));
			return new Operation(operationID++, debitAccount, creditAccount, debitAmount);
		}
	}
}
