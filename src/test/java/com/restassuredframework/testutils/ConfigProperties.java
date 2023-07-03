package com.restassuredframework.testutils;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src\\test\\resources\\propertyfiles\\${environment}.properties"
})
public interface ConfigProperties extends Config
{
    @Key("baseURI")
    String getBaseURI();
    @Key("basePath")
    String getBasePath();
    @Key("sheetName")
    String getSheetName();
}
