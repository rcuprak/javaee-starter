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

import javax.enterprise.event.Observes;
import org.ctjava.shipping.order.qualifiers.OrderConfirmed;
import org.ctjava.shipping.order.qualifiers.OrderFailed;

/**
 * Analyzes an order
 * @author rcuprak
 */
public class OrderAnalyzer {
    
    public void analyzeOrder(@Observes @OrderFailed @OrderConfirmed Order order) {
        System.out.println("Analyzing order!");
    } 
}
