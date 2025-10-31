import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserInterfaceTest {
    private static final String DEPENDENCY_TREE_FILE = "../user-interface/target/dependency-tree.txt";
    private static final String DEPENDENCY_PREFIX = "com.jad:";
    private static String DEPENDENCY_TREE;

    @BeforeAll
    static void readDependencyTree() throws IOException {
        UserInterfaceTest.DEPENDENCY_TREE = new String(
                Files.readAllBytes(Paths.get(UserInterfaceTest.DEPENDENCY_TREE_FILE)));
    }

    @Test
    void doAllTests() {
        this.testDataManagementDependency();
        this.testMainApplicationDependency();
        this.testReportGenerationDependency();
        this.testSensorDataCollectionDependency();
    }

    @Test
    void testDataManagementDependency() {
        assertFalse(UserInterfaceTest.DEPENDENCY_TREE.contains(UserInterfaceTest.DEPENDENCY_PREFIX + "data-management"),
                    "Dependency 'data-management' should not be present");
    }

    @Test
    void testMainApplicationDependency() {
        assertFalse(
                UserInterfaceTest.DEPENDENCY_TREE.contains(UserInterfaceTest.DEPENDENCY_PREFIX + "main-application"),
                "Dependency 'main-application' should not be present");
    }

    @Test
    void testReportGenerationDependency() {
        assertFalse(
                UserInterfaceTest.DEPENDENCY_TREE.contains(UserInterfaceTest.DEPENDENCY_PREFIX + "report-generation"),
                "Dependency 'report-generation' should not be present");
    }

    @Test
    void testSensorDataCollectionDependency() {
        assertFalse(
                UserInterfaceTest.DEPENDENCY_TREE.contains(
                        UserInterfaceTest.DEPENDENCY_PREFIX + "sensor-data-collection"),
                "Dependency 'sensor-data-collection' should not be present");
    }
}
