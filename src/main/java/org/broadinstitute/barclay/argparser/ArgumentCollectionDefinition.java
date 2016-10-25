package org.broadinstitute.barclay.argparser;

import java.io.Serializable;

/**
 * Marker interface for classes that are intended to be used with @ArgumentCollection
 * Those are parsed by CommandLineParser implementations.
 */
public interface ArgumentCollectionDefinition extends Serializable{
}
