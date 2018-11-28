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

import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import org.ctjava.shipping.Item;

/**
 * Represents a system tracking inventory
 * @author Ryan Cuprak
 */
@Singleton
public class InventoryService {
    
    private final Map<String,Item> inventory = new HashMap<>();
    
    public void addItemToInventory(String id, Item item) {
       inventory.put(id,item); 
    }
    
    public Order createOrderForItem(String itemId) {
        Item item = inventory.remove(itemId);
        return new Order(itemId,item);
    }   
    
    public void releaseBackToInventory(Order order) {
        inventory.put(order.getId(),order.getItem());
    }
    
    public boolean existsInInventory(String itemId) {
        return inventory.containsKey(itemId);
    }
    
    public void clearInventory() {
        inventory.clear();
    }
}
