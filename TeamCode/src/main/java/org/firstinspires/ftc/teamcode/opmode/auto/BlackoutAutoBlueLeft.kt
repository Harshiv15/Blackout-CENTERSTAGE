package org.firstinspires.ftc.teamcode.opmode.auto

import com.acmerobotics.roadrunner.Pose2d
import org.firstinspires.ftc.teamcode.MecanumDrive
import org.firstinspires.ftc.teamcode.opmode.BaseOpMode
import org.firstinspires.ftc.teamcode.util.TrajEnums.PreloadTrajs

class BlackoutAutoBlueLeft: BaseOpMode() {
    override fun preInit() {
        super.preInit()

        drive.followTrajectory(PreloadTrajs.BLUE_FAR_MID.followWith(drive))
    }
}