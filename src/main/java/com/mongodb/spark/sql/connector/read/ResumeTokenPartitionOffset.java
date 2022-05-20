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

package com.mongodb.spark.sql.connector.read;

import java.util.Objects;

import org.apache.spark.sql.connector.read.streaming.PartitionOffset;

import org.bson.BsonDocument;

import com.mongodb.spark.sql.connector.assertions.Assertions;

/** A resume token partition offset */
public final class ResumeTokenPartitionOffset implements PartitionOffset {
  private static final long serialVersionUID = 1L;
  private final BsonDocument resumeToken;
  static final ResumeTokenPartitionOffset INITIAL_RESUME_TOKEN_PARTITION_OFFSET =
      new ResumeTokenPartitionOffset(new BsonDocument());

  /**
   * Construct a new instance
   *
   * @param resumeToken the change stream resume token
   */
  public ResumeTokenPartitionOffset(final BsonDocument resumeToken) {
    Assertions.ensureArgument(() -> resumeToken != null, () -> "Invalid resume token");
    this.resumeToken = resumeToken;
  }

  BsonDocument getResumeToken() {
    return resumeToken;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final ResumeTokenPartitionOffset that = (ResumeTokenPartitionOffset) o;
    return Objects.equals(getResumeToken(), that.getResumeToken());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getResumeToken());
  }

  @Override
  public String toString() {
    return "ResumeTokenPartitionOffset{" + "resumeToken=" + resumeToken.toJson() + '}';
  }
}
