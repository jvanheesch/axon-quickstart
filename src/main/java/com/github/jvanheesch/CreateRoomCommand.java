package com.github.jvanheesch;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateRoomCommand {

    @TargetAggregateIdentifier
    private final String roomId;
    private final String name;

    public CreateRoomCommand(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }
}
