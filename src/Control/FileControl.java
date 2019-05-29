/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oVTuan
 */
public class FileControl {

    public String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public void saveFile(String text, String path) throws IOException {
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(text);
        }
       finally {
            bw.close();
        }
    }

    public boolean checkFileExisted(String path) {
        File fileOutput = new File(path);
        boolean fileExisted = fileOutput.exists();
        return fileExisted;
    }

}
