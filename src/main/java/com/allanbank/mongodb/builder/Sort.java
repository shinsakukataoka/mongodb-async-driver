/*
 * Copyright 2012, Allanbank Consulting, Inc. 
 *           All Rights Reserved
 */

package com.allanbank.mongodb.builder;

import com.allanbank.mongodb.bson.element.IntegerElement;

/**
 * Provides the ability to easily specify the sort direction for an index or
 * sort specification.
 * 
 * @copyright 2012, Allanbank Consulting, Inc., All Rights Reserved
 */
public final class Sort {

    /**
     * Creates an ascending order specification, e.g.,
     * <tt>{ &lt;field&gt; : 1 }</tt>.
     * 
     * @param field
     *            The field to create the
     * @return The ascending sort specification.
     */
    public static IntegerElement asc(final String field) {
        return new IntegerElement(field, 1);
    }

    /**
     * Creates an descending order specification, e.g.,
     * <tt>{ &lt;field&gt; : -1 }</tt>.
     * 
     * @param field
     *            The field to create the
     * @return The descending sort specification.
     */
    public static IntegerElement desc(final String field) {
        return new IntegerElement(field, -1);
    }

    /**
     * Creates a new Sort.
     */
    private Sort() {
        super();
    }
}