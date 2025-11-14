// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final SendableChooser<Command> m_autoChooser; // Sendable chooser that holds the autos

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  // Subsystems
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  /** The container for the robot. Contains subsystems and commands. */
  public RobotContainer() {
    // Configure trigger bindings
    configureBindings();

    // Configure auto builder
    createNamedCommands();
    m_autoChooser = AutoBuilder.buildAutoChooser();
    SmartDashboard.putData("Auto Chooser", m_autoChooser);

    // Data logging
    DataLogManager.start(); // Starts recording to data log
    DriverStation.startDataLog(DataLogManager.getLog()); // Record both DS control and joystick data
    DriverStation.silenceJoystickConnectionWarning(true); // Turn off unplugged joystick errors
  }

  /**
   * Define trigger -> command mappings 
   */
  private void configureBindings() {
    // Add bindings here
  }

  /**
   * Define named commands for autonomous paths
   */
  private void createNamedCommands() {
    // Add named commands here
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autoChooser.getSelected();
  }
}
