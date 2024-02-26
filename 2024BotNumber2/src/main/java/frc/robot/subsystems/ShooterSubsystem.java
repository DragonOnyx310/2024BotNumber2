// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  public static final TalonFX shooterMotor1 = new TalonFX(Constants.ShooterConstants.shooterMotor1ID);
  public static final TalonFX shooterMotor2 = new TalonFX(Constants.ShooterConstants.shooterMotor2ID);
  public static final CANSparkMax indexer = new CANSparkMax(1, MotorType.kBrushless);
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {}


  public static void runShooter(double speed){
    shooterMotor1.set(speed);
    shooterMotor2.set(speed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
