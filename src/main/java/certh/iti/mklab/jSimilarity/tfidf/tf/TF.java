/*
 * Copyright 2016 vasgat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package certh.iti.mklab.jSimilarity.tfidf.tf;

import certh.iti.mklab.jSimilarity.documentUtils.Tokenizer;
import java.util.HashMap;

/**
 * An abstract class for the calculation of TF (term frequency). There are a
 * number of variations of Term Frequency that extend this class.
 *
 * @author vasgat
 */
public abstract class TF {

    protected Tokenizer tokenizer;

    /**
     * Each TF constructor needs to define a tokenizer.
     *
     * @param tokenizer
     */
    public TF(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    /**
     * Calculates the TF (term frequency) given the contents of a document as
     * string.
     *
     * @param contents input string
     * @return the calculated term frequency.
     */
    public abstract HashMap calculate(String contents);

    /**
     * returns a small description of the metric
     *
     * @return the small description
     */
    public abstract String info();

    /**
     * Calculates the raw Term Frequency of a given the contents of a document
     * as string
     *
     * @param contents input string
     * @return the term frequency (number of times a unique token appear within
     * a given document)
     */
    protected HashMap<String, Integer> rawFrequency(String contents) {
        String[] tokens = tokenizer.tokenize(contents);
        HashMap<String, Integer> tf = new HashMap();

        for (int i = 0; i < tokens.length; i++) {
            if (!tf.containsKey(tokens[i])) {
                tf.put(tokens[i], 1);
            } else {
                tf.put(tokens[i], tf.get(tokens[i]) + 1);
            }
        }

        return tf;
    }
}
