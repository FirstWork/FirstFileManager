public class FMController implements Controller {
    private FMModelInterface model;
    private FMGui view;

    public FMController (FMModelInterface model) {
        this.model = model;
        view = new FMInterface (model, this);
        view.createView();
    }

    public void setDirLeftPanel (String path) {
        model.goToDirLeftPanel (path);
    }

    public void setDirRightPanel (String path) {
        model.goToDirRightPanel (path);
    }
}
