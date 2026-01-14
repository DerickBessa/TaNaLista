package io.github.TaNaLista.tanalista.Repository;

import io.github.TaNaLista.tanalista.Model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EventRepository  extends JpaRepository<Event, UUID> {



}
