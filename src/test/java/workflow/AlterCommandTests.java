package workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlterCommandTests {

    @Test
    public void alterUpdatesTicketField() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Test").performCommand();

        AlterCommand alter =
                new AlterCommand(board, 1, "priority", "High");

        alter.performCommand();

        Ticket  ticket = board.getTicketById(1);

        assertEquals("High", ticket.getPriority());
    }

}