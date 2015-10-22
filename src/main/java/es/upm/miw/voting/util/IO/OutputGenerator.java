package es.upm.miw.voting.util.IO;

public class OutputGenerator {

    public void printList(String heading, String collectionTitle, Object elements) {
        System.out.println(heading);
        System.out.print("    ");
        System.out.print(collectionTitle + " ");
        System.out.println(elements);
    }
}
