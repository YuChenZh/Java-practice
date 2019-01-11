/**
 * Created by yujingchen on 11/25/17.
 */
//import org.apache.commons.math;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import java.lang.Math;


@RunWith(Theories.class)
public class JunitTestsWithParameters
{
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @DataPoints
    public static int[][] integers()
    {
        return new int[][]{{1, 1}, {2, 4}, {3, 9}, {4, 16}, {5, 25}, {}};
    }

    @DataPoint
    public static int[] input6 = new int[]{6, 36};
    @DataPoint
    public static int[] input7 = new int[]{7, 49};

    @Theory
    public void testSquares(final int[] inputs)
    {
        Assume.assumeTrue(inputs.length == 2);
        Assume.assumeTrue(inputs[0] > 0 && inputs[1] > 0);
        Assert.assertEquals(inputs[1], MathUtils.square(inputs[0]));
    }

    @Theory
    public void testBlankArrays(final int[] inputs)
    {
        Assume.assumeTrue(inputs.length == 0);
        expectedException.expect(ArrayIndexOutOfBoundsException.class);
        Assert.assertEquals(inputs[1], MathUtils.square(inputs[0]));
    }

}
