import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WindowPanel extends JPanel {

    private TypeWindow type;
    public WindowPanel (TypeWindow type) {
        super();
        this.type = type;
        this.setMaximumSize(new Dimension(150, 200));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }

    public void updater (ArrayList<JLabel> list) {
        removeAll();
        for (JLabel label: list) {
            add(label);
        }
        this.updateUI();
    }

    public Enum getType () {
        return type;
    }
}
