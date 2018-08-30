


import java.nio.file.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

public class StringReader {

	private String filenamePath = "C:\\Users\\RORO\\OneDrive - telecom-paristech.fr\\KTH\\Artificial_Intelligence_DD2380\\Code\\Test_Project\\Sokoban_PathFinding\\samples\\00_sample.in";
	
	
	public String readFileAsString()throws Exception
	  {
	    String data = "";
	    data = new String(Files.readAllBytes(Paths.get(filenamePath)));
	    return data;
	  }

	public List<String> readFileInList()
	  {
	 
	    List<String> lines = Collections.emptyList();
	    try
	    {
	      lines =
	       Files.readAllLines(Paths.get(filenamePath), StandardCharsets.UTF_8);
	    }
	 
	    catch (IOException e)
	    {
	 
	      // do something
	      e.printStackTrace();
	    }
	    return lines;
	  }
	
}
