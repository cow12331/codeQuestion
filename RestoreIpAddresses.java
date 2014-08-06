package intern;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

	public static void main(String[] args) {
		String[] test = {"010010","0279245587303" ,"25525511135","0000"};
		for (String t : test) {
			System.out.println(restoreIpAddresses(t));
			//System.out.println(Integer.parseInt("0000"));
		}

	}

	public static List<String> restoreIpAddresses(String s) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			String ss = s;
			if (ss.length() > i) {
				String first = ss.substring(0, i + 1);
				if (Integer.parseInt(first) > 255
						|| Integer.parseInt(first) < 0)
					continue;
				String sub1 = ss.substring(i + 1);
				String temp1 = first + ".";
				for (int j = 0; j < 3; j++) {
					if (sub1.length() > j) {
						String second = sub1.substring(0, j + 1);
						if (Integer.parseInt(second) > 255
								|| Integer.parseInt(first) < 0)
							continue;
						String sub2 = sub1.substring(j + 1);
						String temp2 = temp1 + second + ".";
						for (int k = 0; k < 3; k++) {
							if (sub2.length() > k) {
								String third = sub2.substring(0, k + 1);
								if (Integer.parseInt(third) > 255
										|| Integer.parseInt(third) < 0)
									continue;
								String sub3 = sub2.substring(k + 1);
								String temp3 = temp2 + third + ".";
								if (sub3.length() > 0 && sub3.length() < 4 && Integer.parseInt(sub3) >= 0
										&& Integer.parseInt(sub3) <= 255) {
									String temp4 = temp3 + sub3;
									list.add(temp4);
								} else
									continue;
							} else
								continue;
						}
					} else
						continue;
				}
			} else {
				break;
			}
		}
		
		ArrayList<String> output = new ArrayList<String>();
		for(String str : list) {
			String[] strArr = str.split("\\.");
			boolean check = true;
			for(String strAU : strArr) {
				if(strAU.length() > 1 && strAU.charAt(0) == '0') check = false;
				
			}
			if(check == true) output.add(str);
		}
		return output;
	}

}
