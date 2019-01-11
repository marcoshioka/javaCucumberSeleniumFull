package Commons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
	
	public void sort () throws IOException{
		ArrayList<String> rows = new ArrayList<String>();
	    BufferedReader reader = new BufferedReader(new FileReader("./files/listaCeps.txt"));

	    String s;
	    while((s = reader.readLine())!=null)
	        rows.add(s);

	    Collections.shuffle(rows);

	    FileWriter writer = new FileWriter("./files/cepsSorteados.txt");
	    for(String cur: rows)
	        writer.write(cur+"\n");

	    reader.close();
	    writer.close();
		}

}
