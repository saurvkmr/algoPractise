package systemDesign.parkingLot.`interface`

import systemDesign.parkingLot.util.VehicleType

interface Vehicle {
    val vehicleType: VehicleType
    val vehicleNumber: String
    fun assignTicket();
}