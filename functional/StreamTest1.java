/*
 * 
 *	책 - Modern Java in Action 의 chap1 - 3, Functions in Java
 *  Transaction은 임의의 클래스이다.
 *  !!! 주의 !! 본 코드는 실행하면 에러가 난다
 *  transactionsByCurrencies1과 transactionsByCurrencies2는 동일한 일을 처리함을 보이는 코드이다.
 */

import java.util.stream.Collectors;

public class StreamTest1 {

	public static void main(String[] args) {
		Map<Currency, List<Transaction>> transactionsByCurrencies1 =
			    new HashMap<>();
			for (Transaction transaction : transactions) {
			    if(transaction.getPrice() > 1000){
			        Currency currency = transaction.getCurrency();
			        List<Transaction> transactionsForCurrency =
			            transactionsByCurrencies.get(currency);
			        if (transactionsForCurrency == null) {
			            transactionsForCurrency = new ArrayList<>();
			            transactionsByCurrencies.put(currency,
			                                         transactionsForCurrency);
			        }
			        transactionsForCurrency.add(transaction);
			    }
			}

		Map<Currency, List<Transaction>> transactionsByCurrencies2 = transactions.stream().filter((Transaction t) -> t.getPrice() > 1000).collect(groupingBy(Transaction::getCurrency));
	}
}
