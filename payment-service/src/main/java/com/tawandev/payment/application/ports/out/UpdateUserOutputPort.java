package com.tawandev.payment.application.ports.out;

import com.tawandev.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);
}
