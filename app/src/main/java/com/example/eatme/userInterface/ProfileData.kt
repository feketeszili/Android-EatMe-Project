package com.example.eatme.userInterface

class ProfileData {
    var id: Int = 0
    var name: String = ""
    var email: String = ""
    var phone: Int = 0
    var age: Int = 0
    var address: String = ""


    constructor( name: String, email: String, phone: Int, age: Int, address: String ){
        this.name = name
        this.email = email
        this.phone = phone
        this.age = age
        this.address = address
    }

    constructor()
}