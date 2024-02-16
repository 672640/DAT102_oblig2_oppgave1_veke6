package oppgaveB;

import java.util.Random;

public class OppgaveB {

	public static void main(String[] args) {

		long start = System.nanoTime();

		Random random = new Random();
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}

		System.out.println("Before: ");
		printArray(numbers);

		insertionSort(numbers);

		System.out.println("\nAfter: ");
		printArray(numbers);

		long duration = (System.nanoTime() - start) / 1000000;
		System.out.println(duration + "ms");
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	private static void insertionSort(int[] a) {
		for (int i = 2; i < a.length; i += 2) {
			int minste = a[i - 1];
			int største = a[i];

			int j = i - 2;

			while (j >= 0 && (a[j] > største || a[j] > minste)) {
				a[j + 2] = a[j];
				a[j + 1] = a[j - 1];
				j -= 2;
			}

			a[j + 2] = største;
			a[j + 1] = minste;
		}
	}
}
