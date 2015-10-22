package es.upm.miw.voting.util.IO;

import java.util.List;

public class OutputGenerator {

    public void printList(String title, Object elements) {
        List<String> list = (List<String>) elements;
        System.out.print(title + " ");
        System.out.print("[");

        for (String element : list) {
            System.out.print(element);
            appendCommaIfNotLast(list, element);
        }

        System.out.println("]");
    }

    public void printListWithSubtitle(String title, String subtitle, Object elements) {
        List<String> list = (List<String>) elements;
        System.out.print(title + " ");
        System.out.print("[");

        for (String element : list) {
            System.out.print(subtitle + " " + element);
            appendCommaIfNotLast(list, element);
        }

        System.out.println("]");
    }

    private void appendCommaIfNotLast(List<String> list, String element) {
        if (list.indexOf(element) != list.size() - 1) {
            System.out.print(", ");
        }
    }
}
