package org.firstinspires.ftc.teamcode.util

import com.amarcolini.joos.command.Command
import com.amarcolini.joos.drive.Drive
import com.amarcolini.joos.hardware.drive.DriveComponent
import com.amarcolini.joos.trajectory.Trajectory
import com.amarcolini.joos.trajectory.TrajectoryBuilder


class StackTraj(drive: DriveComponent, alliance: TrajEnums.Alliance): Command() {
    private var drive: DriveComponent
    private var alliance: TrajEnums.Alliance
    private lateinit var stackTraj: Trajectory

    init {
        this.drive = drive
        this.alliance = alliance
    }

    override fun init() {
        drive.followTrajectory(stackTraj)
    }

    override fun execute() {
        drive.update()
    }

    override fun isFinished(): Boolean {
        return drive.getCurrentTrajectory() == null
    }
}