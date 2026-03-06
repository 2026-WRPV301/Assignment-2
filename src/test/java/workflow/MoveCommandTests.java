package workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveCommandTests {

    @Test
    public void moveTicketToInProgress() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Test").performCommand();

        MoveCommand move =
                new MoveCommand(board, 1, Status.IN_PROGRESS);

        move.performCommand();

        assertEquals(0, board.getToDoTickets().size());
        assertEquals(1, board.getInProgressTickets().size());
    }

}