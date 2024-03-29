// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class RunShooter extends Command {
  private ShooterSubsystem mShooterSubsystem = new ShooterSubsystem();
  /** Creates a new RunShooter. */
  public RunShooter(ShooterSubsystem mShooterSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.mShooterSubsystem = mShooterSubsystem;
    addRequirements(mShooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.trigger(RobotContainer.driver, 3).getAsBoolean() == true){
      ShooterSubsystem.runShooter(70);
    }else if(RobotContainer.trigger(RobotContainer.driver, 2).getAsBoolean() == true){
      ShooterSubsystem.runShooter(-20);
    }else{
      ShooterSubsystem.runShooter(0);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    ShooterSubsystem.runShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
