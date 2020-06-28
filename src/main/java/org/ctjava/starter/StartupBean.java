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
package org.ctjava.starter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * Simple start-up bean. The post-construct method fires when the server is started.
 * @author Ryan Cuprak
 */
@Singleton
@Startup
public class StartupBean {

    /**
     * Logger
     */
    private static final Logger LOGGER = Logger.getLogger("StartupBean");

    /**
     * Executes on startup, no need for a "startup" servlet.
     */
    @PostConstruct
    public void init() {
        LOGGER.info("Application initializing...");
    }

}
