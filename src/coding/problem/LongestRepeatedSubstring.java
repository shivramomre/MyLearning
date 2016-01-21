package coding.problem;
import java.util.Arrays;
import java.util.Scanner;

public class LongestRepeatedSubstring {
    private static Scanner s;
	public static int[] constructLongestCommonPrefixArray(String [] suffixArray) {
        int [] lcpArray = new int[suffixArray.length];
        for (int i = 1; i < suffixArray.length; i++) {
            String prevString = suffixArray[i-1];
            String currentString = suffixArray[i];
            int minLen = prevString.length() < currentString.length() ?
                    prevString.length() : currentString.length();
            int maxPrefix = 0;
            for (int j = 0; j < minLen; j++) {
                if(prevString.charAt(j) == currentString.charAt(j)) {
                    maxPrefix++;
                } else {
                    break;
                }
            }
            lcpArray[i] = maxPrefix;
        }
        System.out.println(Arrays.toString(lcpArray));
        return lcpArray;
    }
    public static String[] constructSuffixArray(String str) {
        String [] suffixArray = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            suffixArray[i] = str.substring(i);
        }
        Arrays.sort(suffixArray);
        System.out.println(Arrays.toString(suffixArray));
        return suffixArray;
    }
    public static int findMaxIndex(int [] lcpArray) {
        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < lcpArray.length; i++) {
            if(lcpArray[i] > maxVal) {
                maxVal = lcpArray[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
        return maxIndex;
    }
    public static void main(String[] args) {
        s = new Scanner(System.in);
        String str = s.nextLine();
        String [] suffixArray = constructSuffixArray(str);
        int [] lcpArray = constructLongestCommonPrefixArray(suffixArray);
        int suffixIndex = findMaxIndex(lcpArray);
        String commonStr = suffixArray[suffixIndex].substring(0, lcpArray[suffixIndex]);
        if (commonStr.charAt(commonStr.length() - 1 ) == ' ') {
            System.out.println(commonStr);
        }
        commonStr = commonStr.trim();
        if(commonStr.contains(" ")) {
            System.out.println(commonStr);
        }
    }
}
