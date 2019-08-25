package com.groups.crud;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.groups.crud.model.Event;
import com.groups.crud.model.Group;
import com.groups.crud.repository.GroupRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Hyderabad UserGroup", "Warangal UserGroup", "Bombay UserGroup",
                "Chennai UserGroup").forEach(name ->
                repository.save(new Group(name))
        );

        Group djug = repository.findByName("Hyderabad UserGroup");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        djug.setEvents(Collections.singleton(e));
        repository.save(djug);

        repository.findAll().forEach(System.out::println);
    }
}