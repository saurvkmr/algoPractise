package systemDesign.parkingLot.pojo

import systemDesign.parkingLot.util.ParkingSpotType

data class ParkingSpot(
    var spotNumber: Int,
    var floor: Int,
    var parkingSpotType: ParkingSpotType
)
