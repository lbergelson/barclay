package org.broadinstitute.barclay.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Utility classes used by the command line parsers.
 */
public class Utils {
    /**
     * Checks that an Object {@code object} is not null and returns the same object or throws an {@link IllegalArgumentException}
     * @param object any Object
     * @return the same object
     * @throws IllegalArgumentException if a {@code o == null}
     */
    public static <T> T nonNull(final T object) {
        return Utils.nonNull(object, "Null object is not allowed here.");
    }

    /**
     * Checks that an {@link Object} is not {@code null} and returns the same object or throws an {@link IllegalArgumentException}
     * @param object any Object
     * @param message the text message that would be passed to the exception thrown when {@code o == null}.
     * @return the same object
     * @throws IllegalArgumentException if a {@code o == null}
     */
    public static <T> T nonNull(final T object, final String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
        return object;
    }

    /**
     * Checks that an {@link Object} is not {@code null} and returns the same object or throws an {@link IllegalArgumentException}
     * @param object any Object
     * @param message the text message that would be passed to the exception thrown when {@code o == null}.
     * @return the same object
     * @throws IllegalArgumentException if a {@code o == null}
     */
    public static <T> T nonNull(final T object, final Supplier<String> message) {
        if (object == null) {
            throw new IllegalArgumentException(message.get());
        }
        return object;
    }

    /**
     * Returns a string of the form elt1.toString() [sep elt2.toString() ... sep elt.toString()] for a collection of
     * elti objects (note there's no actual space between sep and the elti elements).  Returns
     * "" if collection is empty.  If collection contains just elt, then returns elt.toString()
     *
     * @param separator the string to use to separate objects
     * @param objects a collection of objects.  the element order is defined by the iterator over objects
     * @param <T> the type of the objects
     * @return a non-null string
     */
    public static <T> String join(final String separator, final Collection<T> objects) {
        if (objects.isEmpty()) { // fast path for empty collection
            return "";
        } else {
            final Iterator<T> iter = objects.iterator();
            final T first = iter.next();

            if ( ! iter.hasNext() ) // fast path for singleton collections
            {
                return first.toString();
            } else { // full path for 2+ collection that actually need a join
                final StringBuilder ret = new StringBuilder(first.toString());
                while(iter.hasNext()) {
                    ret.append(separator);
                    ret.append(iter.next().toString());
                }
                return ret.toString();
            }
        }
    }

}
