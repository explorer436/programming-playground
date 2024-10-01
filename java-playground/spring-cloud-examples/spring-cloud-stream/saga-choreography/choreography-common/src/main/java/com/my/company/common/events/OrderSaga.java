package com.my.company.common.events;

import java.util.UUID;

/*
    There can be many different types of workflows (Sagas) in these applications.
    This class is to support the workflows for "Orders".
    If there are other types of workflows in addition to "Orders", create interfaces for them as well.
 */
public interface OrderSaga extends Saga {

    /*
        Intentionally using UUID to keep things simple. Prefer record OrderId(UUID id){}
    */
    UUID orderId();

}
