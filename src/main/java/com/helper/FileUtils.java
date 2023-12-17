package com.helper;
import java.io.File;

public class FileUtils {
    public static boolean deleteFiles(File toDelete){
        File[] allContents = toDelete.listFiles();
        if(allContents!=null){
            for(File file: allContents)
                deleteFiles(file);
        }
        return toDelete.delete();
    }
}
