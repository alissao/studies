package leetcode.arrayAndString;

public class stringString {
	public int strStr(String haystack, String needle) {
		int retorno = -1;
		if (needle.isEmpty()) {
			retorno = 0;
			return retorno;
		}else if (haystack == null) {
			return retorno;
		}else {
			char[] ch_haystack = new char[haystack.length()];
			char[] ch_needle = new char[needle.length()];
			
			ch_haystack = haystack.toCharArray();
			ch_needle = needle.toCharArray();
			int j = 0;
			boolean possuiString= false;
			
			for (int i = 0; i < haystack.length(); i++){ 
				if (ch_haystack[i] == ch_needle[j] && haystack.length()-i >= needle.length()) {
					possuiString = true;
					for (j = 0;j < needle.length(); j++) {
						if (ch_haystack[i+j] != ch_needle[j]) {
							j = 0;
							possuiString = false;
							break;
						}
					}
					if (possuiString == true) {
						retorno = i;
						break;
					}
				}
			}
		}
		return retorno;
	}
}
