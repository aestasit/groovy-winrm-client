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

package com.aestasit.infrastructure.winrm.client.request

/**
 * Base request class.
 *
 * @author Sergey Korenko
 */
abstract class WinRMRequest {

  /// Constants used during composing WinRM request.
  static String NMSP_URI_S = 'http://www.w3.org/2003/05/soap-envelope'
  static String NMSP_URI_WSA = 'http://schemas.xmlsoap.org/ws/2004/08/addressing'
  static String NMSP_URI_WSMAN = 'http://schemas.dmtf.org/wbem/wsman/1/wsman.xsd'
  static String NMSP_URI_RSP = 'http://schemas.microsoft.com/wbem/wsman/1/windows/shell'
  static String NMSP_URI_XSI = 'http://www.w3.org/2001/XMLSchema-instance'

  static String URI_SHELL_CMD = 'http://schemas.microsoft.com/wbem/wsman/1/windows/shell/cmd'
  static String URI_ADDRESS = 'http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous'

  static int WINRS_CODEPAGE = 437
  static String WINRS_NOPROFILE = 'FALSE'

  URL toAddress

  int envelopSize = 153600;
  String locale = "en-US";
  String timeout

  WinRMRequest(URL toAddress, int timeout) {
    this.toAddress = toAddress
    this.timeout = "PT${timeout}S"
  }

}
