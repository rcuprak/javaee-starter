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

import javax.annotation.PostConstruct;
import org.ctjava.shipping.account.AccountPage;
import org.ctjava.shipping.dao.AccountDao;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Ryan Cuprak
 */
@Startup
@Singleton
public class StartupBean {
    
    @Inject
    private AccountDao accountDao;
    
    @Inject
    private AccountPage accountPage;
    
    @PostConstruct
    private void init() {
        accountPage.setAccounts(accountDao.getAccounts());
    } 
}
