package net.kanth.service;

import net.kanth.dto.PayloadCreation;

public interface ServiceCreation {

    PayloadCreation creationUser(PayloadCreation creation);

    String crationorder(PayloadCreation user);
}
