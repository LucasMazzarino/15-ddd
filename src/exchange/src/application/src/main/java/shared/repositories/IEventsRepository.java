package shared.repositories;

import com.dddimplement.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventsRepository {
    Flux<DomainEvent> getEvents();
}
