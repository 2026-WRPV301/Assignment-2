package workflow;

import java.util.List;
import java.util.Scanner;

/**
 * Starter console menu for the Workflow Management System.
 *
 * This class handles all user interaction (Scanner input / System.out output).
 * Your job is to implement the classes it depends on:
 *   - WorkflowBoard, Ticket, Status
 *   - CreateCommand, MoveCommand, AlterCommand  (via AbstractWorkflowCommand / WorkflowCommand)
 *
 * Once those classes compile, this menu will work out of the box.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WorkflowBoard board = new WorkflowBoard();

        System.out.println("=== Workflow Management System ===");

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. Create Ticket");
            System.out.println("2. Move Ticket");
            System.out.println("3. Alter Ticket");
            System.out.println("4. View Board");
            System.out.println("5. View Audit Log");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    System.out.print("Enter ticket title: ");
                    String title = scanner.nextLine().trim();

                    // TODO: Create a CreateCommand with the board and title, then call performCommand()

                    printBoard(board);
                    break;

                case "2":
                    System.out.print("Enter ticket ID to move: ");
                    int moveId = Integer.parseInt(scanner.nextLine().trim());

                    System.out.println("Select new status:");
                    System.out.println("  1. To Do");
                    System.out.println("  2. In Progress");
                    System.out.println("  3. Done");
                    System.out.print("Choice: ");
                    String statusChoice = scanner.nextLine().trim();

                    Status newStatus;
                    switch (statusChoice) {
                        case "1": newStatus = Status.TO_DO;       break;
                        case "2": newStatus = Status.IN_PROGRESS; break;
                        case "3": newStatus = Status.DONE;        break;
                        default:
                            System.out.println("Invalid status.");
                            continue;
                    }

                    // TODO: Create a MoveCommand with the board, moveId, and newStatus, then call performCommand()

                    printBoard(board);
                    break;

                case "3":
                    System.out.print("Enter ticket ID to alter: ");
                    int alterId = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Enter field to change (title / description / priority): ");
                    String field = scanner.nextLine().trim();

                    System.out.print("Enter new value: ");
                    String value = scanner.nextLine().trim();

                    // TODO: Create an AlterCommand with the board, alterId, field, and value, then call performCommand()

                    printBoard(board);
                    break;

                case "4":
                    printBoard(board);
                    break;

                case "5":
                    printAuditLog(board);
                    break;

                case "6":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    // ---- Helper methods (no changes needed) ----

    private static void printBoard(WorkflowBoard board) {
        System.out.println();
        System.out.println("---- Board ----");

        System.out.println("To Do:");
        printTickets(board.getToDoTickets());

        System.out.println("In Progress:");
        printTickets(board.getInProgressTickets());

        System.out.println("Done:");
        printTickets(board.getDoneTickets());
    }

    private static void printTickets(List<Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            for (Ticket t : tickets) {
                System.out.println("  [T" + t.getId() + "] " + t.getTitle());
            }
        }
    }

    private static void printAuditLog(WorkflowBoard board) {
        System.out.println();
        System.out.println("---- Audit Log ----");
        List<String> log = board.getAuditLog();
        if (log.isEmpty()) {
            System.out.println("  (no entries)");
        } else {
            for (int i = 0; i < log.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + log.get(i));
            }
        }
    }
}
