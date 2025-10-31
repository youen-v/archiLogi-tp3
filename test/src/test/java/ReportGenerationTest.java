import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ReportGenerationTest {
    private static final String DEPENDENCY_TREE_FILE = "../report-generation/target/dependency-tree.txt";
    private static final String DEPENDENCY_PREFIX = "com.jad:";
    private static String DEPENDENCY_TREE;

    @BeforeAll
    static void readDependencyTree() throws IOException {
        ReportGenerationTest.DEPENDENCY_TREE = new String(
                Files.readAllBytes(Paths.get(ReportGenerationTest.DEPENDENCY_TREE_FILE)));
    }

    @Test
    void doAllTests() {
        this.testDataManagementDependency();
        this.testMainApplicationDependency();
        this.testSensorDataCollectionDependency();
        this.testUserInterfaceDependency();
    }

    @Test
    void testDataManagementDependency() {
        assertFalse(
                ReportGenerationTest.DEPENDENCY_TREE.contains(
                        ReportGenerationTest.DEPENDENCY_PREFIX + "data-management"),
                "Dependency 'data-management' should not be present");
    }

    @Test
    void testMainApplicationDependency() {
        assertFalse(
                ReportGenerationTest.DEPENDENCY_TREE.contains(
                        ReportGenerationTest.DEPENDENCY_PREFIX + "main-application"),
                "Dependency 'main-application' should not be present");
    }

    @Test
    void testSensorDataCollectionDependency() {
        assertFalse(
                ReportGenerationTest.DEPENDENCY_TREE.contains(
                        ReportGenerationTest.DEPENDENCY_PREFIX + "sensor-data-collection"),
                "Dependency 'sensor-data-collection' should not be present");
    }

    @Test
    void testUserInterfaceDependency() {
        assertFalse(
                ReportGenerationTest.DEPENDENCY_TREE.contains(
                        ReportGenerationTest.DEPENDENCY_PREFIX + "user-interface"),
                "Dependency 'user-interface' should not be present");
    }
}
