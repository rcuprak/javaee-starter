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

import org.ctjava.shipping.dao.AccountDao;
import org.ctjava.shipping.mocks.MockAccountDaoImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * Base Test Case
 * @author rcuprak
 */
public abstract class BaseTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addPackage("org.ctjava.shipping")
                .addPackages(true, "org.ctjava.shipping.account")
                .addPackages(true, "org.ctjava.shipping.card")
                .addPackages(true, "org.ctjava.shipping.order")
                // do not add the DAO package as we want to mock this out.
            .addClass(AccountDao.class)
            .addClass(MockAccountDaoImpl.class)
            .addAsResource("beans.xml", "META-INF/beans.xml");
        return war;
    }
}
