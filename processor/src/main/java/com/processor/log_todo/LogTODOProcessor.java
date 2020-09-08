package com.processor.log_todo;

import com.processor.Constants;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

import static java.lang.String.format;

@SupportedAnnotationTypes(Constants.JAP.LOG_TODO)
@SupportedSourceVersion(SourceVersion.RELEASE_14)
public class LogTODOProcessor extends AbstractProcessor {

    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for ( Element element : roundEnv.getElementsAnnotatedWith(LogTODO.class) ) {
            displayMessage(element);
        }
        return true;
    }

    private void displayMessage(Element element) {
        LogTODO logAnnotation = element.getAnnotation(LogTODO.class);
        Diagnostic.Kind typeOfMessage = logAnnotation.displayAsError()
                ? Diagnostic.Kind.ERROR
                : Diagnostic.Kind.WARNING;
        processingEnv.getMessager().printMessage(typeOfMessage, getMessage(element, logAnnotation));
    }

    private String getMessage(Element element, LogTODO logAnnotation) {
        return format("PENDING TODO in %s related Jira task: %s with message: %s",
                elementLocation(element),
                logAnnotation.relatedTask(),
                logAnnotation.description());
    }

    private String elementLocation(Element element) {
        String className = null;
        switch (element.getKind()) {
            case FIELD, METHOD -> className = ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();
        }
        return null == className
                ? format("%s: %s", element.getKind(), element)
                : format("%s: %s of class: %s", element.getKind(), element, className);
    }

}
