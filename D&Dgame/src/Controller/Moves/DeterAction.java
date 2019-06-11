package Controller.Moves;

public class DeterAction implements ActionReader {
    String [] Actions;
    int index;
    public DeterAction(String[] Actions) {
        this.Actions = Actions;
        index = -1;
    }
    @Override
    public boolean hasNext(){
        return index < Actions.length -1;
    }
    public String nextAction() {
        index++;
        return Actions[index];

    }
}
