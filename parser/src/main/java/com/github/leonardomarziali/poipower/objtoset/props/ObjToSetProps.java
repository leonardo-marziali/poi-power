package com.github.leonardomarziali.poipower.objtoset.props;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.usermodel.Sheet;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
public class ObjToSetProps {

    Object object;
    int sheetIndex;
    String sheetName;
    boolean condition;

    @Setter(AccessLevel.NONE)
    Sheet membershipSheet;


    public ObjToSetProps(Object object, int sheetIndex) {
        this.object = object;
        this.sheetIndex = sheetIndex;
    }

    public ObjToSetProps(Object object, String sheetName) {
        this.object = object;
        this.sheetName = sheetName;
    }
}
