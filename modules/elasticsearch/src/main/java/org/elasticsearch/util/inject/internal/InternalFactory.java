/**
 * Copyright (C) 2006 Google Inc.
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

package org.elasticsearch.util.inject.internal;

import org.elasticsearch.util.inject.spi.Dependency;

/**
 * Creates objects which will be injected.
 *
 * @author crazybob@google.com (Bob Lee)
 */
public interface InternalFactory<T> {

  /**
   * Creates an object to be injected.
   *
   * @param context of this injection
   * @throws org.elasticsearch.util.inject.internal.ErrorsException if a value cannot be provided
   * @return instance to be injected
   */
  T get(Errors errors, InternalContext context, Dependency<?> dependency)
      throws ErrorsException;
}