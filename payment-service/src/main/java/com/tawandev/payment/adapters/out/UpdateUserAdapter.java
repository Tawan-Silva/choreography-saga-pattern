package com.tawandev.payment.adapters.out;

import com.tawandev.payment.adapters.out.repository.UserRepository;
import com.tawandev.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.tawandev.payment.application.core.domain.User;
import com.tawandev.payment.application.ports.out.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserAdapter implements UpdateUserOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
