package eu.bitwalker.jhreactdemo;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("eu.bitwalker.jhreactdemo");

        noClasses()
            .that()
            .resideInAnyPackage("eu.bitwalker.jhreactdemo.service..")
            .or()
            .resideInAnyPackage("eu.bitwalker.jhreactdemo.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..eu.bitwalker.jhreactdemo.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
