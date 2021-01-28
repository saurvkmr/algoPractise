package systemDesign.parkingLot.pojo

import systemDesign.parkingLot.`interface`.Gate
import systemDesign.parkingLot.util.GateType

class EntranceGate(override val gateType: GateType) : Gate {
    override fun ticketBehaviour() {
        // print ticket
    }
}