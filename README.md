# Kalc

Lightweight Kotlin library for operations on various units

## Installation

1. Add following lines to your settings.gradle.kts
   ```kotlin
    sourceControl{ 
        gitRepository(uri("https://github.com/KamilKurde/Kalc.git"))
           {
                producesModule("com.KamilKurde:Kalc")
           }
    }
   ```
2. Add following lines to your build.gradle.kts dependencies
   ```kotlin
       implementation("com.soywiz.korlibs.kbignum:kbignum:2.0.6")
       implementation("com.KamilKurde:Kalc")
       { 
           version 
           {
               branch = "main"
           }
       }
   ```
3. Run gradle assemble task
4. Sync gradle

## Supported operations

### How to read the table

* Pick row corresponding to first part of operation
* Check presence of operation symbol ('*' for multiplying and '/' for dividing) for column corresponding to second part of operation
* If the symbol is there, this means that operation is supported, and you can hover on the symbol to get knowledge of returned type

#### Example

1. For Area * Distance you first pick row corresponding to Area (second row of the table)
2. Then lookup to Distance column (forth column)
3. In this example you can hover on '*' symbol representing multiplying to get info of resulting type (Volume)

### Table

|Number                   |Area                     |Data                     |Density                  |Distance                 |Mass                     |Operations               |OperationSpeed           |Speed                    |Time                     |Transfer                 |Volume                   |
|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|:-----------------------:|
|Area                     |                         |                         |                         |     [*](a "Volume")     |                         |                         |                         |                         |                         |                         |                         |
|Data                     |                         |                         |                         |                         |                         |                         |                         |                         |    [/](a "Transfer")    |                         |                         |
|Density                  |                         |                         |                         |                         |                         |                         |                         |                         |                         |                         |      [*](a "Mass")      |
|Distance                 |     [*](a "Volume")     |                         |                         |       [*](a "Area")     |                         |                         |                         |      [/](a "Time")      |     [/](a "Speed")      |                         |                         |
|Mass                     |                         |                         |     [/](a "Volume")     |                         |                         |                         |                         |                         |                         |                         |    [/](a "Density")     |
|Operations               |                         |                         |                         |                         |                         |                         |      [/](a "Time")      |                         | [/](a "OperationSpeed") |                         |                         |
|OperationSpeed           |                         |                         |                         |                         |                         |                         |                         |                         |   [*](a "Operations")   |                         |                         |
|Speed                    |                         |                         |                         |                         |                         |                         |                         |                         |    [*](a "Distance")    |                         |                         |
|Time                     |                         |                         |                         |                         |                         |                         |                         |    [*](a "Distance")    |                         |                         |                         |
|Transfer                 |                         |                         |                         |                         |                         |                         |                         |                         |                         |                         |                         |
|Volume                   |                         |                         |      [*](a "Mass")      |                         |                         |                         |                         |                         |                         |                         |                         |
