/*
 * Copyright 2012, Allanbank Consulting, Inc. 
 *           All Rights Reserved
 */

package com.allanbank.mongodb.commands;

import com.allanbank.mongodb.bson.Document;

/**
 * Find provides an immutable container for all of the options for a query.
 * 
 * @copyright 2012, Allanbank Consulting, Inc., All Rights Reserved
 */
public class Find {

    /**
     * The number of documents to be returned. The is not the results batch
     * size.
     */
    private final int myNumberToReturn;

    /** The number of documents to skip before returning the first document. */
    private final int myNumberToSkip;

    /** If true then an error in the query should return any partial results. */
    private final boolean myPartialOk;

    /** The query document. */
    private final Document myQuery;

    /**
     * If true, then the query can be run against a replica which might be
     * slightly behind the primary.
     */
    private final boolean myReplicaOk;

    /** The fields to be returned from the matching documents. */
    private final Document myReturnFields;

    /**
     * Creates a new Find.
     * 
     * @param builder
     *            The builder to copy the query fields from.
     */
    protected Find(final Builder builder) {
        myQuery = builder.myQuery;
        myReturnFields = builder.myReturnFields;
        myNumberToReturn = builder.myNumberToReturn;
        myNumberToSkip = builder.myNumberToSkip;
        myPartialOk = builder.myPartialOk;
        myReplicaOk = builder.myReplicaOk;
    }

    /**
     * Returns the number of documents to be returned. The is not the results
     * batch size.
     * 
     * @return The number of documents to be returned.
     */
    public int getNumberToReturn() {
        return myNumberToReturn;
    }

    /**
     * Returns the number of documents to skip before returning the first
     * document.
     * 
     * @return The number of documents to skip before returning the first
     *         document.
     */
    public int getNumberToSkip() {
        return myNumberToSkip;
    }

    /**
     * Returns the query document.
     * 
     * @return The query document.
     */
    public Document getQuery() {
        return myQuery;
    }

    /**
     * Returns the fields to be returned from the matching documents.
     * 
     * @return The fields to be returned from the matching documents.
     */
    public Document getReturnFields() {
        return myReturnFields;
    }

    /**
     * Returns the partial okay value. If true then an error in the query should
     * return any partial results.
     * 
     * @return The partial okay value. If true then an error in the query should
     *         return any partial results.
     */
    public boolean isPartialOk() {
        return myPartialOk;
    }

    /**
     * Returns the replica okay value. If true, then the query can be run
     * against a replica which might be slightly behind the primary.
     * 
     * @return The replica okay value.
     */
    public boolean isReplicaOk() {
        return myReplicaOk;
    }

    /**
     * Helper for creating immutable {@link Find} queries.
     * 
     * @copyright 2011, Allanbank Consulting, Inc., All Rights Reserved
     */
    public static final class Builder {
        /**
         * The number of documents to be returned. The is not the results batch
         * size.
         */
        protected int myNumberToReturn;

        /** The number of documents to skip before returning the first document. */
        protected int myNumberToSkip;

        /**
         * If true then an error in the query should return any partial results.
         */
        protected boolean myPartialOk;

        /** The query document. */
        protected Document myQuery;

        /**
         * If true, then the query can be run against a replica which might be
         * slightly behind the primary.
         */
        protected boolean myReplicaOk;

        /** The fields to be returned from the matching documents. */
        protected Document myReturnFields;

        /**
         * Creates a new Builder.
         */
        public Builder() {
            myQuery = null;
            myReturnFields = null;
            myNumberToReturn = 0;
            myNumberToSkip = 0;
            myPartialOk = false;
            myReplicaOk = false;
        }

        /**
         * Creates a new Builder.
         * 
         * @param query
         *            The query document.
         */
        public Builder(final Document query) {
            this();
            myQuery = query;
        }

        /**
         * Constructs a new {@link Find} object from the state of the builder.
         * 
         * @return The new {@link Find} object.
         */
        public Find build() {
            return new Find(this);
        }

        /**
         * Sets the value of the number of documents to be returned to the new
         * value. The is not the results batch size.
         * 
         * @param numberToReturn
         *            The new value for the number of documents to be returned.
         * @return This builder for chaining method calls.
         */
        public Builder setNumberToReturn(final int numberToReturn) {
            myNumberToReturn = numberToReturn;
            return this;
        }

        /**
         * Sets the value of the number of documents to skip before returning
         * the first document to the new value.
         * 
         * @param numberToSkip
         *            The new value for the number of documents to skip before
         *            returning the first document.
         * @return This builder for chaining method calls.
         */
        public Builder setNumberToSkip(final int numberToSkip) {
            myNumberToSkip = numberToSkip;
            return this;
        }

        /**
         * Sets the value of partial okay to the new value. If true then an
         * error in the query should return any partial results.
         * 
         * @param partialOk
         *            The new value for the partial okay.
         * @return This builder for chaining method calls.
         */
        public Builder setPartialOk(final boolean partialOk) {
            myPartialOk = partialOk;
            return this;
        }

        /**
         * Sets the value of the query document to the new value.
         * 
         * @param query
         *            The new value for the query document.
         * @return This builder for chaining method calls.
         */
        public Builder setQuery(final Document query) {
            myQuery = query;
            return this;
        }

        /**
         * Sets the value of replica okay to the new value. If true, then the
         * query can be run against a replica which might be slightly behind the
         * primary
         * 
         * @param replicaOk
         *            The new value for the replica okay.
         * @return This builder for chaining method calls.
         */
        public Builder setReplicaOk(final boolean replicaOk) {
            myReplicaOk = replicaOk;
            return this;
        }

        /**
         * Sets the value of the fields to be returned from the matching
         * documents to the new value.
         * 
         * @param returnFields
         *            The new value for the fields to be returned from the
         *            matching documents.
         * @return This builder for chaining method calls.
         */
        public Builder setReturnFields(final Document returnFields) {
            myReturnFields = returnFields;
            return this;
        }
    }
}
