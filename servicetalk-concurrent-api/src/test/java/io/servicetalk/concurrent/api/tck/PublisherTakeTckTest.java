/*
 * Copyright © 2018 Apple Inc. and the ServiceTalk project authors
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
 */
package io.servicetalk.concurrent.api.tck;

import io.servicetalk.concurrent.api.Publisher;

import org.testng.annotations.Test;

@Test
public class PublisherTakeTckTest extends AbstractPublisherOperatorTckTest<Integer> {

    @Override
    public Publisher<Integer> createServiceTalkPublisher(long elements) {
        // Double the elements so we can then use take(...) to enforce the original count again.
        return super.createServiceTalkPublisher(elements * 2);
    }

    @Override
    protected Publisher<Integer> composePublisher(Publisher<Integer> publisher, int elements) {
        // If zero elements are requested we will just return the original publisher.
        return elements == 0 ? publisher : publisher.take(elements / 2);
    }
}