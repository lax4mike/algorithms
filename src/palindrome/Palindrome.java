package palindrome;

public class Palindrome {

	
	public static void main(String[] args) {
		
		Palindrome p = new Palindrome();
		
		String[] words = {"race car", "", "mom", " a a a b b b a aa", "aab", "        ab", "ab      ", "   a a  ba     a a "};
		
		for (String word : words){
		
			if (p.isPalindrome(word)){
				System.out.print(" is: ");
			}
			else {
				System.out.print(" is not: ");
			}
			System.out.println(word);
		}
	}
		
	public boolean isPalindrome(String x) {
		
		int left = 0;
		int right = x.length() - 1;
		char leftChar;
		char rightChar;
		
		while(left < right) {
			
			leftChar = x.charAt(left);
			rightChar = x.charAt(right);
			
			while(leftChar == ' ') {
				left++;
				leftChar = x.charAt(left);
			}
			while(rightChar == ' ') {
				right--;
				rightChar = x.charAt(right);
			}
			
			if (rightChar == leftChar){
				left++;
				right--;
			} 
			else {
				return false;
			}
			
		}
		
		return true;
		
	}
	
}
