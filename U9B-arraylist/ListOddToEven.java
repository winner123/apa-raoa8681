//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
  public static int go( List<Integer> ray )
  {
    int oddIndex = -1;
    int evenIndex = -1;
    for(int i = 0; i<ray.size(); i++){
      if(ray.get(i) % 2 == 1){
        oddIndex = i;
        break;
      }

    }
    for(int i = 0; i<ray.size(); i++){
      if(ray.get(i) % 2 == 0 && i > oddIndex){
        evenIndex = i;
      }
    }
    if(oddIndex == -1 || evenIndex == -1){
      return -1;
    }
    return evenIndex- oddIndex;

  }
}
