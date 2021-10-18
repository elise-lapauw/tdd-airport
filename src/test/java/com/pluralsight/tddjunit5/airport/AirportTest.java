package com.pluralsight.tddjunit5.airport;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Given there is a economy flight")
    @Nested
    class EconomyFlightTest {
        private Flight economyFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("When we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("Then you can add and remove him from an economy flight")
            public void testEconomyFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                        () -> assertTrue(economyFlight.getPassengerSet().contains(mike)),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengerSet().size())
                );
            }

            @RepeatedTest(5)
            @DisplayName("Then you cannot add him to an economy flight more than once")
            public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(mike);
                }
                assertAll("Verify a usual passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                        () -> assertTrue(economyFlight.getPassengerSet().contains(mike)),
                        () -> assertTrue(economyFlight.getPassengerSet().contains(mike))
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then we can add him but cannot remove him from an economy flight")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                        () -> assertTrue(economyFlight.getPassengerSet().contains(john)),
                        () -> assertEquals(false, economyFlight.removePassenger(john)),
                        () -> assertEquals(1, economyFlight.getPassengerSet().size())
                );

            }

            @RepeatedTest(5)
            @DisplayName("Then you cannot add him to an economy flight more than once")
            public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(john);
                }
                assertAll("Verify a VIP passenger can be added to an economy flight only once",
                        () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                        () -> assertTrue(economyFlight.getPassengerSet().contains(john)),
                        () -> assertTrue(economyFlight.getPassengerSet().contains(john))
                );
            }
        }

    }

    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("Whe we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("The we cannot add or remove him from a business flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a business flight",
                    () -> assertEquals(false, businessFlight.addPassenger(mike)),
                    () -> assertEquals(0, businessFlight.getPassengerSet().size()),
                    () -> assertEquals(false, businessFlight.removePassenger(mike)),
                    () -> assertEquals(0, businessFlight.getPassengerSet().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then we can add him but cannot remove him from a business flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a business flight",
                        () -> assertEquals(true, businessFlight.addPassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengerSet().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(john)),
                        () -> assertEquals(1, businessFlight.getPassengerSet().size())
                );
            }

            @RepeatedTest(5)
            @DisplayName("Then you cannot add him to an business flight more than once")
            public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    businessFlight.addPassenger(john);
                }
                assertAll("Verify a VIP passenger can be added to an business flight only once",
                        () -> assertEquals(1, businessFlight.getPassengerSet().size()),
                        () -> assertTrue(businessFlight.getPassengerSet().contains(john)),
                        () -> assertTrue(businessFlight.getPassengerSet().contains(john))
                );
            }
        }

    }

    @DisplayName("Given there is a premium flight")
    @Nested
    class PremiumFlightTest {
        private Flight premiumFlight;
        private Passenger mike;
        private Passenger john;

        @BeforeEach
        void setUp() {
            premiumFlight = new PremiumFlight("3");
            mike = new Passenger("Mike", false);
            john = new Passenger("John", true);
        }

        @Nested
        @DisplayName("Whe we have a usual passenger")
        class UsualPassenger {
            @Test
            @DisplayName("The we cannot add or remove him from a premium flight")
            public void testBusinessFlightUsualPassenger() {
                assertAll("Verify all conditions for a usual passenger and a premium flight",
                        () -> assertEquals(false, premiumFlight.addPassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengerSet().size()),
                        () -> assertEquals(false, premiumFlight.removePassenger(mike)),
                        () -> assertEquals(0, premiumFlight.getPassengerSet().size())
                );
            }
        }

        @Nested
        @DisplayName("Whe we have a VIP passenger")
        class VipPassenger {
            @Test
            @DisplayName("Then we can add him and remove him from a premium flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and a premium flight",
                        () -> assertEquals(true, premiumFlight.addPassenger(john)),
                        () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                        () -> assertEquals(true, premiumFlight.removePassenger(john)),
                        () -> assertEquals(0, premiumFlight.getPassengerSet().size())
                );
            }

            @RepeatedTest(5)
            @DisplayName("Then you cannot add him to an economy flight more than once")
            public void testPremiumFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    premiumFlight.addPassenger(john);
                }
                assertAll("Verify a VIP passenger can be added to an premium flight only once",
                        () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                        () -> assertTrue(premiumFlight.getPassengerSet().contains(john)),
                        () -> assertTrue(premiumFlight.getPassengerSet().contains(john))
                );
            }
        }

    }

}
