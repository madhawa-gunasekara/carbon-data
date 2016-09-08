/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.dataservices.core.odata;

import java.util.ArrayList;
import java.util.Enumeration;

public class CustomEnumeration<E> implements Enumeration<E> {

    private Enumeration<E> enumeration = null;
    private ArrayList<E> arrayList = new ArrayList<E>();
    private int pos = -1;


    CustomEnumeration(Enumeration<E> e) {
        this.enumeration = e;
    }

    CustomEnumeration() {

    }

    public void addValues(E ob) {
        arrayList.add(ob);
    }

    @Override
    public boolean hasMoreElements() {
        if (pos < arrayList.size() - 1 || (enumeration != null && enumeration.hasMoreElements())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E nextElement() {
        if (enumeration != null && enumeration.hasMoreElements()) {
            return enumeration.nextElement();
        } else if (pos < arrayList.size() - 1) {
            pos++;
            return this.arrayList.get(pos);
        } else {
            return null;
        }
    }
}
