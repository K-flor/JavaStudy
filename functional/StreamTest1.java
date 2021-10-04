/*
 * 
 *	å - Modern Java in Action �� chap1 - 3, Functions in Java
 *  Transaction�� ������ Ŭ�����̴�.
 *  !!! ���� !! �� �ڵ�� �����ϸ� ������ ����
 *  transactionsByCurrencies1�� transactionsByCurrencies2�� ������ ���� ó������ ���̴� �ڵ��̴�.
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
