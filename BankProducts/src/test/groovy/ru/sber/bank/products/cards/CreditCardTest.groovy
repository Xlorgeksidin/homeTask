package ru.sber.bank.products.cards


import spock.lang.Specification

class CreditCardTest extends Specification {
    
    def "#methods method is available"() {
        given:
        CreditCard creditCard = new CreditCard()

        when:
        def creditCardMethods = creditCard.getClass().getMethods().name

        then:
        creditCardMethods.contains(methods)

        where:
        methods << ["debtRequest",
                    "replenish",
                    "balanceRequest",
                    "debit",
                    "getCurrency",
                    "getBalance",
                    "getName",
                    "setCurrency",
                    "setBalance",
                    "setName",
                    "getInterestRate",
                    "setInterestRate"]
    }
    
    def "interestRate field is present"() {
        given:
        CreditCard creditCard = new CreditCard();
        
        when:
        def creditCardFields = creditCard.class.getDeclaredFields().name;
        
        then:
        creditCardFields.contains("interestRate")
    }

    def "name field is present"() {
        when:
        def creditCardFields = new CreditCard().class.superclass.superclass.getDeclaredFields().name;

        then:
        creditCardFields.contains("name")
    }
    
    def "#fields field is present"() {
        when:
        def creditCardFields = new CreditCard().class.superclass.getDeclaredFields().name;

        then:
        creditCardFields.contains(fields)
        
        where:
        fields << ["currency", "balance"]
    }
}
