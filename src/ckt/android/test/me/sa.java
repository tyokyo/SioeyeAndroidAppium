package ckt.android.test.me;

import java.util.ArrayList;
import java.util.List;

public abstract class sa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String drawText = "this is my firest with 够够够狗狗啊啊1234567890qwertyuiopasdfghjklzxcvbnmthis is my firest with 够够够狗狗啊啊1234567890qwertyuiopasdfghjklzxcvbnm";
		List<String> rows = new ArrayList<String>();
		int rowCount =30;
		int length =drawText.length();
		if (length<=rowCount) {
			rows.add(drawText);
		}else {
			int startIndex = 0;
			while (startIndex<=length) {
				int endIndex =startIndex+rowCount;
				if (endIndex>length) {
					String substr = drawText.substring(startIndex, length);
					rows.add(substr);
					break;
				}else {
					String substr = drawText.substring(startIndex, endIndex);
					rows.add(substr);
					startIndex = endIndex;
				}
			}
		}
		for (String string : rows) {
			System.out.println(string);
		}
	}

}
