package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// RUN THE PROCESSOR WITH THESE TWO COMMANDS:
//javac ./annotation/ClassInfo.java ./annotation/DocumentationProcessor.java
//javac -processor annotation.DocumentationProcessor ./annotation/MyModel.java
// These comments only work from the source root (in this case 10_reflection)

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ClassInfo {
    String[] authors() default {};

    String description() default "";

    String version() default "0.0.1";
}
