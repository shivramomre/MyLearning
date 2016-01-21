package coding.problem;
import java.util.Arrays;
import java.util.Stack;

import javax.swing.JOptionPane;
import org.junit.Test;
import util.Input;
import util.Output;

public class Sorting {

	/* For more details about the sorting algo refer this page
	 * http://java2novice.com/java-sorting-algorithms/
	 * */
	@Test
	public void testSorting()
	{
		boolean flag = false;
		while(!flag)
		{
			String[] choice = new String[]
					{
							"Bubble Sort",
							"Selection Sort",
							"Insertion Sort",
							"Quick Sort",
							"Merge Sort",
							"Heap Sort",
							"Sort usgin stack(code not linked)"
					};
			String choiceVal = (String) JOptionPane.showInputDialog(null, "Please input the sorting method.", "Sorting", JOptionPane.PLAIN_MESSAGE, null, choice, 0);

			if(choiceVal != null)
			{
				Integer[] intArr = Input.readIntArrayValues();
				switch (choiceVal) {
				case "Bubble Sort":
					showOutput(intArr, bubbleSort(intArr), "Bubble Sort");
					break;
				case "Selection Sort":
					showOutput(intArr, selectionSort(intArr), "Selection Sort");
					break;
				case "Insertion Sort":
					showOutput(intArr, insertionSort(intArr), "Insertion Sort");
					break;
				case "Quick Sort":
					showOutput(intArr, quickSort(intArr), "Quick Sort");
					break;
				case "Merge Sort":
					showOutput(intArr, mergeSort(intArr), "Merge Sort");
					break;
				case "Heap Sort":
					showOutput(intArr, heapSort(intArr), "Heap Sort");
					break;
				default:
					break;
				}
			}
			int val = JOptionPane.showConfirmDialog(null, "Do you want to continue ?", "Sorting", JOptionPane.YES_NO_OPTION);
			if(val != 0)
				flag = true;
		}
	}

	public static Integer[] bubbleSort(Integer[] inArr)
	{
		Integer[] outArr = inArr.clone();
		for(int i=0; i < outArr.length-1; i++)
		{
			for(int j=0; j<outArr.length-i-1 ; j++)
			{
				if(outArr[j] > outArr[j+1])
				{
					Integer temp = outArr[j];
					outArr[j] = outArr[j+1];
					outArr[j+1] = temp;
				}
			}
		}
		return outArr;
	}

	public static Integer[] selectionSort(Integer[] inArr)
	{
		Integer[] outArr = inArr.clone();
		for(int i=0; i < outArr.length-1; i++)
		{ 
			int index = i;
			for (int j = i + 1; j < outArr.length; j++)
			{
				if (outArr[j] < outArr[index])
					index = j;
			}

			int smallerNumber = outArr[index]; 
			outArr[index] = outArr[i];
			outArr[i] = smallerNumber;
		}
		return outArr;
	}

	public static Integer[] insertionSort(Integer[] inArr)
	{
		Integer[] outArr = inArr.clone();
		for(int i=1; i < outArr.length; i++)
		{ 
			for (int j = i; j > 0; j--)
			{
				if (outArr[j] < outArr[j-1])
				{
					int temp = outArr[j]; 
					outArr[j] = outArr[j-1];
					outArr[j-1] = temp;
				}
			}
		}
		return outArr;
	}

	public static Integer[] quickSort(Integer[] inArr)
	{
		Integer[] outArr = inArr.clone();

		if(outArr == null || outArr.length == 0)
			return null;

		int length = outArr.length;
		quickSort(outArr, 0, length - 1);

		return outArr;
	}

	private static void quickSort(Integer[] array, int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;;
				i++;
				j--;
			}
		}
		if (lowerIndex < j)
			quickSort(array, lowerIndex, j);
		if (i < higherIndex)
			quickSort(array, i, higherIndex);
	}

	public static Integer[] mergeSort(Integer[] inArr)
	{
		Integer[] outArr = inArr.clone();
		Integer[] tempMergArr = new Integer[outArr.length];
		mergeSort(outArr, tempMergArr, 0, outArr.length-1);
		return outArr;
	}	

	private static void mergeSort(Integer[] array, Integer[] tempMergArr, int lowerIndex, int higherIndex) 
	{
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			mergeSort(array, tempMergArr, lowerIndex, middle);
			mergeSort(array, tempMergArr, middle + 1, higherIndex);
			mergeParts(array, tempMergArr, lowerIndex, middle, higherIndex);
		}
	}

	private static void mergeParts(Integer[] array, Integer[] tempMergArr, int lowerIndex, int middle, int higherIndex) 
	{
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}

	public static Integer[] heapSort(Integer[] inArr)
	{
		//http://www.sanfoundry.com/java-program-implement-heap-sort/
		Integer[] outArr = inArr.clone();
		int arrLenth = outArr.length-1;
		heapify(outArr);        
		for (int i = arrLenth; i > 0; i--)
		{
			swap(outArr, 0, i);
			arrLenth--;
			maxheap(outArr, 0);
		}
		return outArr;
	}

	public static void heapify(Integer[] arr)
	{
		int arrLenth = arr.length-1;
		arrLenth--;
		for (int i = arrLenth/2; i >= 0; i--)
			maxheap(arr, i);        
	}

	public static void maxheap(Integer[] arr, int i)
	{ 
		int arrLenth = arr.length-1;
		int left = 2*i ;
		int right = 2*i + 1;
		int max = i;
		if (left <= arrLenth && arr[left] > arr[i])
			max = left;
		if (right <= arrLenth && arr[right] > arr[max])        
			max = right;
		if (max != i)
		{
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}    

	public static void sort(Stack<Integer> s){
	    if(s.size() > 0){
	        int tmp = s.pop();
	        sort(s);
	        sortFromBottom(s, tmp);
	    }
	}

	private static void sortFromBottom(Stack<Integer> s, Integer value){
	    if(s.size() == 0){
	        s.add(value);
	    }else{
	        int tmpValue = s.peek();
	        if(tmpValue < value){
	            s.pop();
	            sortFromBottom(s, value);
	            s.push(tmpValue);
	        }else{
	            s.push(value);
	        }
	    }
	}
	
	private static void swap(Integer[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp; 
	}   

	public static void showOutput(Integer[] input, Integer[] output, String sortingMethod)
	{
		String msg = "Sorting using "+sortingMethod;
		msg += "\nInput array : "+Arrays.asList(input).toString();
		msg += "\nOutput array : "+Arrays.asList(output).toString();
		Output.showMassage(msg);
	}
}
