/*
 * Copyright [2014] [www.rapidpm.org / Sven Ruppert (sven.ruppert@rapidpm.org)]
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.rapidpm.proxybuilder.type.staticruntime.virtual;

public class Util {

  private Util() {
  }

  public static String prettyPrint(Class<?> clazz) {
    return prettyPrint(clazz, "");
  }

  public static String prettyPrint(Class<?> c, String postfix) {
    if (c.isArray()) {
      return prettyPrint(c.getComponentType(), postfix + "[]");
    } else {
      Package pack = c.getPackage();
      if (pack != null && pack.getName().equals("java.lang")) {
        return c.getSimpleName() + postfix;
      }
      return c.getName() + postfix;
    }
  }
}
