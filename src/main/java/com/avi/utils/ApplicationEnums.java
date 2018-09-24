package com.avi.utils;


/**
 * Application Enums for Demo
 *
 *
 */
public class ApplicationEnums {

  
    /**
     *  Source system type
     */
    public enum SourceSystem {

        P("A"), S("S");
        private final String sourceSystem;

        SourceSystem(final String sourceSystem) {
            this.sourceSystem = sourceSystem;
        }

        public String toString() {
            return this.sourceSystem;
        }

        public static SourceSystem sourceName(String name) {
            for (SourceSystem source : values()) {
                if (source.toString().equalsIgnoreCase(name)) {
                    return source;
                }
            }
            return null;
        }
    }

}

