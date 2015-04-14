import javax.swing.*;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FMModelInterface {
    public void registerObserver(WindowPanel fmInterface);
    public void removeObserver(WindowPanel fmInterface);
    public void notifyObservers (TypeWindow typeWindow);
    public void goToDirLeftPanel (String dir);
    public void goToDirRightPanel (String dir);
    public Path getDirRightPanel ();
    public Path getDirLeftPanel ();
    public ArrayList<JLabel> getPanel ();
}
