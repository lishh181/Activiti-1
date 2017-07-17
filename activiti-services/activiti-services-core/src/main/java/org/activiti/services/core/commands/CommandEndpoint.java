package org.activiti.services.core.commands;

import org.activiti.services.audit.producer.app.AuditProducerChannels;
import org.activiti.services.core.ProcessEngineWrapper;
import org.activiti.services.model.commands.Command;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class CommandEndpoint {

    private ProcessEngineWrapper processEngine;

    @StreamListener(AuditProducerChannels.COMMAND_CONSUMER)
    public void consumeCommand(Command cmd) {
        System.out.println("Command Arrived: " + cmd);
        System.out.println("Command Class: " + cmd.getClass().getCanonicalName());
    }
}
