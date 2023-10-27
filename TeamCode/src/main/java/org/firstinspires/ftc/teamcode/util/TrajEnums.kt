package org.firstinspires.ftc.teamcode.util

import com.amarcolini.joos.geometry.Pose2d
import com.amarcolini.joos.geometry.Vector2d
import com.amarcolini.joos.hardware.drive.DriveComponent
import com.amarcolini.joos.trajectory.Trajectory
import com.amarcolini.joos.trajectory.TrajectoryBuilder
import com.amarcolini.joos.util.deg

class TrajEnums {
    enum class Alliance {
        BLUE,
        RED;
    }

    private enum class Side {
        CLOSE,
        FAR;
    }

    private enum class RandomLoc {
        LEFT,
        MID,
        RIGHT;
    }

    enum class PreloadTrajs(
        private val alliance: Alliance,
        private val side: Side,
        randomLoc: RandomLoc
    ) {
        BLUE_CLOSE_LEFT(Alliance.BLUE, Side.CLOSE, RandomLoc.LEFT),
        RED_CLOSE_LEFT(Alliance.RED, Side.CLOSE, RandomLoc.LEFT),
        BLUE_CLOSE_MID(Alliance.BLUE, Side.CLOSE, RandomLoc.MID),
        RED_CLOSE_MID(Alliance.RED, Side.CLOSE, RandomLoc.MID),
        BLUE_CLOSE_RIGHT(Alliance.BLUE, Side.CLOSE, RandomLoc.RIGHT),
        RED_CLOSE_RIGHT(Alliance.RED, Side.CLOSE, RandomLoc.RIGHT),
        BLUE_FAR_LEFT(Alliance.BLUE, Side.FAR, RandomLoc.LEFT),
        RED_FAR_LEFT(Alliance.RED, Side.FAR, RandomLoc.LEFT),
        BLUE_FAR_MID(Alliance.BLUE, Side.FAR, RandomLoc.MID),
        RED_FAR_MID(Alliance.RED, Side.FAR, RandomLoc.MID),
        BLUE_FAR_RIGHT(Alliance.BLUE, Side.FAR, RandomLoc.RIGHT),
        RED_FAR_RIGHT(Alliance.RED, Side.FAR, RandomLoc.RIGHT);

        // this can't work... can it?
        fun followWith(drive: DriveComponent): Trajectory {
            val trajBuilder = TrajectoryBuilder(
                drive.poseEstimate,
                if (this.alliance == Alliance.RED) 90.0.deg else 270.0.deg,
                drive.constraints
            )

            return when (this) {
                BLUE_CLOSE_LEFT -> {
                    trajBuilder
                        .strafeLeft(0.1)
                        .splineToConstantHeading(Vector2d(23.0, 34.0), (270.0).deg)
                        .lineToSplineHeading(Pose2d(52.0, 41.0, (180.0).deg))
                        .build()
                }

                RED_CLOSE_LEFT -> {
                    trajBuilder
                        .splineTo(Vector2d(8.0, -29.0), (180.0).deg)
                        .lineTo(Vector2d(52.0, -29.0))
                        .build()
                }

                BLUE_CLOSE_MID -> {
                    trajBuilder
                        .forward(30.0)
                        .back(0.1)
                        .splineToSplineHeading(Pose2d(52.0, 35.0, (180.0).deg), (0.0).deg)
                        .build()
                }

                RED_CLOSE_MID -> {
                    trajBuilder
                        .forward(30.0)
                        .back(0.1)
                        .splineToSplineHeading(Pose2d(52.0, -35.0, (180.0).deg), (0.0).deg)
                        .build()
                }

                BLUE_CLOSE_RIGHT -> {
                    trajBuilder
                        .splineTo(Vector2d(8.0, 29.0), (180.0).deg)
                        .lineTo(Vector2d(52.0, 29.0))
                        .build()
                }

                RED_CLOSE_RIGHT -> {
                    trajBuilder
                        .strafeRight(0.1)
                        .splineToConstantHeading(Vector2d(23.0, -34.0), (90.0).deg)
                        .lineToSplineHeading(Pose2d(52.0, -41.0, (180.0).deg))
                        .build()
                }

                BLUE_FAR_LEFT -> {
                    trajBuilder
                        .splineTo(Vector2d(-32.0, 29.0), (0.0).deg)
                        .back(0.1)
                        .splineTo(Vector2d(-32.0, 11.5), (0.0).deg)
                        .splineToSplineHeading(Pose2d(0.0, 11.5, (180.0).deg), (0.0))
                        .back(38.0)
                        .splineToConstantHeading(Vector2d(52.0, 41.0), (0.0).deg)
                        .build()
                }

                RED_FAR_LEFT -> {
                    trajBuilder
                        .strafeLeft(0.1)
                        .splineToConstantHeading(Vector2d(-46.0, -41.0), (90.0).deg)
                        .lineToSplineHeading(Pose2d(-38.0, -46.0, (180.0).deg))
                        .splineToConstantHeading(Vector2d(-24.0, -11.5), (0.0).deg)
                        .back(62.0)
                        .splineToConstantHeading(Vector2d(52.0, -29.0), (0.0).deg)
                        .build()
                }

                BLUE_FAR_MID -> {
                    trajBuilder
                        .forward(30.0)
                        .back(5.0)
                        .lineToSplineHeading(Pose2d(-16.0, 36.0, (180.0).deg))
                        .splineToConstantHeading(Vector2d(-4.0, 11.5), (0.0).deg)
                        .back(41.0)
                        .splineToConstantHeading(Vector2d(52.0, 35.0), (0.0).deg)
                        .build()
                }

                RED_FAR_MID -> {
                    trajBuilder
                        .forward(30.0)
                        .back(5.0)
                        .lineToSplineHeading(Pose2d(-16.0, -36.0, (180.0).deg))
                        .splineToConstantHeading(Vector2d(-4.0, -11.5), (0.0).deg)
                        .back(41.0)
                        .splineToConstantHeading(Vector2d(52.0, -35.0), (0.0).deg)
                        .build()
                }

                BLUE_FAR_RIGHT -> {
                    trajBuilder
                        .strafeRight(0.1)
                        .splineToConstantHeading(Vector2d(-46.0, 41.0), (270.0).deg)
                        .lineToSplineHeading(Pose2d(-38.0, 46.0, (180.0).deg))
                        .splineToConstantHeading(Vector2d(-24.0, 11.5), (0.0).deg)
                        .back(62.0)
                        .splineToConstantHeading(Vector2d(52.0, 29.0), (0.0).deg)
                        .build()
                }

                RED_FAR_RIGHT -> {
                    trajBuilder
                        .splineTo(Vector2d(-32.0, -29.0), (0.0).deg)
                        .back(0.1)
                        .splineTo(Vector2d(-32.0, -11.5), (0.0).deg)
                        .splineToSplineHeading(Pose2d(0.0, -11.5, (180.0).deg), (0.0).deg)
                        .back(38.0)
                        .splineToConstantHeading(Vector2d(52.0, -41.0), (0.0).deg)
                        .build()
                }
            }
        }
    }
}
