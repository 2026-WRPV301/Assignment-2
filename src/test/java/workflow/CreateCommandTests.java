package workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateCommandTests {

    @Test
    public void createAddsTicketToTodo() {

        WorkflowBoard board = new WorkflowBoard();

        CreateCommand cmd =
                new CreateCommand(board, "Ticket A");

        cmd.performCommand();

        assertEquals(1, board.getToDoTickets().size());
    }

}