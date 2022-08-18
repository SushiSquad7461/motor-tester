// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NeoTestSubsystem extends SubsystemBase {
  /** Creates a new NeoTestSubsystem. */

  private CANSparkMax drive;
  private CANSparkMax turn;
  private CANCoder canCoder;

  public NeoTestSubsystem() {
    drive = new CANSparkMax(Constants.DRIVE_MOTOR_ID, Constants.MOTOR_TYPE);
    turn = new CANSparkMax(Constants.TURN_MOTOR_ID, Constants.MOTOR_TYPE);
    canCoder = new CANCoder(Constants.CANCODER_ID);

    drive.restoreFactoryDefaults();
    drive.setSmartCurrentLimit(Constants.CURRENT_LIMIT);
    drive.setInverted(Constants.INVERTED);
    drive.burnFlash();
    drive.setIdleMode(Constants.IDLE_MODE);

    turn.restoreFactoryDefaults();
    turn.setSmartCurrentLimit(Constants.CURRENT_LIMIT);
    turn.setInverted(Constants.INVERTED);
    turn.burnFlash();
    turn.setIdleMode(Constants.IDLE_MODE);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("velocity", canCoder.getPosition());
    drive.setVoltage(Constants.VOLTAGE);
    turn.setVoltage(Constants.VOLTAGE);
  }

  public void start() {
    drive.setVoltage(Constants.VOLTAGE);
    turn.setVoltage(Constants.VOLTAGE);
  }

  public void stop() {
    drive.setVoltage(0);
    turn.setVoltage(0);
  }
}
