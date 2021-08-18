package com.github.jvanheesch;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class ChatRoom {

    @AggregateIdentifier
    private String roomId;
    private String name;

    public ChatRoom() {
    }

    @CommandHandler
    public ChatRoom(CreateRoomCommand cmd) {
        apply(new RoomCreatedEvent(cmd.getRoomId(), cmd.getName()));
    }

    @EventSourcingHandler
    public void on(RoomCreatedEvent event) {
        roomId = event.getRoomId();
        name = event.getName();
    }

    public String getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }
}
