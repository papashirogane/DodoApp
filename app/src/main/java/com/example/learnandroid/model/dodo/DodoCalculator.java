package com.example.learnandroid.model.dodo;

/**
 *  Calculates dodo max speed when given mass.
 *
 *  INPUTS:
 *      Dodo mass (kg)
 *  CALCULATED VARIABLES:
 *      Max Speed
 *          LimbLengthVar
 *          Dp
 *  KNOWN VARIABLES:
 *      Duty factor = 0.4 (borrowed from kiwi/rhea in Bipedal locomotion in ratites)
 *      Mathematical relationship between Dp and LimbLengthVar (calculated from rhea max speed range and mass range in Terror Birds).
 *      All other inputs (given by Blanco 2003).
 *
 *  Notes:
 *      Dodo femur:tibiotarsus:metatarsus ratio is 30:44:26 (MORPHOLOGY).
 *      Ratio most similar to Archaeopteryx and somewhat close to kiwi (Figures 3, 4, and 6, Bipedalism, Flight, and the Evolution of Theropod Locomotor Diversity).
 *      Since I don't have Archaeopteryx duty factor information, I will borrow that of the kiwi at ~0.4 (Figure 2, Bipedal locomotion in ratites (Paleognatiform): Examples of cursorial birds).
 *      Since this duty factor is close to the rhea value, I will borrow the info of the Rhea americana (Terror Birds on the Run).
 *      Using max speed and mass ranges of Rhea americana, I establish the mathematical relationship between Dp and LimbLengthVar.
 *      I use two equations from Blanco 2003:
 *          1   Max speed is inputted to find Dp.
 *          2   Mass is inputted to find LimbLengthVar.
 *      Finally, LimbLengthVar / Dp finds the relationship.
 */
public class DodoCalculator {
    private Dodo dodo;
    private double maxSpeed;                                         // in metres per second
    private final double massKg;                                       // in kg
    private double limbLengthVar;                                    // limb effective length variation
    private double Dp;                                               // distance travelled by centre of mass

    private final static double a = 0.60;                            // percent body mass supported by hind legs
    private final static double g = 9.8;                             // acceleration of gravity in metres per seconds squared
    private final static double k = 0.715;                           // spring constant k in M^0.67
    private final static double f = 4.48;                            // stride frequency in M^-0.14
    private final static double LimbLengthVarPerDp = 300;            // hand calculated
    private final static double dutyFactor = 0.4;                    // Fraction of stride period where foot is in contact with ground (Bipedal locomotion in ratites)

    public DodoCalculator(Dodo dodo) {
        this.dodo = dodo;
        this.massKg = dodo.getMassKg();

        calcLimbLengthVar();
        calcDp();
        calcMaxSpeed();
        dodo.maxSpeed = this.maxSpeed;
    }

    public void calcLimbLengthVar() {
        limbLengthVar = ( Math.PI * a * massKg * g ) // (pi * percent * kg * M) / (4 * 0.4 * 0.715)
                / ( 4 * dutyFactor * k );      // (2003)
    }

    public void calcDp() {
        Dp = limbLengthVar / LimbLengthVarPerDp;
    }

    public void calcMaxSpeed() {
        maxSpeed = f * ( Dp / dutyFactor );
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}