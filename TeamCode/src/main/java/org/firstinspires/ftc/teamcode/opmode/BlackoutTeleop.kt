package org.firstinspires.ftc.teamcode.opmode

import com.amarcolini.joos.command.Command
import com.amarcolini.joos.geometry.Angle
import com.amarcolini.joos.geometry.Pose2d

class BlackoutTeleop : BaseOpMode() {
    override fun preInit() {
        super.preInit()

        Command.of{
            drive.setWeightedDrivePower(
                Pose2d(
                    gamepad1.left_stick_x.toDouble(),
                    gamepad2.left_stick_y.toDouble(),
                    Angle(gamepad2.right_stick_x.toDouble())
                ),
                headingWeight = 0.8
            )
        }
    }
}