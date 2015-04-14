import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FMInterface extends JFrame implements FMGui, ActionListener {
    private FMModelInterface fmModel;
    private Controller controller;
    private JButton leftgoToRoot;
    private JButton leftgoToParent;
    private JButton leftgoToDir;
    private JButton rightgoToRoot;
    private JButton rightgoToParent;
    private JButton rightgoToDir;
    private JTextField leftPath;
    private JTextField rightPath;
    private WindowPanel leftWindow;
    private WindowPanel rightWindow;
    private JMenu jMenu;
    private JMenuBar jMenuBar;
    private JMenuItem jMenuItem;
    private JPanel leftTopPanel;
    private JPanel rightTopPanel;
    private JPanel leftMidPanel;
    private JPanel rightMidPanel;

    public FMInterface (FMModelInterface fmModel, Controller controller) {
        this.fmModel = fmModel;
        this.controller = controller;
        leftWindow = new WindowPanel (TypeWindow.LEFT);
        rightWindow = new WindowPanel (TypeWindow.RIGHT);
        fmModel.registerObserver(leftWindow);
        fmModel.registerObserver(rightWindow);
    }

    public void createView () {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));

        jMenuBar = new JMenuBar();
        jMenu = new JMenu("File");
        jMenuItem = new JMenuItem("OLOLO");
        jMenu.add(jMenuItem);
        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        Dimension xorg = new Dimension(70, 30);
        leftgoToRoot = new JButton("/");
        leftgoToRoot.setPreferredSize(xorg);
        leftgoToParent = new JButton("..");
        leftgoToParent.setPreferredSize(xorg);
        leftTopPanel = new JPanel();
        leftTopPanel.setPreferredSize(new Dimension(200, 40));
        leftTopPanel.setLayout(new FlowLayout());
        leftTopPanel.add (leftgoToRoot);
        leftTopPanel.add (leftgoToParent);

        rightgoToRoot = new JButton("/");
        rightgoToRoot.setPreferredSize(xorg);
        rightgoToParent = new JButton("..");
        rightgoToParent.setPreferredSize(xorg);
        rightTopPanel = new JPanel();
        rightTopPanel.setPreferredSize(new Dimension(200, 40));
        rightTopPanel.add (rightgoToRoot);
        rightTopPanel.add (rightgoToParent);

        leftPath = new JTextField("Введи сюда путь!");
        leftgoToDir = new JButton("Go!");
        leftMidPanel = new JPanel();
        leftMidPanel.setPreferredSize(new Dimension(300, 40));
        leftMidPanel.add (leftPath);
        leftMidPanel.add (leftgoToDir);

        rightPath = new JTextField("Введи сюда путь!");
        rightgoToDir = new JButton("Go!");
        rightMidPanel = new JPanel();
        rightMidPanel.setPreferredSize(new Dimension(300, 40));
        rightMidPanel.add (rightPath);
        rightMidPanel.add (rightgoToDir);

        leftgoToRoot.addActionListener(this);
        leftgoToParent.addActionListener(this);
        rightgoToParent.addActionListener(this);
        rightgoToRoot.addActionListener(this);
        leftgoToDir.addActionListener(this);
        rightgoToDir.addActionListener(this);

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
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
        
    //    pane.add (leftWindow);

        gridBagLayout.setConstraints(leftTopPanel , gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(rightTopPanel , gridBagConstraints);
        gridBagConstraints.gridwidth  = 1;
        gridBagLayout.setConstraints(leftMidPanel , gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(rightMidPanel , gridBagConstraints);
        gridBagConstraints.gridwidth  = 1;
        gridBagLayout.setConstraints(leftWindow , gridBagConstraints);
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(rightWindow , gridBagConstraints);
        gridBagConstraints.gridwidth  = 1;


        add(leftTopPanel);
        add (rightTopPanel);
        add (leftMidPanel);
        add (rightMidPanel);
        add (leftWindow);
        add(rightWindow);

        pack();
        setVisible(true);
    }

    public void actionPerformed (ActionEvent event) {
        if (event.getSource() == leftgoToRoot) {
            controller.setDirLeftPanel("/");
        } else if (event.getSource() == leftgoToParent) {
            if (!fmModel.getDirLeftPanel().equals(fmModel.getDirLeftPanel().getRoot())) {
                controller.setDirLeftPanel(fmModel.getDirLeftPanel().getParent().toString());
            }
        } else if (event.getSource() == rightgoToRoot) {
            controller.setDirRightPanel("/");
        } else if (event.getSource() == rightgoToParent) {
            if (!fmModel.getDirRightPanel().equals(fmModel.getDirRightPanel().getRoot())) {
                controller.setDirRightPanel(fmModel.getDirRightPanel().getParent().toString());
            }
        } else if (event.getSource() == leftgoToDir) {
            if (leftPath != null && Files.exists(Paths.get(leftPath.getText()))) {
                controller.setDirLeftPanel(leftPath.getText());
            }
        } else if (event.getSource() == rightgoToDir) {
            if (rightPath != null && Files.exists(Paths.get(rightPath.getText()))) {
                controller.setDirRightPanel(rightPath.getText());
            }
        }
    }
    public static void main (String args[]) {
        Controller controller = new FMController(new FMModel());

    }
}
