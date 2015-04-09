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

        JButton goToRootLeft = new JButton("GoToRoot");
        goToRootLeft.setPreferredSize(new Dimension(80, 20));

        JButton goToParentLeft = new JButton("GoToParent");
        goToParentLeft.setPreferredSize(new Dimension(80, 20));

        JButton goToRootRight = new JButton("GoToRoot");
        goToRootRight.setPreferredSize(new Dimension(80, 20));

        JButton goToParentRight = new JButton("GoToParent");
        goToParentRight.setPreferredSize(new Dimension(80,20));

        JPanel windowLeft = new JPanel();
        windowLeft.setMaximumSize(new Dimension(150, 200));
        windowLeft.add(new Button("Левое окно файлового менеджера"), BorderLayout.EAST);


        JPanel windowRight = new JPanel();
        windowRight.setMinimumSize(new Dimension(150, 200));
        windowRight.add(new Button("Правое окно файлового менеджера") , BorderLayout.WEST);

        JTextField jLabelLeft = new JTextField("Введите сюда путь к папке для окна слева");
        JTextField jLabelRight = new JTextField("Введите сюда путь к папке для окна справа");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(600, 400));


        GridBagLayout gridBagLayout = new GridBagLayout();
        frame.setLayout(gridBagLayout);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill   = GridBagConstraints.NONE;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth  = 1;
        gridBagConstraints.gridx = GridBagConstraints.RELATIVE;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridBagConstraints.ipadx = 0;
        gridBagConstraints.ipady = 0;
        gridBagConstraints.weightx = 0.0;
        gridBagConstraints.weighty = 0.0;

        gridBagLayout.setConstraints(goToParentLeft, gridBagConstraints);

        gridBagLayout.setConstraints(goToRootLeft, gridBagConstraints);

        gridBagLayout.setConstraints(goToParentRight, gridBagConstraints);

        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;

        gridBagLayout.setConstraints(goToRootRight, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(jLabelLeft, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jLabelRight, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagLayout.setConstraints(windowLeft, gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(windowRight, gridBagConstraints);


        //frame.setLayout(new GridLayout(3, 2, 50, 30));

        frame.add(goToParentLeft);
        frame.add(goToRootLeft);
        frame.add(goToParentRight);
        frame.add(goToRootRight);
        frame.add(jLabelLeft);
        frame.add(jLabelRight);
        frame.add(windowLeft);
        frame.add(windowRight);
        frame.pack();
        frame.setVisible(true);

    }
}

