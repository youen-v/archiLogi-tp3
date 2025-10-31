import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

class SensorDataCollectionTest {
    private static final String DEPENDENCY_TREE_FILE = "../sensor-data-collection/target/dependency-tree.txt";
    private static final String DEPENDENCY_PREFIX = "com.jad:";
    private static String DEPENDENCY_TREE;

    @BeforeAll
    static void readDependencyTree() throws IOException {
        SensorDataCollectionTest.DEPENDENCY_TREE = new String(
                Files.readAllBytes(Paths.get(SensorDataCollectionTest.DEPENDENCY_TREE_FILE)));
    }

    @Test
    void doAllTests() {
        this.testDataManagementDependency();
        this.testMainApplicationDependency();
        this.testReportGenerationDependency();
        this.testUserInterfaceDependency();
    }

    @Test
    void testDataManagementDependency() {
        assertFalse(
                SensorDataCollectionTest.DEPENDENCY_TREE.contains(
                        SensorDataCollectionTest.DEPENDENCY_PREFIX + "data-management"),
                "Dependency 'data-management' should not be present");
    }

    @Test
    void testMainApplicationDependency() {
        assertFalse(
                SensorDataCollectionTest.DEPENDENCY_TREE.contains(
                        SensorDataCollectionTest.DEPENDENCY_PREFIX + "main-application"),
                "Dependency 'main-application' should not be present");
    }

    @Test
    void testReportGenerationDependency() {
        assertFalse(
                SensorDataCollectionTest.DEPENDENCY_TREE.contains(
                        SensorDataCollectionTest.DEPENDENCY_PREFIX + "report-generation"),
                "Dependency 'report-generation' should not be present");
    }

    @Test
    void testUserInterfaceDependency() {
        assertFalse(
                SensorDataCollectionTest.DEPENDENCY_TREE.contains(
                        SensorDataCollectionTest.DEPENDENCY_PREFIX + "user-interface"),
                "Dependency 'user-interface' should not be present");
    }
}