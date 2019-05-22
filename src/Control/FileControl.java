/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oVTuan
 */
public class FileControl {
    public String readFile(String path) {
        BufferedReader br = null;
        String text = "";
        try {
            File file = new File(path);
            br = new BufferedReader(new FileReader(file));
            String s = br.readLine();
            while (s != null) {
                if (s.isEmpty()) {
                    text += "\n";
                } else {
                    text += s;
                }
                s = br.readLine();
            }
            return text;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public void saveFile(String text, String path) {
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            bw = new BufferedWriter(new FileWriter(file, false));
            bw.write(text);
        } catch (IOException ex) {
            Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                 Logger.getLogger(FileControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean checkFileExisted(String path) {
        File fileOutput = new File(path);
        boolean fileExisted = fileOutput.exists();
        return fileExisted;
    }

}
