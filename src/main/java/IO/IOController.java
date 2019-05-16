package IO;

import IO.helper.ConsoleInput;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IOController{
	private ConsoleInput consoleInput;
	
	/**
	 * Returns a list of Strings where each list-entry represents a line from a file.
	 * @param file the file from which to read text.
	 * @return a list of Strings
	 */
	public ArrayList<String> loadTxt(File file){
		ArrayList<String> bc = new ArrayList<>();
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null){
				bc.add(line);
				line  = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e){
			System.out.println("Could not read text from IO: " + file.getAbsolutePath());
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		return bc;
	}
	
	/**
	 * Returns a file selected among a list of files passed in.
	 * @param files a list of files available to choose from.
	 * @return the selected file.
	 */
	public File selectFile(File[] files){
		if(files.length == 1)return files[0];
		int answer = -1;
		while(answer < 1 || answer > files.length){
			answer = consoleInput.readInt("Enter a number between "+1+" and "+files.length+" to make a choice.>");
		}
		System.out.println("File ["+files[answer-1].getName()+"] chosen.");
		return files[answer-1];
	}
	
	/**
	 * Returns a directory selected among a list of directories passed in.
	 * @param directories a list of directories available to choose from.
	 * @return the selected directory.
	 */
	public File selectDirectory(File[] directories){
		return selectFile(directories);
	}
	
	/**
	 * Checks if a list of directories passed in is present and creates them if they are missing.
	 * @param directories a list of directories that are required.
	 * @return the list of required directories.
	 */
	public File[] createRequiredDirectories(File[] directories){
		for(File dir : directories){
			if(!dir.exists()){
				System.out.println("Directory "+dir.getName()+" not present, creating.");
				dir.mkdir();
			} else{
				System.out.println("Directory " + dir.getName() + " present, skipping.");
			}
		}
		return directories;
	}
	public File loadResource(){
		return new File(Thread.currentThread().getContextClassLoader().getResource("client.secret").getFile());
	}
	
	/**
	 * The IOController constructor.
	 */
	public IOController(){
		consoleInput=new ConsoleInput();
	}
}
