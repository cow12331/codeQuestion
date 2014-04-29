import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Triangle {
	public static void main(String[] args) throws Exception {

		long[][] test = readData("triangle.txt");

		//get Max path from bottom
		for(int i = test.length - 2; i >= 0; i--) 
			for(int j = 0; j < i+1; j++) {
				test[i][j] += Math.max(test[i+1][j], test[i+1][j+1]);
			}
		System.out.print(test[0][0]);
	}

	//read file and save into a 100*100 array
	static long[][] readData(String path) throws Exception {
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String line = "";

		//save in a linear array first
		ArrayList<Long> triLine = new ArrayList<Long>();
		long[][] triMetic = new long[100][100];
		
		//read line by line and toLong
		while ((line = br.readLine()) != null) {
			String s = line;
			String[] sa = s.split(" ");
			for (String i : sa) {
				triLine.add(Long.parseLong(i));
			}
		}
		//from linear array to 100*100 array
		int index = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < i + 1; j++) {
				triMetic[i][j] = triLine.get(index);
				index++;
			}
		}
		return triMetic;
	}
	
}
