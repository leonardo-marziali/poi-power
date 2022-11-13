package com.github.leonardomarziali.poipower.exceptions.parser;

public class ObjectsOrListsToSetPerSheetKeyException extends RuntimeException {

    public ObjectsOrListsToSetPerSheetKeyException(Object key) {
        super(String.format(
                "Found a key of type %s in objectsOrListsToSetPerSheet map. ObjectsOrListsToSetPerSheet keys must be " +
                "of type %s or %s",
                key.getClass().getName(),
                String.class.getName(),
                Integer.class.getName()));
    }
}
