package systemDesign.parkingLot.pojo

import systemDesign.parkingLot.util.AccountType

data class Person(
    var accountType: AccountType,
    var name: String,
    var address: String
)
