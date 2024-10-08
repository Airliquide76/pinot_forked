/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.query.service.dispatch.timeseries;

import javax.annotation.Nullable;
import org.apache.pinot.common.proto.Worker;
import org.apache.pinot.query.routing.QueryServerInstance;


/**
 * Response of the broker dispatch to the server.
 * TODO: This shouldn't exist and we should re-use AsyncQueryDispatchResponse. TBD as part of multi-stage
 *   engine integration.
 */
public class AsyncQueryTimeSeriesDispatchResponse {
  private final QueryServerInstance _serverInstance;
  private final Worker.TimeSeriesResponse _queryResponse;
  private final Throwable _throwable;

  public AsyncQueryTimeSeriesDispatchResponse(QueryServerInstance serverInstance,
      @Nullable Worker.TimeSeriesResponse queryResponse,
      @Nullable Throwable throwable) {
    _serverInstance = serverInstance;
    _queryResponse = queryResponse;
    _throwable = throwable;
  }

  public QueryServerInstance getServerInstance() {
    return _serverInstance;
  }

  @Nullable
  public Worker.TimeSeriesResponse getQueryResponse() {
    return _queryResponse;
  }

  @Nullable
  public Throwable getThrowable() {
    return _throwable;
  }
}
