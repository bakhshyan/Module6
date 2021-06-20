package hurtmeplenty.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ResultTest extends BaseTest {
    @Test
    public void testVMClassValue() {
        Assert.assertEquals(calculatorPageModel.getVMClass(), "VM class: regular", "VM class value is incorrect");
    }

    @Test
    public void testInstanceType() {
        Assert.assertEquals(calculatorPageModel.getInstanceType(), "Instance type: e2-standard-2", "Instance type is incorrect");
    }

    @Test
    public void testLocalSSDSpace() {
        Assert.assertEquals(calculatorPageModel.getLocalSSD(), "Total available local SSD space 24x375 GiB", "Local SSD space is incorrect");
    }

    @Test
    public void testRegion() {
        Assert.assertEquals(calculatorPageModel.getRegion(), "Region: Iowa", "Region is incorrect");
    }

    @Test
    public void testCommitmentTerm() {
        Assert.assertEquals(calculatorPageModel.getCommitmnetTerm(), "Commitment term: 1 Year", "Commitment term year is incorrect");
    }
}
