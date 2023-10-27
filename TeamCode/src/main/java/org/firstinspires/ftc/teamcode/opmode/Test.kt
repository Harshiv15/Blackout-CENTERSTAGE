package org.firstinspires.ftc.teamcode.opmode

import com.acmerobotics.roadrunner.Pose2d
import com.acmerobotics.roadrunner.TrajectoryBuilder
import com.acmerobotics.roadrunner.ftc.runBlocking
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.MecanumDrive
import org.firstinspires.ftc.teamcode.MecanumDrive.FollowTrajectoryAction

class Test: LinearOpMode() {
    lateinit var mecanumDrive: MecanumDrive
    override fun runOpMode() {
        mecanumDrive = MecanumDrive(hardwareMap, Pose2d(0.0, 0.0, 0.0))
        mecanumDrive.actionBuilder(Pose2d(0.0, 0.0, 0.0)).beginEndVel
    }
}