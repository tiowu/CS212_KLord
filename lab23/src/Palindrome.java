
public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("noon"));
		System.out.println(isPalindrome("Madam I'm Adam"));
		System.out.println(isPalindrome("A man, a plan, a canal, Panama"));
		System.out.println(isPalindrome("A Toyota"));
		System.out.println(isPalindrome("Not a palindrome"));
		System.out.println(isPalindrome("asdfghfdsa"));
	}
	
	public static boolean isPalindrome(String in) {
		if(in==null) {
			return false;
		}
		return isPalindromeHelper(in.toUpperCase());
	}
	
	private static boolean isPalindromeHelper(String in) {
	   int len = in.length();
	   if(len <= 1)
	      return true;
	   else {
	      char first = in.charAt(0), last = in.charAt(len - 1);
	      if(!Character.isAlphabetic(first))
	         return isPalindromeHelper(in.substring(1));
	      if(!Character.isAlphabetic(last))
	         return isPalindromeHelper(in.substring(0, len - 1));
	      if(first == last)
	         return isPalindromeHelper(in.substring(1, len - 1));
	   }
	   return false;
	}
}
