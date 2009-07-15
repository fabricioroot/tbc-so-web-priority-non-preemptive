package manager;

import java.util.Vector;
import bean.Process;

/**
 *
 * @author Fabricio Reis
 */
public class Calculator {
    
    public Calculator() {
    }    

    /* This method calculates the waiting time and the turn around of the process that is going to be executed according
     * the algorithm Non-Preemptive Priority Scheduling (Por Prioridade Não-Preemptivo).
     */
    public Process waitingTimeAndTurnAround (Vector<Process> processes, int time, int maximum) {
        Process out = new Process();
        int aux = 0;
        int position = 0;
        
        // It finds the process with the highest priority
        for(int i = 0; i <= (processes.size() - 1); i++) {
            if(aux < processes.elementAt(i).getPriority()) {
                aux = processes.elementAt(i).getPriority();
                position = i;
                if(aux == maximum) {
                    i = processes.size();
                }
            }
        }        
        out = processes.elementAt(position);
        // Waiting time = time (clock) - creation time
        out.setWaitingTime(time - out.getCreationTime());
        // Turn Around = waiting time + burst time
        out.setTurnAround(out.getWaitingTime() + out.getLifeTime());
        return out;
    }
    
    
    /* This method calculates the average of the waiting times.
     */
    public float averageWaitingTime (Vector<Process> processes) {
        float aux = 0;
        for (int i = 0; i <= (processes.size() - 1); i++) {
            aux += processes.elementAt(i).getWaitingTime();
        }
        aux = aux / processes.size();
        return aux;
    }
    
    /* This method calculates the average of the turns around.
     */
    public float averageTurnAround (Vector<Process> processes) {
        float aux = 0;
        for (int i = 0; i <= (processes.size() - 1); i++) {
            aux += processes.elementAt(i).getTurnAround();
        }
        aux = aux / processes.size();
        return aux;
    }
}