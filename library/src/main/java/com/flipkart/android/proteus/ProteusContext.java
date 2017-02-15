/*
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION
 *
 * Copyright (c) 2017 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.flipkart.android.proteus;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.flipkart.android.proteus.toolbox.Formatter;
import com.flipkart.android.proteus.toolbox.IdGenerator;
import com.flipkart.android.proteus.toolbox.IdGeneratorImpl;
import com.flipkart.android.proteus.value.Layout;
import com.flipkart.android.proteus.value.Value;

import java.util.Map;

/**
 * ProteusContext
 *
 * @author aditya.sharat
 */

public class ProteusContext extends ContextWrapper {

    @NonNull
    private final ProteusResources resources;

    @Nullable
    private final ProteusLayoutInflater.Callback callback;

    @Nullable
    private final ProteusLayoutInflater.ImageLoader loader;

    private ProteusLayoutInflater inflater;

    ProteusContext(Context base, @NonNull ProteusResources resources,
                   @Nullable ProteusLayoutInflater.ImageLoader loader,
                   @Nullable ProteusLayoutInflater.Callback callback) {
        super(base);
        this.callback = callback;
        this.loader = loader;
        this.resources = resources;
    }

    @Nullable
    public ProteusLayoutInflater.Callback getCallback() {
        return callback;
    }

    @Nullable
    public Formatter getFormatter(@NonNull String name) {
        return resources.getFormatter(name);
    }

    @Nullable
    public Layout getLayout(@NonNull String name) {
        return resources.getLayout(name);
    }

    @Nullable
    public ProteusLayoutInflater.ImageLoader getLoader() {
        return loader;
    }

    @NonNull
    public ProteusLayoutInflater getInflater(@NonNull IdGenerator idGenerator) {
        if (null == this.inflater) {
            this.inflater = new SimpleLayoutInflater(this, idGenerator);
        }
        return this.inflater;
    }

    @NonNull
    public ProteusLayoutInflater getInflater() {
        return getInflater(new IdGeneratorImpl());
    }

    @Nullable
    public ViewTypeParser getParser(String type) {
        return resources.getParsers().get(type);
    }

    @NonNull
    public ProteusResources getProteusResources() {
        return resources;
    }

    @Nullable
    public Map<String, Value> getStyle(String name) {
        return resources.getStyle(name);
    }
}
