package ru.sber.bank.products.cards

import ru.sber.bank.products.cards.DebitCard
import spock.lang.Specification

class DebitCardTest extends Specification {
    def "#methods method is available"() {
        given:
        DebitCard debitCard = new DebitCard()
        
        when:
        def debitCardMethods = debitCard.getClass().getMethods().name
        
        then:
        debitCardMethods.contains(methods)
        
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
        def debitCardFields = new DebitCard().class.superclass.superclass.getDeclaredFields().name;

        then:
        debitCardFields.contains("name")
    }

    def "#fields field is present"() {
        when:
        def debitCardFields = new DebitCard().class.superclass.getDeclaredFields().name;

        then:
        debitCardFields.contains(fields)

        where:
        fields << ["currency", "balance"]
    }
}
