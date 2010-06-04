/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client.action.admin.cluster.ping.single;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.ListenableActionFuture;
import org.elasticsearch.action.admin.cluster.ping.single.SinglePingRequest;
import org.elasticsearch.action.admin.cluster.ping.single.SinglePingResponse;
import org.elasticsearch.action.support.PlainListenableActionFuture;
import org.elasticsearch.client.internal.InternalClusterAdminClient;

/**
 * @author kimchy (shay.banon)
 */
public class SinglePingRequestBuilder {

    private final InternalClusterAdminClient clusterClient;

    private final SinglePingRequest request;

    public SinglePingRequestBuilder(InternalClusterAdminClient clusterClient) {
        this.clusterClient = clusterClient;
        this.request = new SinglePingRequest();
    }

    public SinglePingRequestBuilder setIndex(String index) {
        request.index(index);
        return this;
    }

    public SinglePingRequestBuilder setType(String type) {
        request.type(type);
        return this;
    }

    public SinglePingRequestBuilder setId(String id) {
        request.id(id);
        return this;
    }

    public SinglePingRequestBuilder setListenerThreaded(boolean threadedListener) {
        request.listenerThreaded(threadedListener);
        return this;
    }

    public SinglePingRequestBuilder setOperationThreaded(boolean threadedOperation) {
        request.operationThreaded(threadedOperation);
        return this;
    }

    /**
     * Executes the operation asynchronously and returns a future.
     */
    public ListenableActionFuture<SinglePingResponse> execute() {
        PlainListenableActionFuture<SinglePingResponse> future = new PlainListenableActionFuture<SinglePingResponse>(request.listenerThreaded(), clusterClient.threadPool());
        clusterClient.ping(request, future);
        return future;
    }

    /**
     * Executes the operation asynchronously with the provided listener.
     */
    public void execute(ActionListener<SinglePingResponse> listener) {
        clusterClient.ping(request, listener);
    }
}