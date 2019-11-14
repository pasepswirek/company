package pl.pasepswirek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//wyświetlenie informacji o funkcjach(wymaganiach) programu
public class AboutProgram {

    public void aboutProgram()  {
        try {
            Scanner file = new Scanner(new File("src\\main\\resources\\about_program.txt"));
            while (file.hasNext()) {
                String read = file.nextLine();
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
