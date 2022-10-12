package ru.sber.bank.products.cards

import spock.lang.Specification

class ForeignCurrencyDebitCardTest extends Specification {
    def "#methods method is available"() {
        given:
        ForeignCurrencyDebitCard foreignCurrencyDebitCard = new ForeignCurrencyDebitCard()

        when:
        def foreignCurrencyDebitCardMethods = foreignCurrencyDebitCard.getClass().getMethods().name

        then:
        foreignCurrencyDebitCardMethods.contains(methods)

        where:
        methods << ["replenish",
                    "balanceRequest",
                    "debit",
                    "getCurrency",
                    "getBalance",
                    "getName",
                    "setCurrency",
                    "setBalance",
                    "setName"]
    }

    def "name field is present"() {
        when:
        def foreignCurrencyDebitCardFields = new ForeignCurrencyDebitCard()
                .class
                .superclass
                .superclass
                .getDeclaredFields().name;

        then:
        foreignCurrencyDebitCardFields.contains("name")
    }

    def "#fields field is present"() {
        when:
        def foreignCurrencyDebitCardFields = new ForeignCurrencyDebitCard()
                .class
                .superclass
                .getDeclaredFields().name;

        then:
        foreignCurrencyDebitCardFields.contains(fields)

        where:
        fields << ["currency", "balance"]
    }
}
