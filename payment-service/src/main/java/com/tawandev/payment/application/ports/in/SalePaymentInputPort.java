package com.tawandev.payment.application.ports.in;

import com.tawandev.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);
}
