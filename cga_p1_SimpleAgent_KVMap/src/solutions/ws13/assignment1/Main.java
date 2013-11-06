package solutions.ws13.assignment1;


import org.amcgala.agent.AgentClient;
import org.amcgala.agent.AgentServer;

public class Main {
    public static void main(String[] args) throws Exception {
        new AgentServer("assignment1");
        Thread.sleep(20);
        new AgentClient("assignment1");
    }
}
