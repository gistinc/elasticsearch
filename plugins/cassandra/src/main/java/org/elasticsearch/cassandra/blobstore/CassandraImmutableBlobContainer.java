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

package org.elasticsearch.cassandra.blobstore;

import org.elasticsearch.common.blobstore.BlobPath;
import org.elasticsearch.common.blobstore.ImmutableBlobContainer;
import org.elasticsearch.common.blobstore.support.BlobStores;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Tom May (tom@gist.com)
 */
public class CassandraImmutableBlobContainer extends AbstractCassandraBlobContainer implements ImmutableBlobContainer {

    public CassandraImmutableBlobContainer(BlobPath path, CassandraBlobStore blobStore) {
        super(path, blobStore);
        logger.debug("CassandraImmutableBlobContainer blobStore={} path={}",
            blobStore, path);
    }

    @Override public void writeBlob(String blobName, InputStream is, long sizeInBytes, WriterListener listener) {
        blobStore.writeBlob(blobPath, blobName, is, sizeInBytes, listener);
    }

    @Override public void writeBlob(String blobName, InputStream is, long sizeInBytes) throws IOException {
        BlobStores.syncWriteBlob(this, blobName, is, sizeInBytes);
    }
}
