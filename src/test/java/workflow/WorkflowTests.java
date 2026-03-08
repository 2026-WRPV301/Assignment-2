package workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkflowTests {

    @Test
    public void createAddsTicketToBoard() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Login Feature").performCommand();

        assertEquals(1, board.getToDoTickets().size());
    }

    @Test
    public void moveMovesTicketToColumn() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Login Feature").performCommand();

        int ticketId = board.getToDoTickets().get(0).getId();

        new MoveCommand(board, ticketId, "In Progress").performCommand();

        assertEquals(0, board.getToDoTickets().size());
        assertEquals(1, board.getInProgressTickets().size());
    }

    @Test
    public void alterUpdatesTicketField() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Login Feature").performCommand();

        int ticketId = board.getToDoTickets().get(0).getId();

        new AlterCommand(board, ticketId, "priority", "High").performCommand();

        assertEquals("High", board.getToDoTickets().get(0).getPriority());
    }

    @Test
    public void commandsAreLogged() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Task").performCommand();

        assertTrue(board.getAuditLog().size() >= 1);
    }

}
