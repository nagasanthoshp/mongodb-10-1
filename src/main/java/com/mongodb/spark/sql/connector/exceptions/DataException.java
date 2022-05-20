/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.mongodb.spark.sql.connector.exceptions;

/** A class for all data exceptions. */
public final class DataException extends MongoSparkException {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new instance.
   *
   * @param message the message
   */
  public DataException(final String message) {
    super(message);
  }

  /**
   * Constructs a new instance.
   *
   * @param message the message
   * @param cause the cause
   */
  public DataException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new instance.
   *
   * @param cause the cause
   */
  public DataException(final Throwable cause) {
    super(cause);
  }
}
