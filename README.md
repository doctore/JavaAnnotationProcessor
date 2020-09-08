# JavaAnnotationProcessor

- [Why was this project created?](#why-was-this-project-created)
- [Elements included in this project](#elements-included-in-this-project)
    - [processor](#processor)
    - [processor-use-cases](#processor-use-cases)
- [New Java Annotation Processors](#new-java-annotation-processors)    
    - [LogTODO](#logTODO)
    
## Why was this project created?

Basically to know how to create custom Java annotation processors and use them in other projects, providing custom behaviour for every one.

## Elements included in this project

Below is shown a brief introduction to the modules included in this one:

### processor

New Java annotation processors we want to use in other projects. Every JAP includes at least the pair: annotation, class that extends of **AbstractProcessor**. 
<br>

### processor-use-cases

Used to include easy examples of the new JAPs added in **processor** module.

## New Java Annotation Processors

### LogTODO

Evolution of `// TODO:` comment we can use to include pending tasks information with better format and control of the compilation flow. Includes the following properties:  

* **relatedTask** source task of the current LogTODO.
* **description** extra information to explain why this annotation has been used.
* **displayAsError** if `false` the information will be displayed using a *warning* message, if `true` an *error* one.

In the next picture you will see an example of the result of compilation process using this JAP:

![Alt text](/documentation/LogTODO.png?raw=true "LogTODO example use case")

