import java.io.File;
import javax.swing.*;
public class ListLargestFiles {

	public static void main(String[] args) {
        JFileChooser fd = new JFileChooser();
//        mode - the type of files to be displayed:
//            * JFileChooser.FILES_ONLY
//            * JFileChooser.DIRECTORIES_ONLY
//            * JFileChooser.FILES_AND_DIRECTORIES 
        fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fd.showOpenDialog(null);
		File f = fd.getSelectedFile();
		File biggest = listLargestFiles1(f);
		System.out.println("the largest file in the folder selected is " + biggest.getName());
	}
	public static File listLargestFiles1(File f) {
		File files[] = f.listFiles();
		File temp = files[0];
		
		for (int i = 1; i<files.length; i++) {
			File f2 = files[i];
            if (f2.isDirectory()) {
               f2 = listLargestFiles1(files[i]);
            }           
			if(f2.length() > temp.length())
			   temp = f2;
		}
		return temp;
	}
}
