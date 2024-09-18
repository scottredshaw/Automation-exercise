package account;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


//Application Code

public class Account {
	
	String name;
	String number;
	private BigDecimal balance;
    private Map<String, BigDecimal> transactions;
	
	public Account(String name, String number) {
		this.name = name;
		this.number = number;
		this.balance = new BigDecimal("0");
		this.transactions = Collections.emptyMap();
	}

	public void getDeposits(Map<String, BigDecimal> deposit_arr)
	{
		//List<String> new_transactions = new ArrayList<>();
		BigDecimal new_balance = new BigDecimal("0");
		for (Map.Entry<String,BigDecimal> entry : deposit_arr.entrySet()) {
			//new_transactions.add(entry.getKey());
			new_balance = new_balance.add(entry.getValue());
		}
		this.transactions = new HashMap<>(deposit_arr);
		this.balance = new_balance;
	}
	
	public void makeWithdrawl(Map<String, BigDecimal> withdrawl_arr) {
		for (Map.Entry<String,BigDecimal> entry : withdrawl_arr.entrySet()) {
			BigDecimal new_balance = this.balance.subtract(entry.getValue());
			if(new_balance.compareTo(BigDecimal.ZERO) > 0) {
				this.balance = this.balance.subtract(entry.getValue());
				this.transactions.put(entry.getKey(), entry.getValue().negate());
			}
			else {
				System.out.println("" + entry + " unable to withdrawl due to insufficient funds");
			}
		}
		System.out.println(this.transactions);
	}
	
	public void createStatement() {
		System.out.println("Name: " + this.name);
		System.out.println("Account: " + this.number);
		System.out.println("Balance: " + this.balance);
	}
	
	public void printStatement(String key) {
		BigDecimal value = this.transactions.get(key);
		System.out.println("Transaction: " + key + " Amount: " + value);
	}
}
