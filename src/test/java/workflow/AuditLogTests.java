package workflow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuditLogTests {

    @Test
    public void createCommandIsLogged() {

        WorkflowBoard board = new WorkflowBoard();

        new CreateCommand(board, "Test").performCommand();

        assertTrue(board.getAuditLog().size() >= 1);
    }

}