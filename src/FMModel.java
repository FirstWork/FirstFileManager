import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.List;

public class FMModel implements FMModelInterface {

    private ArrayList<WindowPanel> fmInterfaces = new ArrayList<WindowPanel>();
    private Path dir;
    private Path dirLeftPanel;
    private Path dirRightPanel;


    public FMModel () {
        dir = null;
        dirLeftPanel = null;
        dirRightPanel = null;
    }

    public void registerObserver (WindowPanel fmInterface) {
        fmInterfaces.add(fmInterface);
    }

    public void removeObserver (WindowPanel fmInterface) {
        fmInterfaces.remove(fmInterface);
    }

    public void notifyObservers (TypeWindow typeWindow) { //String path) {
        for (WindowPanel fmInterface: fmInterfaces) {
            if (fmInterface.getType().equals(typeWindow)) {
                fmInterface.updater(getPanel());
            }
        }
    }

    public void goToDirLeftPanel (String dir) {
        this.dirLeftPanel = Paths.get(dir);
        this.dir = dirLeftPanel;
        notifyObservers(TypeWindow.LEFT);
    }

    public void goToDirRightPanel (String dir) {
        this.dirRightPanel = Paths.get(dir);
        this.dir = dirRightPanel;
        notifyObservers(TypeWindow.RIGHT);
    }

    public ArrayList<JLabel> getPanel () {
        ArrayList<JLabel> list = new ArrayList<JLabel>();
        try (DirectoryStream<Path> dirstr = Files.newDirectoryStream(dir)){
            for (Path entry : dirstr) {
                //notifyObservers(entry.getFileName().toString());
                list.add (new JLabel(entry.getFileName().toString()));
                System.out.println(entry.getFileName());
            }
        } catch (NotDirectoryException e) {
            System.out.println("This if file!" + e);
        } catch (IOException e) {
            System.out.println("I/O error!" + e);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path!" + e);
        }
        return list;
    }

    public Path getDirLeftPanel () {
        return dirLeftPanel;
    }

    public Path getDirRightPanel () {
        return dirRightPanel;
    }
}
