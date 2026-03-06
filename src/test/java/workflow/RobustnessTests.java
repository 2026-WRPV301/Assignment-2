package workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobustnessTests {

    @Test
    public void ticketIdsAreUnique() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "A").performCommand();
        new CreateCommand(board, "B").performCommand();

        Ticket  t1 = board.getTicketById(1);
        Ticket  t2 = board.getTicketById(2);

        assertNotEquals(t1, t2);
    }

    @Test
    public void movingTicketDoesNotDuplicateIt() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Test").performCommand();

        new MoveCommand(board, 1, "In Progress").performCommand();

        assertEquals(1,
                board.getInProgressTickets().size()
        );
    }

}