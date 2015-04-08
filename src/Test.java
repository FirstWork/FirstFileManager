import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/*
       Тестовый класс для просмотра результата работы нашего FileVisitor
 */


public class Test {
    public static void main (String args[]) {
       /* GetFileVisitor getFileVisitor = new GetFileVisitor("/Users/alex/exSwing");
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
        }*/

        JFrame frame = new JFrame();

        JButton goToRoot = new JButton("GoToRoot");
        goToRoot.setMinimumSize(new Dimension(10, 20));

        JButton goToParent = new JButton("GoToParent");
        goToParent.setMaximumSize(new Dimension(10,20));

        JPanel windowLeft = new JPanel();
        windowLeft.setMaximumSize(new Dimension(150, 200));
        windowLeft.add(new Button("Левое окно файлового менеджера"), BorderLayout.EAST);


        JPanel windowRight = new JPanel();
        windowRight.setMinimumSize(new Dimension(150, 200));
        windowRight.add(new Button("Правое окно файлового менеджера") , BorderLayout.WEST);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setLayout(new GridLayout(3, 2, 50, 30));
        frame.add(goToRoot);
        frame.add(goToParent);
        frame.add(new JLabel("Введите сюда путь к папке для окна слева"));
        frame.add(new JLabel("Введите сюда путь к папке для окна справа"));
        frame.add(windowLeft, BorderLayout.WEST);
        frame.add(windowRight, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

    }
}

