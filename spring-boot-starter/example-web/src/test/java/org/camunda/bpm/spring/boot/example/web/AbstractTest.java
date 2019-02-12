/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.spring.boot.example.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Thorben Lindhauer
 *
 */
public abstract class AbstractTest {

  @Autowired
  private ProcessEngine processEngine;

  @Autowired
  private RuntimeService runtimeService;


  @Test
  @Ignore
  public void test() {
      // do
      ProcessInstance instance = runtimeService.startProcessInstanceByKey("Sample");
      assertThat(instance).isNotNull();

      long numInstances = runtimeService.createProcessInstanceQuery().count();
      assertThat(numInstances).isEqualTo(1);
  }

  @Test
  public void testEngineRegistration()
  {
    ProcessEngine registeredEngine = ProcessEngines.getProcessEngine("default");
    assertThat(registeredEngine).isSameAs(processEngine);
  }

  @Test
  public void testEngineName()
  {
    assertThat(processEngine.getName()).isEqualTo("default");

  }
}
