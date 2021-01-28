package systemDesign.parkingLot.pojo

import systemDesign.parkingLot.`interface`.Gate
import systemDesign.parkingLot.util.GateType

class ExitGate(override val gateType: GateType) : Gate {
    override fun ticketBehaviour() {
        // scan ticket and do payment
    }
}