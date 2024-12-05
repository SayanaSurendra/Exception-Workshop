package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

    public static void main(String[] args)  {

        List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();

        List<String> lastNames = null;
        try {
            lastNames = CSVReader_Writer.getLastNames();
        }catch (NoSuchFileException e) {
            System.out.println(e.getMessage());
            System.out.println("No File found");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

        Person test = nameService.getNewRandomPerson();
        System.out.println(test);

    }

}
