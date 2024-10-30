package patterns.understanding_structural_patterns

interface USPlug {
    val hasPower: Int
}

interface EUPlug {
    val hasPower: String // "YES" or "NO"
}

enum class PowerState {
    TRUE, FALSE
}
interface UsbMini {
    val hasPower: PowerState
}

interface UsbTypeC {
    val hasPower: Boolean
}



fun usPowerOutlet(): USPlug{
    return object: USPlug{
        override val hasPower = 1
    }
}


fun charger(plug: EUPlug): UsbMini{
    return object : UsbMini{
        override val hasPower = if (plug.hasPower == "YES")
            PowerState.TRUE else PowerState.FALSE

    }
}


//============[Adapting existing code]==============

fun USPlug.toEUPlug(): EUPlug{
    val hasPower = if(this.hasPower == 1) "YES" else "NO"

    return object : EUPlug{
        // Transfer power
        override val hasPower = hasPower
    }
}
//Let’s create the USB adapter between the UsbMini and UsbTypeC instances using an extension
//function:
fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == PowerState.TRUE
    return object : UsbTypeC {
        override val hasPower = hasPower
    }
}

//Now that we have the necessary adapters, we can combine them together to charge our phone
//successfully using the US power outlet and the USB charger:

fun cellPhone(chargeCable: UsbTypeC){
  charger(usPowerOutlet().toEUPlug()).toUsbTypeC()
}


fun runAdapter(){


}