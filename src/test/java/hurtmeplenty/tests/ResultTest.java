package hurtmeplenty.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultTest extends BaseTest {
    @Test
    public void testVMClassValue() {
        Assert.assertTrue(calculatorPageModel.getVMClass().contains(machineClassValue), "VM class value is incorrect");
    }

    @Test
    public void testInstanceType() {
        Assert.assertTrue(calculatorPageModel.getInstanceType().contains(machineTypeValue), "Instance type is incorrect");
    }

    @Test
    public void testLocalSSDSpace() {
        Assert.assertTrue(calculatorPageModel.getLocalSSD().contains(localSSDValue), "Local SSD space is incorrect");
    }

    @Test
    public void testRegion() {
        Assert.assertTrue(calculatorPageModel.getRegion().contains(dataCenterLocationValue), "Region is incorrect");
    }

    @Test
    public void testCommitmentTerm() {
        Assert.assertTrue(calculatorPageModel.getCommitmentTerm().contains(commitmentUsageValue), "Commitment term year is incorrect");
    }
}
