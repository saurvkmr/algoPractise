package systemDesign.parkingLot.`interface`

import systemDesign.parkingLot.util.GateType

interface Gate {
    val gateType: GateType
    fun ticketBehaviour()
}