import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/*
       Тестовый класс для просмотра результата работы нашего FileVisitor
 */


public class Test {
    public static void main (String args[]) {
        GetFileVisitor getFileVisitor = new GetFileVisitor("/Users/alex/exSwing");
        try {
            Files.walkFileTree(Paths.get("/Users/alex/exSwing"), getFileVisitor);   // тот самый механизм обхода дерева
        } catch (IOException e) {                                                   // каталогов.
            System.out.println("Ошибка(((");
        }
        for (Iterator i = getFileVisitor.pathToFile.iterator(); i.hasNext(); ) {   // не люблю коллекшины и до конца
            try {                                                                   // не понял как работает такой цикл
                System.out.println(i.next());                                   // но он работает и это главное =)
            } catch (NullPointerException e) {
                System.out.println("OMG!");
            }
        }
    }
}
