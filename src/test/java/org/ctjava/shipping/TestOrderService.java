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
package org.ctjava.shipping;

import javax.inject.Inject;
import org.ctjava.shipping.order.InventoryService;
import org.ctjava.shipping.order.Order;
import org.ctjava.shipping.order.OrderService;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Tests the order service
 * @author Ryan Cuprak
 */
@RunWith(Arquillian.class)
public class TestOrderService extends BaseTest {
    
    @Inject
    private OrderService orderService;
    
    @Inject
    private InventoryService inventoryService;
    
    @Before
    public void beforeTest() {
        inventoryService.clearInventory();
        inventoryService.addItemToInventory("1", new Item("Drone"));
        inventoryService.addItemToInventory("1", new Item("3D Printer"));
    }
    
    @Test
    public void testSuccessfulOrder() {
        // valid credit card number
        orderService.placeOrder("1", "5300003271773632");
        Assert.assertFalse("Order was not successful.",inventoryService.existsInInventory("1"));
    }
    
    @Test
    public void testFailedOrder() {
        // invalid credit card number
        orderService.placeOrder("1", "5300003271773634");
        Assert.assertTrue("Order should have failed",inventoryService.existsInInventory("1"));
    }
    
}
