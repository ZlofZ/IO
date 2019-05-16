package IO.helper;

import java.io.*;

public class FileManager{
	
	/**
	 * Returns a list of files in the current location with the specified filetype and outputs their names to the terminal.
	 * @param fileType the IO extension passed as a String
	 * @return a list of files with the specified extension in the current location.
	 */
	public static File[] listFiles(String fileType){
		return listFiles(fileType, true);
	}
	/**
	 * Returns a list of files in the current location with the specified filetype.
	 * @param fileType the IO extension passed as a String.
	 * @param printFiles boolelan that when true activates console output.
	 * @return a list of files with the specified extension in the current location.
	 */
	public static File[] listFiles(String fileType, boolean printFiles){
		return listFiles(fileType, "", printFiles);
	}
	/**
	 * Returns a list of files in the specified sub location with the specified filetype and outputs their names to the terminal.
	 * @param fileType the IO extension passed as a String.
	 * @param path the sub path passed as a String.
	 * @return a list of files with the specified extension in the specified sub location.
	 */
	public static File[] listFiles(String fileType, String path){
		return listFiles(fileType, path, true);
	}
	/**
	 * Returns a list of files in the specified sub location with the specified filetype.
	 * @param fileType the IO extension passed as a String.
	 * @param path the sub path passed as a String.
	 * @param printFiles boolelan that when true activates console output.
	 * @return a list of files with the specified extension in the specified sub location.
	 */
	public static File[] listFiles(String fileType, String path, boolean printFiles){
		File dir = new File(path);
		File[] matchingFiles = dir.listFiles((d,s) -> s.toLowerCase().endsWith("."+fileType));
		//File[] matchingFiles = dir.listFiles(new FilenameFilter() {
		//	@Override
		//	public boolean accept(File dir, String name) {
		//		return name.toLowerCase().endsWith(fileType);
		//	}
		//});
		if(matchingFiles == null || matchingFiles.length == 0){
			System.out.println("No files found, Terminating");
			System.exit(1);
		} else if(printFiles && matchingFiles.length > 1) {
			System.out.println("Files found: [");
			for (int i = 0; i < matchingFiles.length; i++) {
				System.out.println(i + 1 + ". " + matchingFiles[i].getName());
			}
			System.out.println("]");
		}else if(printFiles) {
			System.out.println("One IO found: ["+matchingFiles[0].getName()+"]");
		}
		return matchingFiles;
	}
	
	//=================================================================================================
	/**
	 * Returns a list of directories in the current directory.
	 * @return a list of directories found in the current location.
	 */
	public static File[] listDirectories(){
		return listDirectories("");
	}
	/**
	 * Returns a list of directories in the specified sub-directory.
	 * @param path the sub path passed as a String.
	 * @return a list of directories found in the specified location.
	 */
	public static File[] listDirectories(String path){
		File dir = new File(path);
		return dir.listFiles((d,s) -> d.isDirectory());
	}
	
	//=================================================================================================
	/**
	 * Takes a array of Strings and saves them to a file.
	 * @param text a Strings which will be the content in the file.
	 * @param fileName the name of the file.
	 * @return true if successful save.
	 */
	public static boolean saveFile(String text, String fileName){
		return saveFile(new String[]{text} , new File(fileName));
	}
	/**
	 * Takes a array of Strings and saves them to a file.
	 * @param text a Strings which will be the content in the file.
	 * @param fileName the name of the file.
	 * @param path the sub-directory to save the file into.
	 * @return true if successful save.
	 */
	public static boolean saveFile(String text, String fileName, String path){
		return saveFile(new String[]{text} , fileName, path);
	}
	/**
	 * Takes a array of Strings and saves them to a file.
	 * @param text a Strings which will be the content in the file.
	 * @param file the file to be saved.
	 * @return true if successful save.
	 */
	public static boolean saveFile(String text, File file){
		return saveFile(new String[]{text} , file);
	}
	/**
	 * Takes a array of Strings and saves them to a file.
	 * @param lines an array of Strings which will be the content in the file.
	 * @param fileName the name of the file.
	 * @return true if successful save.
	 */
	public static boolean saveFile(String[] lines, String fileName){
		return saveFile(lines, new File(fileName));
	}
	/**
	 * Takes a array of Strings and saves them to a file.
	 * @param lines an array of Strings which will be the content in the file.
	 * @param fileName the name of the file.
	 * @param path the sub-directory to save the file into.
	 * @return true if successful save.
	 */
	public static boolean saveFile(String[] lines, String fileName, String path){
		if(!path.endsWith("/")||!path.endsWith("\\"))
			path+="/";
		return saveFile(lines, new File(path+fileName));
	}
	/**
	 * Takes a array of Strings and saves them to a file.
	 * @param lines an array of Strings which will be the content in the file.
	 * @param file the file to be saved.
	 * @return true if successful save.
	 */
	public static boolean saveFile(String[] lines, File file){
		try{
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			for(String line:lines){
				bw.write(line);
				bw.newLine();
			}
			bw.close();
		} catch(IOException e){
			System.out.println(e.getMessage());
			return false;
		}
		System.out.println("File saved.");
		return true;
	}
	
	//=================================================================================================
	
}
