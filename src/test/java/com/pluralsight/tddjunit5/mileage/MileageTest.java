package com.pluralsight.tddjunit5.mileage;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

/** TestInstance
 * Indique que l'on souhaite que les tests soient exécutés sur 1 seule instance de la classe
 * car on souhaite tester l'accumulation de points
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MileageTest {

    private Mileage mileage;

    @BeforeAll
    void beforeAll() {
        mileage = new Mileage();
    }
}
