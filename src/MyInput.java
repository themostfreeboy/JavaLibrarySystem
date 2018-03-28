// MyInput.java: Contain the methods for reading int, double, and string values from the keyboard
import java.io.*;
public class MyInput
{
    // Read a string from the keyboard
    public static String readString()
    {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);

          // Declare and initialize the string
          String string = " ";

          // Get the string from the keyboard
          try
          {
               string = br.readLine();
          }
          catch (IOException ex)
          {
               System.out.println(ex);
          }

          // Return the string obtained from the keyboard
          return string;
    }

    // Read an int value from the keyboard
    public static int readInt()
    {
    	  boolean State=false;//标记所读取的字符串是否为整数型字符串
    	  String StringTemp=new String();
    	  StringTemp=readString();
    	  while(!State)
    	  {
    		  for(int i=0;i<StringTemp.length();i++)
        	  {
        		  if(!(StringTemp.charAt(i)>='0'&&StringTemp.charAt(i)<='9'))//如果字符串的某一位不是0~9
        		  {
        			  System.out.println("你输入的数据类型有误，请重新输入");
        			  State=false;
        			  StringTemp=readString();
        			  break;
        		  }
        		  State=true;
        	  }
    	  }
          return Integer.parseInt(StringTemp);
    }

    // Read a double value from the keyboard
    public static double readDouble()
    {
         return Double.parseDouble(readString());
    }

    // Read a byte value from the keyboard
    public static double readByte()
    {
         return Byte.parseByte(readString());
    }

    // Read a short value from the keyboard
    public static double readShort()
    {
         return Short.parseShort(readString());
    }

    // Read a long value from the keyboard
    public static double readLong()
    {
         return Long.parseLong(readString());
    }

    // Read a float value from the keyboard
    public static double readFloat()
    {
         return Float.parseFloat(readString());
    }
}