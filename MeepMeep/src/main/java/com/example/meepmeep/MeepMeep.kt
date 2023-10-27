package com.example.meepmeep

import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.noahbres.meepmeep.MeepMeep
import com.noahbres.meepmeep.MeepMeep.Background
import com.noahbres.meepmeep.core.colorscheme.ColorScheme
import com.noahbres.meepmeep.roadrunner.Constraints
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder
import com.noahbres.meepmeep.roadrunner.DriveShim
import java.awt.Color
import java.awt.Color.BLACK
import java.awt.Color.BLUE
import java.awt.Color.ORANGE
import java.awt.Color.RED
import java.awt.Color.WHITE
import java.lang.Math.toRadians

object MeepMeep {
    @JvmStatic fun main(args: Array<String>) {
        val meepMeep = MeepMeep(800)

        val constraints = Constraints(60.0, 60.0, toRadians(180.0), toRadians(180.0), 15.0)
        val scheme = object : ColorScheme() {
            override val AXIS_HOVER_OPACITY: Double
                get() = 1.0
            override val AXIS_NORMAL_OPACITY: Double
                get() = 0.5
            override val AXIS_X_COLOR: Color
                get() = WHITE
            override val AXIS_Y_COLOR: Color
                get() = WHITE
            override val BOT_BODY_COLOR: Color
                get() = BLACK
            override val BOT_DIRECTION_COLOR: Color
                get() = WHITE
            override val BOT_WHEEL_COLOR: Color
                get() = BLUE
            override val TRAJCETORY_PATH_COLOR: Color
                get() = ORANGE
            override val TRAJECTORY_MARKER_COLOR: Color
                get() = RED
            override val TRAJECTORY_SLIDER_BG: Color
                get() = WHITE
            override val TRAJECTORY_SLIDER_FG: Color
                get() = RED
            override val TRAJECTORY_TEXT_COLOR: Color
                get() = BLACK
            override val TRAJECTORY_TURN_COLOR: Color
                get() = BLACK
            override val UI_MAIN_BG: Color
                get() = BLUE
            override val isDark: Boolean
                get() = true

        }
        val (dimW, dimH) = 15.0 to 15.0

        //TODO BCL *
        val blueCloseLeft =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            12.0,
                            61.0,
                            toRadians(270.0)
                        )
                    )
                        .strafeLeft(0.1)
                        .splineToConstantHeading(Vector2d(23.0, 34.0), toRadians(270.0))
                        .lineToSplineHeading(Pose2d(52.0, 41.0, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, 20.0))
                        .splineToSplineHeading(Pose2d(20.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(25.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, 35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, 20.0))
                        .splineToSplineHeading(Pose2d(20.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(87.0)
                        .splineToConstantHeading(Vector2d(52.0, 29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO RCL *
        val redCloseLeft =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            12.0,
                            -61.0,
                            toRadians(90.0)
                        )
                    )
                        .splineTo(Vector2d(8.0, -29.0), toRadians(180.0))
                        .lineTo(Vector2d(52.0, -29.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, -11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, -41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        //.splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, -35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO BCM *
        val blueCloseMid =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            12.0,
                            61.0,
                            toRadians(270.0)
                        )
                    )
                        .forward(30.0)
                        .back(0.1)
                        .splineToSplineHeading(Pose2d(52.0, 35.0, toRadians(180.0)), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, 20.0))
                        .splineToSplineHeading(Pose2d(20.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(25.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, 41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, 20.0))
                        .splineToSplineHeading(Pose2d(20.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(87.0)
                        .splineToConstantHeading(Vector2d(52.0, 29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO RCM *
        val redCloseMid =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            12.0,
                            -61.0,
                            toRadians(90.0)
                        )
                    )
                        .forward(30.0)
                        .back(0.1)
                        .splineToSplineHeading(Pose2d(52.0, -35.0, toRadians(180.0)), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, -20.0))
                        .splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(25.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, -41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, -20.0))
                        .splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(87.0)
                        .splineToConstantHeading(Vector2d(52.0, -29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO BCR *
        val blueCloseRight =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            12.0,
                            61.0,
                            toRadians(270.0)
                        )
                    )
                        .splineTo(Vector2d(8.0, 29.0), toRadians(180.0))
                        .lineTo(Vector2d(52.0, 29.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, 11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, 41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        //.splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, 35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO RCR *
        val redCloseRight =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            12.0,
                            -61.0,
                            toRadians(90.0)
                        )
                    )
                        .strafeRight(0.1)
                        .splineToConstantHeading(Vector2d(23.0, -34.0), toRadians(90.0))
                        .lineToSplineHeading(Pose2d(52.0, -41.0, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, -20.0))
                        .splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(25.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, -35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .lineTo(Vector2d(38.0, -20.0))
                        .splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(87.0)
                        .splineToConstantHeading(Vector2d(52.0, -29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO BFL *
        val blueFarLeft =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            -36.0,
                            61.0,
                            toRadians(270.0)
                        )
                    )
                        .splineTo(Vector2d(-32.0, 29.0), toRadians(0.0))
                        .back(0.1)
                        .splineTo(Vector2d(-32.0, 11.5), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(0.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .back(38.0)
                        .splineToConstantHeading(Vector2d(52.0, 41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .setReversed(false)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, 11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, 35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        //.splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, 29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO RFL *
        val redFarLeft =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            -36.0,
                            -61.0,
                            toRadians(90.0)
                        )
                    )
                        .strafeLeft(0.1)
                        .splineToConstantHeading(Vector2d(-46.0, -41.0), toRadians(90.0))
                        .lineToSplineHeading(Pose2d(-38.0, -46.0, toRadians(180.0)))
                        .splineToConstantHeading(Vector2d(-24.0, -11.5), toRadians(0.0))
                        .back(62.0)
                        .splineToConstantHeading(Vector2d(52.0, -29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, -11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, -41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        //.splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, -35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO BFM *
        val blueFarMid =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            -36.0,
                            61.0,
                            toRadians(270.0)
                        )
                    )
                        .forward(30.0)
                        .back(5.0)
                        .lineToSplineHeading(Pose2d(-16.0, 36.0, toRadians(180.0)))
                        .splineToConstantHeading(Vector2d(-4.0, 11.5), toRadians(0.0))
                        .back(41.0)
                        .splineToConstantHeading(Vector2d(52.0, 35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, 11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, 41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, 29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO RFM
        val redFarMid =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            -36.0,
                            -61.0,
                            toRadians(90.0)
                        )
                    )
                        .forward(30.0)
                        .back(5.0)
                        .lineToSplineHeading(Pose2d(-16.0, -36.0, toRadians(180.0)))
                        .splineToConstantHeading(Vector2d(-4.0, -11.5), toRadians(0.0))
                        .back(41.0)
                        .splineToConstantHeading(Vector2d(52.0, -35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, -11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, -41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, -29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO BFR *
        val blueFarRight =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            -36.0,
                            61.0,
                            toRadians(270.0)
                        )
                    )
                        .strafeRight(0.1)
                        .splineToConstantHeading(Vector2d(-46.0, 41.0), toRadians(270.0))
                        .lineToSplineHeading(Pose2d(-38.0, 46.0, toRadians(180.0)))
                        .splineToConstantHeading(Vector2d(-24.0, 11.5), toRadians(0.0))
                        .back(62.0)
                        .splineToConstantHeading(Vector2d(52.0, 29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, 11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, 11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, 41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, 11.5), toRadians(180.0))
                        //.splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, 11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, 35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        //TODO RFR
        val redFarRight =
            DefaultBotBuilder(meepMeep).setConstraints(constraints).setDimensions(dimW, dimH).setColorScheme(scheme)
                .followTrajectorySequence { drive: DriveShim ->
                    drive.trajectorySequenceBuilder(
                        Pose2d(
                            -36.0,
                            -61.0,
                            toRadians(90.0)
                        )
                    )
                        .splineTo(Vector2d(-32.0, -29.0), toRadians(0.0))
                        .back(0.1)
                        .splineTo(Vector2d(-32.0, -11.5), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(0.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .back(38.0)
                        .splineToConstantHeading(Vector2d(52.0, -41.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .setReversed(false)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-12.0, -11.5, toRadians(0.0)), toRadians(180.0))
                        .splineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .splineToSplineHeading(Pose2d(-10.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToSplineHeading(Pose2d(38.0, -11.5, toRadians(180.0)), toRadians(0.0))
                        .splineToConstantHeading(Vector2d(52.0, -35.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1.0)
                        .splineToConstantHeading(Vector2d(38.0, -11.5), toRadians(180.0))
                        //.splineToSplineHeading(Pose2d(20.0, -11.5, toRadians(180.0)), toRadians(180.0))
                        .lineToSplineHeading(Pose2d(-62.0, -11.5, toRadians(180.0)))
                        .addDisplacementMarker { }
                        .waitSeconds(1.0)
                        .setReversed(true)
                        .back(100.0)
                        .splineToConstantHeading(Vector2d(52.0, -29.0), toRadians(0.0))
                        .addDisplacementMarker { }
                        .waitSeconds(2.0)
                        .forward(1e-4)
                        .build()
                }

        meepMeep.setBackground(Background.FIELD_CENTERSTAGE_JUICE_DARK)
            .setDarkMode(true)
            .setBackgroundAlpha(0.95f)

            // close 1
            .addEntity(redCloseRight)
            .addEntity(blueCloseLeft)
            // close 2
            .addEntity(redCloseMid)
            .addEntity(blueCloseMid)
            // close 3
            .addEntity(redCloseLeft)
            .addEntity(blueCloseRight)
            // far 1
            .addEntity(redFarRight)
            .addEntity(blueFarLeft)
            // far 2
            .addEntity(redFarMid)
            .addEntity(blueFarMid)
            // far 3
            .addEntity(redFarLeft)
            .addEntity(blueFarRight)

            .start()
    }
}