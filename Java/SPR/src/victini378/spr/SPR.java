package victini378.spr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SPR {
	
	private static short n;
	private static BufferedReader in;
	private static FileWriter out;
	private static short[] v;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(new File("input.txt").getAbsolutePath()));
		n = (short) Integer.parseInt(in.readLine());
		v = new short[n];

		for(short i=0; i<n; i++) v[i] = (short) Integer.parseInt(in.readLine());
		in.close();

		File f = new File("output.txt");
		f.createNewFile();
		out = new FileWriter(f);
		//System.out.print(iteration());
		out.write(Integer.toString(iteration()));
		out.flush();
		out.close();
	}
	
	static short iteration(){
		for(short found=99; found>0; found--)
			if(!sumExists(found)) return found;
		return 0;
	}

	private static boolean sumExists(short sum) {
		if(sum == 0) return true;

		for(short i=0; i<n; i++)
			if(v[i] <= sum && sumExists((short) (sum - v[i]))) return true;
		
		return false;
	}

}
