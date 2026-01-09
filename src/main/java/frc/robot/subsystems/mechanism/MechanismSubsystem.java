package frc.robot.subsystems.mechanism;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class MechanismSubsystem extends SubsystemBase {
    private final MechanismIOHardware m_IO = new MechanismIOHardware();

    public MechanismSubsystem() {
        m_IO.resetPosition();
    }

    public Command runMechanismOff() {
        return new RunCommand(
            () -> m_IO.setVoltage(0), 
            this
        );
    }

    @Override
    public void periodic() {
        SmartDashboard.putData("mechanism/subsystem", this);
        SmartDashboard.putNumber("mechanism/position", m_IO.getPosition());
        SmartDashboard.putNumber("mechanism/current", m_IO.getCurrent());
    }

}