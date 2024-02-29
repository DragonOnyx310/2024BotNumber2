// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  public static final TalonFX shooterMotor1 = new TalonFX(Constants.ShooterConstants.shooterMotor1ID);
  public static final TalonFX shooterMotor2 = new TalonFX(Constants.ShooterConstants.shooterMotor2ID);
  public static final CANSparkMax indexer = new CANSparkMax(Constants.ShooterConstants.indexerID, MotorType.kBrushless);
  public static final SparkPIDController indexerPID = indexer.getPIDController();
  public static VelocityDutyCycle shooterVelocity = new VelocityDutyCycle(0); 
  public static TalonFXConfiguration shooterMotor1Config = new TalonFXConfiguration();
  public static TalonFXConfiguration shooterMotor2onfig = new TalonFXConfiguration();
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    startIndexer();
    resetShooter();
  }


  public static void runShooter(double speed){
    //shooterMotor1.set(speed);
    //shooterMotor2.set(-speed);
    shooterMotor1.setControl(shooterVelocity.withVelocity(speed));
    shooterMotor2.setControl(shooterVelocity.withVelocity(-speed));
  }

  public static void runIndexer(double speed){
    indexer.set(speed);
  }

  public static void startIndexer(){
    indexerPID.setP(0.3);
    indexer.setClosedLoopRampRate(0.2);
  }

  public static void resetShooter(){
    shooterMotor1Config.Slot0.kP = 0.01;
    shooterMotor2onfig.Slot0.kP = 0.01;
    shooterMotor1.getConfigurator().apply(shooterMotor1Config);
    shooterMotor2.getConfigurator().apply(shooterMotor2onfig);
    shooterMotor1.setNeutralMode(NeutralModeValue.Coast);
    shooterMotor2.setNeutralMode(NeutralModeValue.Coast); 
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Velocity of Shooter", shooterMotor1.getVelocity().getValueAsDouble()); 
  }
}
