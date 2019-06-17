package Controller.Moves;

//represents a list of generated actions
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
    //returns the next action
    public String nextAction() {
        index++;
        return Actions[index];

    }
}
