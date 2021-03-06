/*
 * Copyright (C) 2011-2015 Aestas/IT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aestasit.infrastructure.winrm.client

import com.aestasit.infrastructure.winrm.WinRMException
import org.junit.Test

import static org.junit.Assert.assertNotNull

/**
 * <code>WinRMClient</code> creation tests.
 *
 * @author Sergey Korenko
 */
class ClientCreationTest {

  @Test(expected = WinRMException.class)
  void testEmptyHost() {
    def client = new WinRMClient(user: 'vagrant', password: 'vagrant')
    client.initialize()
  }

  @Test(expected = WinRMException.class)
  void testEmptyUser() {
    def client = new WinRMClient(host: '192.168.56.101', password: 'vagrant')
    client.initialize()
  }

  @Test(expected = WinRMException.class)
  void testEmptyPassword() {
    def client = new WinRMClient(host: '192.168.56.101', user: 'vagrant')
    client.initialize()
  }

  @Test
  void testCorrectParameters() {
    def client = new WinRMClient(host: '192.168.56.101', user: 'vagrant', password: 'vagrant', port: 5985)
    client.initialize()
    assertNotNull client.httpBuilder
  }

}
