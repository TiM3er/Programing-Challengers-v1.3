package pl.TiM3er;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        for(int i =0 ;i<6;i++){
            System.out.println(nameGenerator.generateName());
        }
    }
}
