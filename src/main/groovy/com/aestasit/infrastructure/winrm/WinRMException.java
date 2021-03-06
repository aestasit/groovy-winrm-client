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

package com.aestasit.infrastructure.winrm;

/**
 * Generic exception to be thrown in exceptional situations.
 *
 * @author Andrey Adamovich
 */
public class WinRMException extends RuntimeException {
  Integer code;

  public WinRMException(String message) {
    super(message);
  }

  public WinRMException(String message, Throwable cause) {
    super(message, cause);
  }

  public WinRMException(Throwable th) {
    super(th);
  }

  public WinRMException(int code, String message) {
    super(message);
    this.code = code;
  }

  @Override
  public String getMessage() {
    if (null == code) {
      return super.getMessage();
    } else {
      return "Execution failed with the following HTTP status code [" + code + "]";
    }
  }
}