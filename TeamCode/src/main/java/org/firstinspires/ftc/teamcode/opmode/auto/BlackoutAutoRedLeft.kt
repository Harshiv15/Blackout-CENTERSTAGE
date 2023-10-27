package org.firstinspires.ftc.teamcode.opmode.auto

import org.firstinspires.ftc.teamcode.opmode.BaseOpMode
import org.firstinspires.ftc.teamcode.util.TrajEnums

class BlackoutAutoRedLeft : BaseOpMode() {
    override fun preInit() {
        super.preInit()

        drive.followTrajectory(TrajEnums.PreloadTrajs.RED_CLOSE_MID.followWith(drive))
    }
}