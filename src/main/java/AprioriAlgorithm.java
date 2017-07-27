import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Setter
@Getter
public class AprioriAlgorithm {
	private Set<Set<String>> startItems;

	public Set<Set<String>> apriori(List<Set<String>> transactions, double minimumSupport) {
		int k = 0;
		Set<Set<String>> result = new HashSet<>();
		Set<String> allItems = getAllItems(transactions);
		Map<Set<String>, AtomicInteger> itemsetCounts;

		Set<Set<String>> currentCandidates = initializeCandidates(allItems);
		Set<Set<String>> nextCandidates = new HashSet<>();
		Set<Set<String>> currentFrequentItemsets;

		while (true) {
			k++;
			currentFrequentItemsets = new HashSet<>();
			System.out.println(String.format("current candidates at %d: %s", k, toString(currentCandidates, ",")));

			itemsetCounts = countFrequencies(transactions, currentCandidates);

			for (Set<String> candidate : currentCandidates) {
				if (!itemsetCounts.containsKey(candidate)) {
					continue;
				}

				double count = itemsetCounts.get(candidate).doubleValue();
				double frequency = count / transactions.size();

				System.out.println(toString(candidate) + " has support of " + frequency);

				if (minimumSupport <= frequency) {
					currentFrequentItemsets.add(candidate);
				}
			}

			System.out.println(String.format("FIMs for k=%d: %s", k, toString(currentFrequentItemsets, ",")));

			// CREATE CANDIDATES FOR NEXT ROUND
			nextCandidates = generateCandidates(currentFrequentItemsets);

			if (nextCandidates.isEmpty()) {
				break;
			} else {
				currentCandidates = nextCandidates;
			}
		}

		return result;
	}

	public String toString(Set<String> itemset) {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");

		for (String item : itemset) {
			builder.append(item).append(" ");
		}

		builder.append(" ]");

		return builder.toString();
	}

	public String toString(Set<Set<String>> itemsets, String sep) {
		StringBuilder builder = new StringBuilder();
		builder.append("{ ");

		for (Set<String> itemset : itemsets) {
			String itemsetAsString = toString(itemset);
			builder.append(itemsetAsString).append(sep).append(" ");
		}

		builder.append(" }");

		return builder.toString();
	}

	private Map<Set<String>, AtomicInteger> countFrequencies(Collection<Set<String>> transactions, Set<Set<String>> currentCandidates) {
		Map<Set<String>, AtomicInteger> itemsetCounts = new HashMap<>();
		for (Set<String> transaction : transactions) {
			for (Set<String> candidate : currentCandidates) {
				if (transaction.containsAll(candidate)) {
					if (itemsetCounts.containsKey(candidate)) {
						itemsetCounts.get(candidate).incrementAndGet();
					} else {
						itemsetCounts.put(candidate, new AtomicInteger(1));
					}
				}
			}
		}

		return itemsetCounts;
	}

	private Set<Set<String>> initializeCandidates(Set<String> allItems) {
		Set<Set<String>> candidates = new HashSet<>();
		for (String item : allItems) {
			Set<String> itemset = new HashSet<>();
			itemset.add(item);
			candidates.add(itemset);
		}
		return candidates;
	}

	private Set<String> getAllItems(Collection<Set<String>> transactions) {
		Set<String> items = new HashSet<>();

		for (Set<String> transaction : transactions) {
			items.addAll(transaction);
		}

		return items;
	}

	private Set<Set<String>> generateCandidates(Set<Set<String>> lastFrequentItems) {
		Set<Set<String>> candidates = new HashSet<>();

		for (Set<String> frequentItemset1 : lastFrequentItems) {
			for (Set<String> frequentItemset2 : lastFrequentItems) {
				if (!frequentItemset1.equals(frequentItemset2)) {
					Sets.SetView<String> difference = Sets.difference(frequentItemset1, frequentItemset2);
					if (difference.size() == 1) {
						candidates.add(Sets.union(frequentItemset1, frequentItemset2));
					}
				}
			}
		}

		return candidates;
	}
}
