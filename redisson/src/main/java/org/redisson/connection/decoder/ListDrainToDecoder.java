/**
 * Copyright (c) 2013-2020 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.connection.decoder;

import java.util.Collection;
import java.util.List;

import org.redisson.client.handler.State;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.decoder.MultiDecoder;

public class ListDrainToDecoder<V> implements MultiDecoder<Integer> {

    private Collection<Object> list;

    public ListDrainToDecoder(Collection<Object> list) {
        this.list = list;
    }

    @Override
    public Integer decode(List<Object> parts, State state) {
        list.addAll(parts);
        return parts.size();
    }

    @Override
    public Decoder<Object> getDecoder(int paramNum, State state) {
        return null;
    }

}
