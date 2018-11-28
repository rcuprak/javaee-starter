/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ctjava.shipping.order;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import org.ctjava.shipping.CreditCardVerifier;
import org.ctjava.shipping.Verifier;
import org.ctjava.shipping.order.qualifiers.OrderConfirmed;
import org.ctjava.shipping.order.qualifiers.OrderFailed;

/**
 * Basic implementation of an order service
 * @author Ryan Cuprak
 */
public class OrderService {
    
    @Inject @OrderConfirmed
    private Event<Order> orderEventConfirmed;

    @Inject @OrderFailed
    private Event<Order> orderEventFailed;

    @Inject @Verifier
    private CreditCardVerifier cardVerifier;
    
    @Inject
    private InventoryService inventoryService;

    /**
     * Places an order for an item
     * @param itemId - item id
     * @param cardNumber - card number 
     */
    public void placeOrder(String itemId, String cardNumber) {
        Order order = inventoryService.createOrderForItem(itemId);
        if(!cardVerifier.isCreditCardNumberValid(cardNumber)) {
            orderEventFailed.fire(order);
        }
        orderEventConfirmed.fire(order);
    }
}