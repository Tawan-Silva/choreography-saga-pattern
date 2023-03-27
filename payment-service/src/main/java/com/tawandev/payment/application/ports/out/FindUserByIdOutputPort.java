package com.tawandev.payment.application.ports.out;

import com.tawandev.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);
}
