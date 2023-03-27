package com.tawandev.payment.application.ports.out;

import com.tawandev.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);
}
