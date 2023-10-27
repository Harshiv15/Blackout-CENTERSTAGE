package org.firstinspires.ftc.teamcode.util

import com.amarcolini.joos.command.Command
import com.amarcolini.joos.command.CommandGroup
import com.amarcolini.joos.command.SequentialCommand
import com.amarcolini.joos.hardware.drive.DriveComponent

class PreloadSequence(drive: DriveComponent, preloadTraj: TrajEnums.PreloadTrajs): Command() {
    init{
        SequentialCommand().add(
            drive.followTrajectory(preloadTraj.followWith(drive))
        )
    }
}