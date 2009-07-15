package manager;

import java.util.Vector;
import bean.Process;

/**
 *
 * @author Fabrício Reis
 */
public class PriorityNonPreeAlgorithm {
    
    public PriorityNonPreeAlgorithm() {
    }
    
    /* This method implements the algorithm Non-Preemptive Priority Scheduling (Por Prioridade Não-Preemptivo) of processes management.
     * It returns the position where the process with the highest priority is.
     */
    public int toExecute(Vector<Process> processes, int maximum) {
        int out = 0;
        int aux = 0;
        
        for(int i = 0; i <= (processes.size() - 1); i++) {
            if(aux < processes.elementAt(i).getPriority()) {
                aux = processes.elementAt(i).getPriority();
                out = i;
                if(aux == maximum) {
                    i = processes.size();
                }
            }
        }
        return out;
    }
    
    /*
     * This method finds and stores in a Vector<Integer> the positions of the possible processes being dispatched.
     * The last position of the returned vector stores the position of the process with the highest priority at the Vector 'processes'
     */
    public Vector<Integer> findPositionsPossibleProcesses(Vector<Process> processes, int maximum) {
        Vector<Integer> positions = new Vector<Integer>();
        int aux = 0;
        
        for(int i = 0; i <= (processes.size() - 1); i++) {
            if(aux < processes.elementAt(i).getPriority()) {
                aux = processes.elementAt(i).getPriority();
                positions.add(i);
                if(aux == maximum) {
                    i = processes.size();
                }
            }
        }
        return positions;
    }
}