public class WordCorrectOrder {
	public static String output(String[]str)
	 {
	   String mArray="";
	   int ninput=0;
	   String output="";
	   for(int i=0;i<str.length;i++)
	   {
	     if(str[i].length()==3)
	     {
	       char ma[]=str[i].toCharArray();
	       if(ma[1]=='>' && ma[0]!=ma[2])
	       {
	         mArray+=str[i];
	         ninput++;
	       }
	       else
	       {
	         output="Both characters are same or not contain > in middle";
	         break;
	       }
	     }
	     else
	     {
	       output="Each string length !=3";
	       break;
	     } 
	   }
	  String snew="";
	  if(ninput==str.length)
	  {
	    for(String r:str)
	    snew += r;
	    char sch[]=snew.toCharArray();
	    int fcount=0;
	    int lcount=0;
	    for(int i=0;i<snew.length();i+=3)
	    {
	      for(int j=i+3;j<snew.length();j+=3)
	      {
	       if(sch[i]==sch[j])
	       {
	        fcount++;
	       }
	      }
	    }
	    for(int i=2;i<snew.length();i+=3)
	    {
	      for(int j=i+3;j<snew.length();j+=3)
	      {
	       if(sch[i]==sch[j] && sch[i]!='>')
	       {
	        lcount++;
	       }
	      }
	    }
	    if(fcount>0 || lcount>0)
	    {
	      output="Characters are repeats";
	    }
	    else
	    {
	      String news="";
	      for(int i=0;i<snew.length();i++)
	      {
	       int ucount=0;
	       for(int j=i;j<snew.length();j++)
	       {
	        if(sch[i]==sch[j])
	        {
	         ucount++;
	        }
	       } 
	       if(ucount==1 && sch[i]!='>')
	       {
	         news+=sch[i];
	       }
	      }
	      char lch1[]=news.toCharArray();
	      char lch2[]=new char[news.length()];
	      for(int i=0;i<news.length();i++)
	      {
	       int icount=0;
	       for(int j=0;j<snew.length();j+=3)
	       {
	         if(lch1[i]!=sch[j])
	         icount++;
	       }
	       if(icount==news.length()-1)
	       lch2[news.length()-1]=lch1[i];
	      }
	      for(int i=0;i<news.length();i++)
	      {
	       int icount=0;
	       for(int j=2;j<snew.length();j+=3)
	       {
	         if(lch1[i]!=sch[j])
	         icount++;
	       }
	       if(icount==news.length()-1)
	       lch2[0]=lch1[i];
	      }
	      if(lch2[0]==lch2[news.length()-1])
	      {
	    	 output="Repetition of characters in the resultant string";
	     }else {
	     String narr=String.valueOf(lch2);
	     for(int i=0;i<snew.length();i+=3)
	     {
	    	 if(sch[i+1]=='>')
	    	 {
	    		 int kv=narr.indexOf(sch[i]);
	    		 if(kv>=0)
	    		 {
	    			 lch2[kv+1]=sch[i+2];
	    			 narr=String.valueOf(lch2);
	    		 }
	    		 else
	    		 {
	    			 kv=narr.indexOf(sch[i+2]);
	    			 if(kv>0)
	    			 {
	    			 lch2[kv-1]=sch[i];
	    			 narr=String.valueOf(lch2);
	    			 }
	    		 }
	    	 }
	     }
	     output=narr;
	     char check[]=narr.toCharArray();
	     int last=0;
	     for(int i=0;i<narr.length()-1;i++) 
       {
	    	 for(int j=i;j<narr.length()-1;j++) 
         {
	    	  if(check[i]==check[j])
	    	  last++;
	    	 }
	     }
	    }
	  }
	  }
     return output;
	 }
	 public static void main(String args[])
	 {
		String testCase= {"J>A", "A>G", "G>U"};
    System.out.println(WordCorrectOrder.output(testCase));
	 }
	}
