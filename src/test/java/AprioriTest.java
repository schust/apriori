import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AprioriTest {
	@Test
	public void apriori1() {
		double minSup = 0.3;

		Set<String> transaction1 = new HashSet<>();
		transaction1.add("bread");
		transaction1.add("jelly");
		transaction1.add("peanut-butter");

		Set<String> transaction2 = new HashSet<>();
		transaction2.add("bread");
		transaction2.add("peanut-butter");

		Set<String> transaction3 = new HashSet<>();
		transaction3.add("bread");
		transaction3.add("milk");
		transaction3.add("peanut-butter");

		Set<String> transaction4 = new HashSet<>();
		transaction4.add("beer");
		transaction4.add("bread");

		Set<String> transaction5 = new HashSet<>();
		transaction5.add("beer");
		transaction5.add("milk");

		List<Set<String>> transactions = new ArrayList<>();
		transactions.add(transaction1);
		transactions.add(transaction2);
		transactions.add(transaction3);
		transactions.add(transaction4);
		transactions.add(transaction5);

		AprioriAlgorithm algorithm = new AprioriAlgorithm();
		algorithm.apriori(transactions, minSup);
	}

	@Test
	public void apriori2() {
		double minSup = 0.2;

		Set<String> transaction1 = new HashSet<>();
		transaction1.add("blouse");

		Set<String> transaction2 = new HashSet<>();
		transaction2.add("coat");
		transaction2.add("pullover");
		transaction2.add("t-shirt");

		Set<String> transaction3 = new HashSet<>();
		transaction3.add("jeans");
		transaction3.add("t-shirt");

		Set<String> transaction4 = new HashSet<>();
		transaction4.add("jeans");
		transaction4.add("coat");
		transaction4.add("t-shirt");

		Set<String> transaction5 = new HashSet<>();
		transaction5.add("jeans");
		transaction5.add("shorts");

		Set<String> transaction6 = new HashSet<>();
		transaction6.add("coat");
		transaction6.add("t-shirt");

		Set<String> transaction7 = new HashSet<>();
		transaction7.add("jeans");
		transaction7.add("pullover");

		Set<String> transaction8 = new HashSet<>();
		transaction8.add("jeans");
		transaction8.add("coat");
		transaction8.add("shorts");
		transaction8.add("t-shirt");

		Set<String> transaction9 = new HashSet<>();
		transaction9.add("jeans");

		Set<String> transaction10 = new HashSet<>();
		transaction10.add("jeans");
		transaction10.add("coat");
		transaction10.add("t-shirt");

		Set<String> transaction11 = new HashSet<>();
		transaction11.add("t-shirt");

		Set<String> transaction12 = new HashSet<>();
		transaction12.add("blouse");
		transaction12.add("jeans");
		transaction12.add("coat");
		transaction12.add("pullover");
		transaction12.add("t-shirt");

		Set<String> transaction13 = new HashSet<>();
		transaction13.add("jeans");
		transaction13.add("coat");
		transaction13.add("shorts");
		transaction13.add("t-shirt");

		Set<String> transaction14 = new HashSet<>();
		transaction14.add("coat");
		transaction14.add("pullover");
		transaction14.add("t-shirt");

		Set<String> transaction15 = new HashSet<>();
		transaction15.add("jeans");
		transaction15.add("t-shirt");

		Set<String> transaction16 = new HashSet<>();
		transaction16.add("pullover");
		transaction16.add("t-shirt");

		Set<String> transaction17 = new HashSet<>();
		transaction17.add("blouse");
		transaction17.add("jeans");
		transaction17.add("pullover");

		Set<String> transaction18 = new HashSet<>();
		transaction18.add("jeans");
		transaction18.add("coat");
		transaction18.add("shorts");
		transaction18.add("t-shirt");

		Set<String> transaction19 = new HashSet<>();
		transaction19.add("jeans");

		Set<String> transaction20 = new HashSet<>();
		transaction20.add("jeans");
		transaction20.add("coat");
		transaction20.add("shorts");
		transaction20.add("t-shirt");

		List<Set<String>> transactions = new ArrayList<>();
		transactions.add(transaction1);
		transactions.add(transaction2);
		transactions.add(transaction3);
		transactions.add(transaction4);
		transactions.add(transaction5);
		transactions.add(transaction6);
		transactions.add(transaction7);
		transactions.add(transaction8);
		transactions.add(transaction9);
		transactions.add(transaction10);
		transactions.add(transaction11);
		transactions.add(transaction12);
		transactions.add(transaction13);
		transactions.add(transaction14);
		transactions.add(transaction15);
		transactions.add(transaction16);
		transactions.add(transaction17);
		transactions.add(transaction18);
		transactions.add(transaction19);
		transactions.add(transaction20);

		AprioriAlgorithm algorithm = new AprioriAlgorithm();
		algorithm.apriori(transactions, minSup);
	}
}
