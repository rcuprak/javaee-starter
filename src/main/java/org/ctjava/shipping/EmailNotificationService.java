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

import org.ctjava.shipping.order.Order;

/**
 * Email notification service
 * @author Ryan Cuprak
 */
public class EmailNotificationService {
    
    public void sendEmailOrderSuccessful(Order order) {
       System.out.println("Sending confirmation email");
    }
}
