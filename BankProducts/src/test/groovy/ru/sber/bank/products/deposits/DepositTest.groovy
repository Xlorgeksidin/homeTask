package ru.sber.bank.products.deposits

import spock.lang.Specification

class DepositTest extends Specification {
    def "#methods method is available"() {
        given:
            Deposit deposit = new Deposit()
        when:
            def depositMethods = deposit.getClass().getMethods().name
        then:
            depositMethods.contains(methods)
        where: 
            methods << ["replenish",
                        "balanceRequest",
                        "close",
                        "getCurrency", 
                        "getBalance",
                        "getName",
                        "setCurrency",
                        "setBalance",
                        "setName"]
    }

    def "name field is present"() {
        when:
        def depositFields = new Deposit().class.superclass.superclass.getDeclaredFields().name;

        then:
        depositFields.contains("name")
    }

    def "#fields field is present"() {
        when:
        def depositFields = new Deposit().class.superclass.getDeclaredFields().name;

        then:
        depositFields.contains(fields)

        where:
        fields << ["currency", "balance"]
    }
}
