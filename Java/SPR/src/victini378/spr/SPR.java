package victini378.spr;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SPR {
	
	static short n;
	private static File f;
	private static FileReader in;
	private static FileWriter out;
	private static short[] v;

	public static void main(String[] args) throws IOException {
		in = new FileReader(new File("input.txt").getAbsolutePath());
		n = (short) in.read();
		v = new short[n];

		//for(short i : v) i = (short) in.read();
		v[0]=4;
		v[1]=5;
		v[2]=7;
		
		iteration();
		
		f = new File("output.txt");
		f.createNewFile();
		out = new FileWriter("output.txt");
		out.write(iteration());
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
