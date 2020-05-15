//给定一个整数，将其转化为7进制，并以字符串形式输出。
//
//示例 1:
//
//输入: 100
//输出: "202"
//示例 2:
//
//输入: -7
//输出: "-10"
//注意: 输入范围是 [-1e7, 1e7] 。


class Solution {
	    public String convertToBase7(int num) {
		    String ans="";
		    if (num<0) {
			    num = 0 - num;
			    ans += "-";
		    };
		    StringBuilder sb = new StringBuilder();
		    do{
			    int mod = num % 7;
			    sb.append((char)('0'+mod));
			    num = num / 7;
		    } while (num>0);
		    ans += sb.reverse().toString();
		    return ans;
	    }
}
