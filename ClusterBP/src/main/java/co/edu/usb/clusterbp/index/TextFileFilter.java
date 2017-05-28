package co.edu.usb.clusterbp.index;

import java.io.File;
import java.io.FileFilter;
/**
 * Esta clase se utiliza como un filtro de archivos .txt.
 * **/
public class TextFileFilter implements FileFilter {

   public boolean accept(File pathname) {
      return pathname.getName().toLowerCase().endsWith(".txt");
   }
}