package cn.qipeicheng.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckStr {

	public static boolean isChineses(String str) {
		if (str == null)
			return false;
		for (char c : str.toCharArray()) {
			if (c >= 0x4E00 && c <= 0x9FA5)
				return true;// 有一个中文字符就返回
		}
		return false;
	}
	
	public static boolean isNumber(String str){
		 Pattern pattern = Pattern.compile("[0-9]*");
         Matcher isNum = pattern.matcher(str);
         if( !isNum.matches() ){
             return false;
         }
         return true;
	}
}
