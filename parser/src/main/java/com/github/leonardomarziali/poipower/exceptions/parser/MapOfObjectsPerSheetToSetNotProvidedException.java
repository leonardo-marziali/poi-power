package com.github.leonardomarziali.poipower.exceptions.parser;

public class MapOfObjectsPerSheetToSetNotProvidedException extends ParseStartException {

    public MapOfObjectsPerSheetToSetNotProvidedException() {
        super("No map of objects to set per sheet found. Probably the call to setObjectsOrListsToSetPerSheetIndex, " +
              "setObjectsOrListsToSetPerSheetName, setObjectsOrListsToSetPerSheetIndexOrName is missing ");
    }
}
