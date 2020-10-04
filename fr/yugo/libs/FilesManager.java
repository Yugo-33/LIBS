package fr.yugo.libs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FilesManager {

	private String path;
	private File file;
	
	public FilesManager(String path) {
		this.file = new File(path);
		this.path = file.getAbsolutePath();
		
	}
	
	public static FilesManager init(String path) {
		return new FilesManager(path);
	}
	
	/**
	 * 
	 * @return Absolute path of file/folder
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * 
	 * @return File object
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * Append String at the end of the file
	 * @param content : String content to append
	 * @throws IOException
	 */
	public void appendFile(String content) throws IOException {
		appendFile(content.getBytes());
	}
	
	/**
	 * Append byte at the end of the file
	 * @param content : Bytes content to append
	 * @throws IOException
	 */
	public void appendFile(byte[] content) throws IOException {
		appendFile(false, content);
	}
	
	/**
	 * Append bytes to the file
	 * @param before : choose to append before or after the current content
	 * @param content : Bytes content to append
	 * @throws IOException
	 */
	public void appendFile(boolean before, byte[] content) throws IOException {
		if (before) {
			Files.write(file.toPath(), content, StandardOpenOption.WRITE);
		} else {
			Files.write(file.toPath(), content, StandardOpenOption.APPEND);
		}
	}

	/**
	 * Append String to the file
	 * @param before : choose to append before or after the current content
	 * @param content : String content to append
	 * @throws IOException
	 */
	public void appendFile(boolean before, String content) throws IOException {
		appendFile(before, content.getBytes());
	}
	
	/**
	 * Delete content and write the new content
	 * @param content : String content to write
	 * @throws IOException
	 */
	public void writeFile(String content) throws IOException {
		writeFile(content.getBytes());
	}
	
	/**
	 * Delete content and write the new content
	 * @param content : Bytes content to write
	 * @throws IOException
	 */
	public void writeFile(byte[] content) throws IOException {
		Files.write(file.toPath(), content);
	}
	
	/**
	 * 
	 * @return String file content
	 * @throws IOException
	 */
	public String readFileString() throws IOException {
		return new String(readFileBytes());
	}
	
	/**
	 * 
	 * @return Bytes file content
	 * @throws IOException
	 */
	public byte[] readFileBytes() throws IOException {
		return Files.readAllBytes(file.toPath());
	}
	
	/**
	 * 
	 * @param dest : File destination | replace if exists
	 * @return new FilesManager(dest);
	 * @throws IOException
	 */
	public FilesManager copyFile(File dest) throws IOException {
		FilesManager f = new FilesManager(dest.getAbsolutePath());
		if (!f.exists()) {
			f.createFile();
		}
		f.writeFile(this.readFileBytes());
		return f;
	}
	
	/**
	 * 
	 * @param dest : File destination | replace if exists
	 * @return new FilesManager(dest);
	 * @throws IOException
	 */
	public FilesManager moveFile(File dest) throws IOException {
		FilesManager f = copyFile(dest);
		this.delete();
		return f;
	}
	
	/**
	 * 
	 * @param name : name of the file, need to includes type of file ex: .jar or .txt
	 * @throws IOException 
	 */
	public void renameFile(String name) throws IOException {
		File f = new File(file.getParentFile(), name);
		moveFile(f);
		
		this.file = f;
		this.path = f.getAbsolutePath();
	}
	
	/**
	 * 
	 * @return true if success else it return false
	 * @throws IOException
	 */
	public boolean createFile() throws IOException {
		return file.createNewFile();
	}
	
	/**
	 * 
	 * @return true if success else it return false
	 */
	public boolean createFolder() {
		return file.mkdir();
	}
	
	/**
	 * 
	 * @return true if success else it return false
	 */
	public boolean delete() {
		return file.delete();
	}
	
	/**
	 * 
	 * @return true if file/folder exists else it return false
	 */
	public boolean exists() {
		return file.exists();
	}
	
	/**
	 * 
	 * @return true if folder else it return false
	 */
	public boolean isFolder() {
		return file.isDirectory();
	}
	
	/**
	 * 
	 * @return true if file else it return false
	 */
	public boolean isFile() {
		return file.isFile();
	}
	
	
}
