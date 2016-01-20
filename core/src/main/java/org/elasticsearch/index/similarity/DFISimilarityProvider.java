/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

package org.elasticsearch.index.similarity;

import org.apache.lucene.search.similarities.DFISimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;

/**
 * {@link SimilarityProvider} for the {@link DFISimilarity}.
 * <p>
 * Configuration options available:
 * <ul>
 *     <li>discount_overlaps</li>
 * </ul>
 * @see DFISimilarity For more information about configuration
 */
public class DFISimilarityProvider extends AbstractSimilarityProvider {

    private final DFISimilarity similarity;

    @Inject
    public DFISimilarityProvider(@Assisted String name, @Assisted Settings settings) {
        super(name);
        boolean discountOverlaps = settings.getAsBoolean("discount_overlaps", true);

        this.similarity = new DFISimilarity();
        this.similarity.setDiscountOverlaps(discountOverlaps);
    }

    @Override
    public Similarity get() {
        return similarity;
    }
}
