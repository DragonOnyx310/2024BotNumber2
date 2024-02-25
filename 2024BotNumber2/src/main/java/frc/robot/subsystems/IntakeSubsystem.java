// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  public static final TalonFX intakeMotor1 = new TalonFX(Constants.IntakeConstants.intakeMotor1ID);
  public static final TalonFX intakeMotor2 = new TalonFX(Constants.IntakeConstants.intakeMotor2ID);
  public IntakeSubsystem() {}

  public static void runIntake(double speed){
    intakeMotor1.set(-speed);
    intakeMotor2.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
