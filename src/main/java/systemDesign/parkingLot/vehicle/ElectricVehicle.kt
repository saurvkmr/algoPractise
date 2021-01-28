package systemDesign.parkingLot.vehicle

import systemDesign.parkingLot.`interface`.Vehicle
import systemDesign.parkingLot.util.VehicleType

class ElectricVehicle(override val vehicleType: VehicleType, override val vehicleNumber: String) : Vehicle {
    override fun assignTicket() {
        TODO("Not yet implemented")
    }

}