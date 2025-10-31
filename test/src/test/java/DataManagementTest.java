import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataManagementTest {
    private static final String DEPENDENCY_TREE_FILE = "../data-management/target/dependency-tree.txt";
    private static final String DEPENDENCY_PREFIX = "com.jad:";
    private static String DEPENDENCY_TREE;

    @BeforeAll
    static void readDependencyTree() throws IOException {
        DataManagementTest.DEPENDENCY_TREE = new String(
                Files.readAllBytes(Paths.get(DataManagementTest.DEPENDENCY_TREE_FILE)));
    }

    @Test
    void doAllTests() {
        this.testMainApplicationDependency();
        this.testReportGenerationDependency();
        this.testSensorDataCollectionDependency();
        this.testUserInterfaceDependency();
    }

    @Test
    void testMainApplicationDependency() {
        assertFalse(
                DataManagementTest.DEPENDENCY_TREE.contains(DataManagementTest.DEPENDENCY_PREFIX + "main-application"),
                "Dependency 'main-application' should not be present");
    }

    @Test
    void testReportGenerationDependency() {
        assertFalse(
                DataManagementTest.DEPENDENCY_TREE.contains(DataManagementTest.DEPENDENCY_PREFIX + "report-generation"),
                "Dependency 'report-generation' should not be present");
    }

    @Test
    void testSensorDataCollectionDependency() {
        assertFalse(
                DataManagementTest.DEPENDENCY_TREE.contains(
                        DataManagementTest.DEPENDENCY_PREFIX + "sensor-data-collection"),
                "Dependency 'sensor-data-collection' should not be present");
    }

    @Test
    void testUserInterfaceDependency() {
        assertFalse(
                DataManagementTest.DEPENDENCY_TREE.contains(DataManagementTest.DEPENDENCY_PREFIX + "user-interface"),
                "Dependency 'user-interface' should not be present");
    }
}
