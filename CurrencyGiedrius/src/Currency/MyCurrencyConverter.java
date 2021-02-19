package Currency;

import lt.itakademija.exam.Currency;
import lt.itakademija.exam.CurrencyConversionException;
import lt.itakademija.exam.CurrencyConverter;
import lt.itakademija.exam.CurrencyRatesProvider;
import lt.itakademija.exam.Money;

public class MyCurrencyConverter implements CurrencyConverter {
	private CurrencyRatesProvider currencyRatesProvider;

	public MyCurrencyConverter(CurrencyRatesProvider currencyRatesProvider) {
		this.currencyRatesProvider = currencyRatesProvider;
	}

	@Override
	public Money convert(Currency from, Currency to, Money amount) {
		Money rate = currencyRatesProvider.getRate(from, to);
		if (rate == null) {
			throw new CurrencyConversionException("Can't get rate and convert.");
		}
		return rate.multiply(amount);
	}

}
