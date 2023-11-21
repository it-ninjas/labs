package annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Arrays;
import java.util.Set;

// RUN THE PROCESSOR WITH THESE TWO COMMANDS:
//javac ./annotation/ClassInfo.java ./annotation/DocumentationProcessor.java
//javac -processor annotation.DocumentationProcessor ./annotation/MyModel.java
// These comments only work from the source root (in this case 10_reflection)

@SupportedAnnotationTypes("annotation.ClassInfo")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class DocumentationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
            for (Element element : annotatedElements) {
                ClassInfo classInfo = element.getAnnotation(ClassInfo.class);
                if (classInfo != null) {
                    System.out.println("------ " + element.getSimpleName() + " ------");
                    System.out.println("Description: " + classInfo.description());
                    System.out.println("Authors: " + Arrays.toString(classInfo.authors()));
                    System.out.println("Version: " + classInfo.version());
                    System.out.println();
                }
            }
        }
        return true;
    }
}
