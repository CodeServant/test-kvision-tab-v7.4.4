# tabulator selection test with kvision v `7.4.4`
Setting selectableRows in tabulator kvision `7.4.4` does not make
a row selectable.  
Run this command on this project:

```./gradlew run -t``` - does not work for version `7.4.4`  
Set kvision version to `7.4.3` in [gradle.properties](gradle.properties)
and it works fine