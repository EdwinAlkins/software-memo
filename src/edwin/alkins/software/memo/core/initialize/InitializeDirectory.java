package edwin.alkins.software.memo.core.initialize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edwin.alkins.software.memo.core.config.StringBundle;

public class InitializeDirectory {
	private static InitializeDirectory instance = null;

	private InitializeDirectory() {}

	public static InitializeDirectory getInstance() {
		if (instance == null)
			instance = new InitializeDirectory();
		return instance;
	}
	
	public void initialize() {
		String currentDir = new String();
		if(isJar())
			currentDir = System.getProperty("user.dir");
		else
			currentDir = new StringBuffer().append(System.getProperty("user.home")).append(File.separator).append("/software memo/").toString();
		currentDir = new File(currentDir).getParent();
		List<File> listOfDir = new ArrayList<>();
		listOfDir.add(new File(new StringBuffer().append(currentDir).append(StringBundle.getString("path.data.dir")).toString()));
		listOfDir.add(new File(new StringBuffer().append(currentDir).append(StringBundle.getString("path.config.dir")).toString()));
		List<File> listOfFile = new ArrayList<>();
		listOfFile.add(new File(new StringBuffer().append(currentDir).append(StringBundle.getString("path.config.initialize")).toString()));
		
		listOfDir.stream().forEach(f -> {
			if(!f.exists()) {
				f.mkdirs();
			}
		});
		listOfFile.stream().forEach(f -> {
			if(!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean isJar() {
		boolean res = false;
		String[] listOfFile = new File(System.getProperty("user.dir")).list();
		for(String currentFile:listOfFile) {
			res = currentFile.matches(".*jar");
			if(res) break;
		}
		return res;
	}
}
