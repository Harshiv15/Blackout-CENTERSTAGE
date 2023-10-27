package org.firstinspires.ftc.teamcode.subsystems

import com.amarcolini.joos.hardware.Imu
import com.amarcolini.joos.hardware.Motor
import com.amarcolini.joos.hardware.drive.DiffSwerveDrive
import org.firstinspires.ftc.teamcode.Coefficients.HEADING_PID
import org.firstinspires.ftc.teamcode.Coefficients.MODULE_PID
import org.firstinspires.ftc.teamcode.Coefficients.TRAJECTORY_CONSTRAINTS
import org.firstinspires.ftc.teamcode.Coefficients.TRANSLATIONAL_PID

@Suppress("unused")
class DriveSys(
        leftModule: Pair<Motor, Motor>,
        rightModule: Pair<Motor, Motor>,
        imu: Imu?
    ): DiffSwerveDrive(
    leftModule, rightModule, imu,
        TRAJECTORY_CONSTRAINTS,
        MODULE_PID, HEADING_PID, TRANSLATIONAL_PID
    )
{

}