package com.tawandev.payment.application.ports.in;

import com.tawandev.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);
}
