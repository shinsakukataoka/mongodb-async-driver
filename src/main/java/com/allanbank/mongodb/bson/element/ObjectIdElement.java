/*
 * Copyright 2011-2012, Allanbank Consulting, Inc. 
 *           All Rights Reserved
 */
package com.allanbank.mongodb.bson.element;

import com.allanbank.mongodb.bson.Element;
import com.allanbank.mongodb.bson.ElementType;
import com.allanbank.mongodb.bson.Visitor;

/**
 * A wrapper for a BSON Object Id.
 * 
 * @api.yes This class is part of the driver's API. Public and protected members
 *          will be deprecated for at least 1 non-bugfix release (version
 *          numbers are &lt;major&gt;.&lt;minor&gt;.&lt;bugfix&gt;) before being
 *          removed or modified.
 * @copyright 2011-2012, Allanbank Consulting, Inc., All Rights Reserved
 */
public class ObjectIdElement extends AbstractElement {

    /** The BSON type for a Object Id. */
    public static final String DEFAULT_NAME = "_id";

    /** The BSON type for a Object Id. */
    public static final ElementType TYPE = ElementType.OBJECT_ID;

    /** Serialization version for the class. */
    private static final long serialVersionUID = -3563737127052573642L;

    /** The BSON Object id. */
    private final ObjectId myId;

    /**
     * Constructs a new {@link ObjectIdElement}.
     * 
     * @param name
     *            The name for the BSON Object Id.
     * @param id
     *            The object id.
     */
    public ObjectIdElement(final String name, final ObjectId id) {
        super(name);

        assert (id != null) : "The Object id cannot be null.";

        myId = id;
    }

    /**
     * Accepts the visitor and calls the {@link Visitor#visitObjectId} method.
     * 
     * @see Element#accept(Visitor)
     */
    @Override
    public void accept(final Visitor visitor) {
        visitor.visitObjectId(getName(), myId);
    }

    /**
     * Determines if the passed object is of this same type as this object and
     * if so that its fields are equal.
     * 
     * @param object
     *            The object to compare to.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        boolean result = false;
        if (this == object) {
            result = true;
        }
        else if ((object != null) && (getClass() == object.getClass())) {
            final ObjectIdElement other = (ObjectIdElement) object;

            result = super.equals(object) && myId.equals(other.myId);
        }
        return result;
    }

    /**
     * Returns the id value.
     * 
     * @return The id value.
     */
    public ObjectId getId() {
        return myId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ElementType getType() {
        return TYPE;
    }

    /**
     * Computes a reasonable hash code.
     * 
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        int result = 1;
        result = (31 * result) + super.hashCode();
        result = (31 * result) + myId.hashCode();
        return result;
    }

    /**
     * String form of the object.
     * 
     * @return A human readable form of the object.
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append('"');
        builder.append(getName());
        builder.append("\" : ");

        builder.append(myId);

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns a new {@link ObjectIdElement}.
     * </p>
     */
    @Override
    public ObjectIdElement withName(final String name) {
        return new ObjectIdElement(name, myId);
    }
}
