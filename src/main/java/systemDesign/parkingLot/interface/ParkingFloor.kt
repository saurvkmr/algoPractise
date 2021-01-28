package systemDesign.parkingLot.`interface`

import systemDesign.parkingLot.util.VehicleType

abstract class ParkingFloor(
    val floorNumber: Int,
    private var totalCarParkingSpots: Int,
    private var totalBikeParkingSpots: Int,
    private var totalTruckParkingSpots: Int,
    private var totalEVParkingSpots: Int,
    private var entryGateCount: Int,
    private var exitGateCount: Int
) {
    var emptyCarParkingSpots = totalCarParkingSpots
    var emptyBikeParkingSpots = totalBikeParkingSpots
    var emptyTruckParkingSpots = totalTruckParkingSpots
    var emptyEVParkingSpots = totalEVParkingSpots

    fun occupyParkingSpot(vehicleType: VehicleType) {
        when (vehicleType) {
            VehicleType.ELECTRIC -> emptyEVParkingSpots--
            VehicleType.TRUCK -> emptyTruckParkingSpots--
            VehicleType.CAR -> emptyCarParkingSpots--
            VehicleType.BIKE -> emptyBikeParkingSpots--
        }
    }

    fun addParkingSpot(vehicleType: VehicleType) {
        when (vehicleType) {
            VehicleType.ELECTRIC -> totalEVParkingSpots++
            VehicleType.TRUCK -> totalTruckParkingSpots++
            VehicleType.CAR -> totalCarParkingSpots++
            VehicleType.BIKE -> totalBikeParkingSpots++
        }
    }


}