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
package org.ctjava.shipping.account;

import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import org.ctjava.shipping.Audited;

/**
 *
 * @author Ryan Cuprak
 */
@ApplicationScoped
@Audited
public class FraudService {

    private final Set<String> blockedUsers = new HashSet<>();

    public void registerBlockedUser(String username) {
        blockedUsers.add(username);
    }

    public boolean isUserBlocked(String username) {
        return blockedUsers.contains(username);
    }
}
