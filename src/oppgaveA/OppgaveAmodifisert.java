package oppgaveA;

import java.util.Random;

public class OppgaveAmodifisert {

	public static void main(String[] args) {

		long start = System.nanoTime();

		Random rand = new Random();
		int[] numbers = new int[160000];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rand.nextInt(1000000);

		}

		System.out.println("before: ");
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

	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];

			int j = i - 1;

			while (j >= 0 && a[j] > temp) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = temp;
		}
	}
}
