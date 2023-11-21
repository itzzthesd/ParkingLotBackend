import controllers.TicketController;
import repositories.TicketRepository;
import services.TicketService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ObjectContainer objectContainer = new ObjectContainer();

        TicketService ticketService = new TicketService();
        objectContainer.register("ticketService", ticketService);

        TicketController ticketController =
                new TicketController((TicketService) objectContainer.get("ticketService"));
    }
}