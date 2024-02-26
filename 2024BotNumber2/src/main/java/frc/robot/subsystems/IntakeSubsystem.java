// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  public static final TalonFX intakeMotor1 = new TalonFX(Constants.IntakeConstants.intakeMotor1ID);
  public static final TalonFX intakeMotor2 = new TalonFX(Constants.IntakeConstants.intakeMotor2ID);
  public static final TalonFXConfiguration intakeMotor1config = new TalonFXConfiguration();
  public static final TalonFXConfiguration intakeMotor2config = new TalonFXConfiguration();
  public IntakeSubsystem() {
    resetIntake();
  }

  public static void resetIntake(){
    intakeMotor1config.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.5;
    intakeMotor2config.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.5;
    intakeMotor1.getConfigurator().apply(intakeMotor1config);
    intakeMotor2.getConfigurator().apply(intakeMotor2config);
  }

  public static void runIntake(double speed){
    intakeMotor1.set(-speed);
    intakeMotor2.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("intakeMotor1 Voltage", intakeMotor1.getMotorVoltage().getValueAsDouble());
    SmartDashboard.putNumber("intakeMotor2 Voltage", intakeMotor2.getMotorVoltage().getValueAsDouble());
    SmartDashboard.putNumber("intakeMotor1 Current", intakeMotor1.getSupplyCurrent().getValueAsDouble());
    SmartDashboard.putNumber("intakeMotor2 Current", intakeMotor2.getSupplyCurrent().getValueAsDouble());
    SmartDashboard.putNumber("IntakeMotor1 temp", intakeMotor1.getDeviceTemp().getValueAsDouble());
    SmartDashboard.putNumber("IntakeMotor2 temp", intakeMotor2.getDeviceTemp().getValueAsDouble());
  }
}
