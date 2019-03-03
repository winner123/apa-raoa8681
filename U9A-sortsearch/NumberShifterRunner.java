//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
		NumberShifter ns = new NumberShifter();
		System.out.println(ns.shiftEm(ns.makeLucky7Array(10)));
		System.out.println(ns.shiftEm(ns.makeLucky7Array(10)));

	}
}



