/*
 * Copyright 2011-2012, Allanbank Consulting, Inc. 
 *           All Rights Reserved
 */

package com.allanbank.mongodb.client;

import com.allanbank.mongodb.Callback;
import com.allanbank.mongodb.Durability;
import com.allanbank.mongodb.MongoDbConfiguration;
import com.allanbank.mongodb.MongoDbException;
import com.allanbank.mongodb.ReadPreference;
import com.allanbank.mongodb.connection.ClusterType;
import com.allanbank.mongodb.connection.Message;
import com.allanbank.mongodb.connection.message.Reply;

/**
 * Unified client interface to MongoDB.
 * 
 * @api.no This class is <b>NOT</b> part of the drivers API. This class may be
 *         mutated in incompatible ways between any two releases of the driver.
 * @copyright 2011-2012, Allanbank Consulting, Inc., All Rights Reserved
 */
public interface Client {
    /**
     * Closes the client.
     */
    public void close();

    /**
     * Returns the type of cluster the client is connected to.
     * 
     * @return The type of cluster the client is connected to.
     */
    public ClusterType getClusterType();

    /**
     * Returns the configuration being used by the logical MongoDB connection.
     * 
     * @return The configuration being used by the logical MongoDB connection.
     */
    public MongoDbConfiguration getConfig();

    /**
     * Returns the {@link Durability} from the {@link MongoDbConfiguration}.
     * 
     * @return The default durability from the {@link MongoDbConfiguration}.
     */
    public Durability getDefaultDurability();

    /**
     * Returns the {@link ReadPreference} from the {@link MongoDbConfiguration}.
     * 
     * @return The default read preference from the {@link MongoDbConfiguration}
     *         .
     */
    public ReadPreference getDefaultReadPreference();

    /**
     * Sends a message on the connection.
     * 
     * @param reply
     *            The callback to notify of responses to the messages. May be
     *            null.
     * @param messages
     *            The messages to send on the connection. The messages will be
     *            sent one after the other and are guaranteed to be contiguous
     *            and have sequential message ids.
     * @return The address of the server the request will be sent to.
     * @throws MongoDbException
     *             On an error sending the message.
     */
    public String send(Callback<Reply> reply, Message... messages)
            throws MongoDbException;

    /**
     * Sends a message on the connection.
     * 
     * @param messages
     *            The messages to send on the connection. The messages will be
     *            sent one after the other and are guaranteed to be contiguous
     *            and have sequential message ids.
     * @return The address of the server the request will be sent to.
     * @throws MongoDbException
     *             On an error sending the message.
     */
    public String send(Message... messages) throws MongoDbException;
}
