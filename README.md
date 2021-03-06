# JsonConfig4J
> Basic config implementation which serializes its values to JSON

## Downloads
### Jar
Releases can be downloaded [here](https://github.com/EliasStar/JsonConfig4J/releases).
If you need an "all in one" jar, grab the one with the jar-with-dependencies suffix. I includes the dependencies, therefore you don't need anything else.
If you want to manage your dependencies yourself use the one without a suffix.
"sources" suffix includes the raw, uncompiled sourcecode for reference and the javadoc can be found in the "javadoc" suffix jar.

### Maven
#### pom.xml
Add the following under `project/repositories` tag:
```xml
<repository>
    <id>github</id>
    <name>JsonConfig4J GitHub Maven Packages</name>
    <url>https://maven.pkg.github.com/EliasStar/JsonConfig4J</url>
</repository>
```
Furthermore add the following under `project/dependencies` tag:
```xml
<dependency>
    <groupId>eliasstar</groupId>
    <artifactId>json-config</artifactId>
    <version>VERSION</version>
</dependency>
```
Replace `VERSION` with a version found under releases, preferably the latest.

#### settings.xml
Is located under `~/.m2/settings.xml`.
Add the following under `settings/servers` tag:
```xml
<server>
    <id>github</id>
    <username>YOUR_USERNAME</username>
    <password>YOUR_PERSONAL_ACCESS_TOKEN</password>
</server>
```
Be sure to replace `YOUR_USERNAME` and `YOUR_PERSONAL_ACCESS_TOKEN`.

## License
JsonConfig4J - Basic config implementation which serializes its values to JSON <br>
Copyright (C) 2021 Elias*

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
