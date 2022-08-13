// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NeoTestSubsystem extends SubsystemBase {
  /** Creates a new NeoTestSubsystem. */

  private CANSparkMax motor;
  private CANEncoder encoder;

  public NeoTestSubsystem() {
    motor = new CANSparkMax(Constants.NEO_CAN_ID, Constants.MOTOR_TYPE);
    encoder = motor.getEncoder();

    motor.restoreFactoryDefaults();
    motor.setSmartCurrentLimit(Constants.CURRENT_LIMIT);
    motor.setInverted(Constants.INVERTED);
    motor.burnFlash();
    motor.setIdleMode(Constants.IDLE_MODE);

  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("encoder velocity", encoder.getVelocity());
  }

  public void start() {
    motor.setVoltage(Constants.VOLTAGE);
  }

  public void stop() {
    motor.setVoltage(0);
  }
}
