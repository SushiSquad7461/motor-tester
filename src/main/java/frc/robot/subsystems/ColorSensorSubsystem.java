// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;

public class ColorSensorSubsystem extends SubsystemBase {
  /** Creates a new colorSensorSubsystem. */

  private final I2C.Port i2cPort;
  private final ColorSensorV3 colorSensor;

  public ColorSensorSubsystem() {
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void read() {
    Color detectedColor = colorSensor.getColor();
    int proximity = colorSensor.getProximity();
    double IR = colorSensor.getIR();

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);
    SmartDashboard.putNumber("Proximity", proximity);
  }
}
