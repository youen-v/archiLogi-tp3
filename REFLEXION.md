# REFLEXION

**Design de packages.** Chaque module a un package racine dédié : `com.jad.app`, `com.jad.sensor`, `com.jad.data`, `com.jad.report` (+ `com.jad.report.spi`), `com.jad.ui`, `com.jad.utils`. Les dépendances sont orientées vers `utils` et remontent via `main-application`; l’UI consomme les rapports, les rapports consomment une SPI.

**Parent POM.** Centralisation des versions (JUnit, plugins), Java verrouillé sur 21 via `<release>21</release>`, règles Enforcer (Java 21, convergence). Les plugins sont gérés dans `pluginManagement` pour supprimer les doublons côté modules. Surefire est configuré JUnit 5 (module path on).

**Risque évité.** Dérive de versions et conflits de classes (convergence), couplage fort `report-generation` ↔ `data-management`. Avec la SPI (`com.jad.report.spi.ReportDataProvider`), `report-generation` ne dépend plus de `data-management` (principe DIP “light”), réduisant les cycles potentiels.

**Option implémentée.** *Option B — Interface SPI côté report.* `report-generation` expose le contrat, `data-management` fournit l’implémentation. Aucun impact sur `sensor-generation` ou `ui`. La flèche croisée disparaît du diagramme de packages.

**Prochaine amélioration.** Introduire un module `domain-model` (records/DTO communs) pour mutualiser les types partagés (éviter que `utils` devienne fourre-tout), ajouter `maven-toolchains-plugin` si plusieurs JDK, et activer des checks supplémentaires (`banDuplicateClasses`, `enforceBytecodeVersion`).

**Tests.** Exécuter `mvn -q -DskipTests dependency:tree` avant/après pour constater l’alignement avec le diagramme ; puis `mvn -T1C -DskipITs test` pour vérifier les tests unitaires JUnit 5.
