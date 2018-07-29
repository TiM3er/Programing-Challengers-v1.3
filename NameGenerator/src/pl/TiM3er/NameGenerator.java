package pl.TiM3er;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static javax.script.ScriptEngine.FILENAME;

public class NameGenerator {
    List<String> firstName = new LinkedList<>();
    List<String> secondName = new LinkedList<>();
    private static final String FIRSTNAMEFILE = "fisrstname.txt";
    private static final String SECONDNAMEFILE= "secondname.txt";
    private  Random generator;
    private String getFirstNameById() {
        int id = 0;
        do{
            id = generator.nextInt()%getFirstNameSize();
        }while(id<0);

        return firstName.get(id);    }

    private String getSecondNameById() {
        int id = 0;
        do{
            id = generator.nextInt()%getSecondNameSize();
        }while(id<0);
        return secondName.get(id);
    }

    public NameGenerator() {
        generator = new Random();

        try (BufferedReader br = new BufferedReader(new FileReader(FIRSTNAMEFILE))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                firstName.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader br = new BufferedReader(new FileReader(SECONDNAMEFILE))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                secondName.add(sCurrentLine);;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int getFirstNameSize() {
        return this.firstName.size();
    }

    private int getSecondNameSize() {
        return this.secondName.size();
    }
    public String  generateName(){
        String firstName = getFirstNameById();
        String secondName = getSecondNameById();
        return firstName + " " + secondName;
    }

}
