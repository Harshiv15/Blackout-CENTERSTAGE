package org.firstinspires.ftc.teamcode.opmode

import com.amarcolini.joos.command.CommandOpMode
import com.amarcolini.joos.hardware.Imu
import com.amarcolini.joos.hardware.drive.DiffSwerveDrive
import com.amarcolini.joos.trajectory.constraints.DiffSwerveConstraints
import org.firstinspires.ftc.teamcode.Coefficients.HEADING_PID
import org.firstinspires.ftc.teamcode.Coefficients.MODULE_PID
import org.firstinspires.ftc.teamcode.Coefficients.TRANSLATIONAL_PID
import org.firstinspires.ftc.teamcode.Drive.DRIVE_LEFT_A_NAME
import org.firstinspires.ftc.teamcode.Drive.DRIVE_LEFT_B_NAME
import org.firstinspires.ftc.teamcode.Drive.DRIVE_RIGHT_A_NAME
import org.firstinspires.ftc.teamcode.Drive.DRIVE_RIGHT_B_NAME
import org.firstinspires.ftc.teamcode.Motors
import org.firstinspires.ftc.teamcode.Motors.motorFactory

open class BaseOpMode : CommandOpMode() {
    lateinit var drive: DiffSwerveDrive
    var imu: Imu? = null

    override fun preInit() {
        initDrive()
        telemetry.addLine("Initialized successfully!")
    }

    private fun initDrive() {
        initImu()

        val leftPivot = motorFactory(Motors.MotorType.DRIVE, DRIVE_LEFT_A_NAME, hardwareMap)
        val leftDrive = motorFactory(Motors.MotorType.DRIVE, DRIVE_LEFT_B_NAME, hardwareMap)
        val rightPivot = motorFactory(Motors.MotorType.DRIVE, DRIVE_RIGHT_A_NAME, hardwareMap)
        val rightDrive = motorFactory(Motors.MotorType.DRIVE, DRIVE_RIGHT_B_NAME, hardwareMap)

        drive = DiffSwerveDrive(
            leftPivot to leftDrive,
            rightPivot to rightDrive,
            imu,
            DiffSwerveConstraints(12.0, 60.0, 60.0),
            HEADING_PID,
            TRANSLATIONAL_PID,
            MODULE_PID
        )

        register(drive)
    }

    private fun initImu() {
        imu = Imu(hardwareMap, "imu")

        val res = imu?.autoDetectUpAxis()

        if(res != null)
            telemetry.addLine("imu axis: $res")
        else {
            telemetry.addLine("imu up axis not detected!")

            imu = null
        }
    }
}