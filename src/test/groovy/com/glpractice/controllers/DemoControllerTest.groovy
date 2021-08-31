package com.glpractice.controllers

import spock.lang.Specification

class DemoControllerTest extends Specification {

    def "should return an assertion"() {
        expect:
        1 == 1
    }

    def "return of demo controller"(){

        given: "the controller"
        DemoController demoController = new DemoController()

        when: "we call the method get response"
        String response = demoController.getResponse()

        then: "we got Hola mundo!"
        response == "Hola mundo!"

    }

    def "mock of demo controller"(){
        given: "the controller"
        DemoController demoController = Mock()

        when: "we call the method get response"
        demoController.getResponse()

        then: "we got Hola mundo!"
        1 * demoController.getResponse()
    }



}
