/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.mts.homework.services;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class Showcase {

    private final Logger logger = getLogger(this.getClass());

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    private String processInstanceId;

    @EventListener
    public void notify(final PostDeployEvent unused) {
        String string = UUID.randomUUID().toString();
        logger.info("generated BusinessKey {}", string);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Sample", string, Map.of("test", "test"));
        logger.info("started process with BusinessKey {} and with id {}", processInstance.getBusinessKey(), processInstance.getProcessInstanceId());
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }
}
