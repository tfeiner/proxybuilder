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

import java.io.PrintWriter;

class VirtualProxySourceGeneratorSomeDuplicates
    extends VirtualProxySourceGenerator {
  public VirtualProxySourceGeneratorSomeDuplicates(
      Class<?> subject, Class<?> realSubject) {
    super(subject, realSubject, CreationStrategy.SOME_DUPLICATES);
  }

  protected void addImports(PrintWriter out) {
    out.println("import java.util.concurrent.atomic.*;");
    out.println();
  }

  protected void addRealSubjectCreation(PrintWriter out,
                                        String name,
                                        String realName) {
    out.printf(" private final AtomicReference<%s> ref = new AtomicReference<%1$s>();%n", name);
    out.println();
    out.printf(" private %s realSubject() {%n", name);
    out.printf(" %s result = ref.get()%n;", name);
    out.printf(" if (result == null) {%n");
    out.printf(" result = new %s();%n", realName);
    out.printf(" if (!ref.compareAndSet(null, result)) {%n");
    out.printf(" result = ref.get();%n");
    out.println(" }");
    out.println(" }");
    out.println(" return result;");
    out.println(" }");
  }
}







