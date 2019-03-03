//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{

		int[] hello = new int[size];


		for(int i = 0; i< size; i++){
			hello[i] = (int) Math.random() * 10 + 1;

		}
		return hello;
	}
	public static int[] shiftEm(int[] array)
	{
		int[] newArray = new int[array.length];
		int numberOfSevens = 0;
		for(int i = 0; i<array.length; i++){
			if(array[i] == 7){
				numberOfSevens++;
			}
		}
		int c = numberOfSevens-1;

		for(int i = 0; i<numberOfSevens; i++){
			newArray[i] = 7;
		}
		for(int i = 0; i<newArray.length; i++){
			if(array[i] != 7){
				newArray[c] = array[i];
				c++;
			}
		}
		return newArray;
	}
}