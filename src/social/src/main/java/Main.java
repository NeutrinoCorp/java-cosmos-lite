import org.neutrinocorp.shared.domain.DomainError;
import org.neutrinocorp.shared.domain.bus.event.DomainEvent;
import org.neutrinocorp.social.user.application.create.UserCreator;
import org.neutrinocorp.social.user.domain.*;
import org.neutrinocorp.social.user.infrastructure.persistence.InMemoryUserRepository;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        try {
            UserRepository repository = new InMemoryUserRepository();
            UserCreator creator = new UserCreator(repository);
            UserId id = new UserId(UUID.randomUUID().toString());
            creator.create(
                    id,
                    new Username("aruizmx"),
                    new DisplayName("Alonso Ruiz")
            );

            User user = repository.search(id);

            System.out.println(user.id().value());
            System.out.println(user.username().value());
            System.out.println(user.displayName().value());

            user.rename(new DisplayName("Luis Ruiz"));
            System.out.println(user.displayName().value());

            for (DomainEvent event : user.pullEvents()) {
                System.out.printf("event_name: %s, event_body: %s%n", event.eventName(), event.toPrimitives().toString());
            }
        } catch (DomainError e) {
            System.out.println(e.errorMessage());
        }
    }
}
