package InterfaceLayer.Moves;

import InterfaceLayer.Moves.ActionReader;

public class DeterAction implements ActionReader {
    String [] Actions;
    int index;
    public DeterAction(char[] Actions) {
        Actions = Actions;
        index = -1;
    }
    @Override
    public String nextAction() {
        index++;
        return Actions[index];

    }
}
