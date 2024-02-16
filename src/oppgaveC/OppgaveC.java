package oppgaveC;

import java.util.Random;

public class OppgaveC {
	
	public static void main(String[] args) {

		long start = System.nanoTime();

		Random random = new Random();
		Integer[] numbers = new Integer[50000];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(1000000);
		}

		System.out.println("Før sortering: ");
		printArray(numbers);

		insertionSort(numbers);

		System.out.println("Etter sortering: ");
		printArray(numbers);

		long duration = (System.nanoTime() - start) / 1000000;
		System.out.println(duration + "ms");
	}

	private static void printArray(Integer[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	private static void insertionSort(Integer[] numbers) {

		// Flytt the minste elementet først
		for (int i = 1; i < numbers.length; i++) {
			Integer currentValue = numbers[i];

			int j = i - 1;

			while (j >= 0 && numbers[j].compareTo(currentValue) < 0) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = currentValue;
		}

			// Sett inn to elementer om gangen
		for (int i = 3; i < numbers.length; i += 2) {
			Integer smallest = numbers[i - 2];
			Integer largest = numbers[i];

			int j = i - 3;

			// Flytter elementer større enn det største til høyre
			while (j >= 0 && numbers[j].compareTo(largest) < 0) {
				numbers[j + 2] = numbers[j];
				numbers[j + 1] = numbers[j - 1];
				j -= 2;
			}

			numbers[j + 2] = largest;

			// Flytter elementer mindre enn det minste til venstre
			j = i - 1;
			while (j >= 1 && numbers[j - 1].compareTo(smallest) < 0) {
				numbers[j] = numbers[j - 2];
				numbers[j - 1] = numbers[j - 3];
				j -= 2;
			}

			numbers[j] = smallest;
		}
	}
}

