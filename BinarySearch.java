import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
	private static Scanner sc = new Scanner(System.in);
	private static int getUserNumber(String msg) {
		System.out.print(msg);
		return sc.nextInt();
	}

	private static void printArray(int arr[]) {
		ArrayList<Integer> arrs = new ArrayList<>();
		for(int i : arr)
			arrs.add(i);
		System.out.println(arrs);
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private static void sort(int[] arr) {
		int arrLen = arr.length;
		for(int i = 0; i < arrLen-1; i++)
			for(int j = i+1; j < arrLen; j++)
				if(arr[i] > arr[j])
					swap(arr, i, j);
	}

	private static void randomArrGenerate(int[] arr, int maxValue) {
		Random rand = new Random();
		for(int i = 0; i< arr.length; i++)
			arr[i] = rand.nextInt(maxValue) + 1;
	}

	private static int binarySearch(int[] arr, int head, int tail, int sVal) {
		if(head >= tail)
			if(sVal == arr[head])
				return head;
			else if(sVal == arr[tail])
				return tail;
			else return -1;
		int currIndex = (int)((head + tail) / 2);
		int currVal = arr[currIndex];
		if(sVal > currVal)
			return binarySearch(arr, currIndex + 1, tail, sVal);
		else if(sVal < currVal)
			return binarySearch(arr, head, currIndex - 1, sVal);
		else return currIndex;
	}

	public static void main(String[] args) {
		int arrLen = getUserNumber("Enter number of array: ");
		int sValue = getUserNumber("Enter search value: ");
		int arr[] = new int[arrLen];
		randomArrGenerate(arr, 10);
		sort(arr);
		System.out.print("Sorted array: ");
		printArray(arr);
		int res =  binarySearch(arr, 0, arrLen - 1, sValue);
		if(res >= 0)
			System.out.println("Found " + sValue + " at index: " + res);
		else System.out.println("Value " + sValue + " not found!");
	}
}
