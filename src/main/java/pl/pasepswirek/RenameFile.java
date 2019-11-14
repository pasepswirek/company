package pl.pasepswirek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RenameFile {
    private Scanner scanner = new Scanner(System.in);

    public void renameFile() throws FileNotFoundException {
        String newName = scanner.next();
        File oldFile = new File("src\\main\\resources\\baza.dat");
        File newFile = new File("src\\main\\resources\\"+newName+".dat");
        if(oldFile.renameTo(newFile)){
            System.out.println("Rename succes");
        }
        else{
            System.out.println("Rename not succes");
        }

    }

}
