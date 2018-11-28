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

import org.ctjava.shipping.Item;

/**
 * Represents an order
 * @author Ryan Cuprak
 */
public class Order {
    
    private final Item item;
    
    private final String id;
    
    public Order(String id, Item item) {
        this.item = item;
        this.id = id;
    }
    
    public Item getItem() {
        return item;
    }
    
    public String getId() {
        return id;
    }
    
}
