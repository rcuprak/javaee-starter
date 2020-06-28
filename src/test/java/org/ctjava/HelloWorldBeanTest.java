/**
 * Copyright 2020 Connecticut Java User Group
 *
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
package org.ctjava;

import javax.inject.Inject;
import org.ctjava.starter.HelloWorldBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.junit.runner.RunWith;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;

/**
 * Simple integration test. This test starts-up a Payara container, deploys the application, and runs a test (within the container)
 * @author Ryan Cuprak
 */
@RunWith(Arquillian.class)
public class HelloWorldBeanTest {

    /**
     * Injects the starter bean
     */
    @Inject
    private HelloWorldBean starterBean;

    /**
     * Creates the test archive
     * @return web archive for testing
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
            .addPackage("org.ctjava.starter")
            .addAsWebInfResource("beans.xml");
    }

    /**
     * Simple test, this runs in the container
     */
    @Test
    public void testStarterBean() {
        Assert.assertEquals("Hello from a bean!",starterBean.getMessage());
    }
    
}
