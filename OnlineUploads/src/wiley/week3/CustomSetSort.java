package wiley.week3;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class CustomSetSort {
	
	
	public static void main(String[] args) {
		Set<Type> customSet = new TreeSet<>();

		customSet.add(new Type(new Integer(10)));
		customSet.add(new Type(new Integer(4)));
		customSet.add(new Type(new Integer(6)));
		customSet.add(new Type(new Integer(5)));
		customSet.add(new Type(new Integer(2)));
		
		customSet.add(new Type("Atimal"));
		customSet.add(new Type("Animal"));
		customSet.add(new Type("Horse"));
		customSet.add(new Type("Elephant"));
		
		customSet.add(new Type(new User1(6,"AAAAA")));
		customSet.add(new Type(new User1(3,"User3")));
		customSet.add(new Type(new User1(2,"User4")));
		customSet.add(new Type(new User1(1,"User1")));
		customSet.add(new Type(new User1(4,"User2")));
		customSet.add(new Type(new User1(5,"User5")));



		customSet.forEach(System.out::println);
	}
}


class Type implements Comparable<Type>{
    private Object object; // int // string // user -- expected sort : 1,2,Hello,Hi, User{1,"User1"}, User{2,"User2"}

    public Type(){

    }
    public Type(Object object){
        this.object = object;
    }
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "--"+ object +"";
    }

    @Override
    public int hashCode() {
        return object.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//--------------------------------------------------- case 1 ---------------------------------------------------------   
 // case 1: sort : show the integers first then users sorted by user id then strings
    
//    @Override
//    public int compareTo(Type next) {
//        // handle null values at the beginning
//        if(this.object == null || next.object == null){
//            return -1;
//        }
//        
//        if(this.object instanceof Integer){
//        	
//            if(next.object instanceof Integer){
//                int i = (int)next.object;
//                int j = (int)this.object;
//                return j - i;
//            }else if(next.object instanceof String || next.object instanceof User1){
//                return -1;
//            }
//            return 0;
//        }
//        
//        else if(this.object instanceof User1) {
//        	if(next.object instanceof User1) {
//        		User1 u1 = (User1)this.object;
//        		User1 u2 = (User1)next.object;
//        		return u1.getId()-u2.getId();
//        	}
//        	else if(next.object instanceof String)
//        		return -1;
//        	
//        	else if(next.object instanceof Integer)
//        		return 1;
//        	return 0;
//        }
//        
//        else if(this.object instanceof String){
//            if(next.object instanceof String){
//                String str1 = (String)this.object;
//                String str2 = (String)next.object;
//                return str1.compareTo(str2);
//            }else if(next.object instanceof Integer || next.object instanceof User1){
//                return 1;
//            }
//            return 0;
//        }
//
//        return 0;
//    }
//}

//----------------------------------------------------------------------------------------------------------------------

    
 //--------------------------------------------------- case 2 ---------------------------------------------------------   
 // case 2: sort : show me sorted strings then users sorted by user id then integers
    
// @Override
//  public int compareTo(Type next) {
//      // handle null values at the beginning
//      if(this.object == null || next.object == null){
//          return -1;
//      }
//      
//      if(this.object instanceof String){
//    	  
//          if(next.object instanceof String){
//              String str1 = (String)this.object;
//              String str2 = (String)next.object;
//              return str1.compareTo(str2);
//          }else if(next.object instanceof Integer || next.object instanceof User1){
//              return -1;
//          }
//          return 0;
//      }
//       
//      else if(this.object instanceof User1) {
//    	  
//      	if(next.object instanceof User1) {
//      		User1 u1 = (User1)this.object;
//      		User1 u2 = (User1)next.object;
//      		return u1.getName().compareTo(u2.getName());
//      	}
//      	else if(next.object instanceof Integer)
//      		return -1;
//      	
//      	else if(next.object instanceof String)
//      		return 1;
//      	return 0;
//      }
//      
//      else if(this.object instanceof Integer){ 
//          
//     	  if(next.object instanceof Integer){
//               int i = (int)next.object;
//               int j = (int)this.object;
//               return j - i;
//           }else if(next.object instanceof String || next.object instanceof User1){
//               return 1;
//           }
//           return 0;
//       }
//
//      return 0;
//  }
//}

//----------------------------------------------------------------------------------------------------------------------    

//--------------------------------------------------- case 3 ---------------------------------------------------------   
//case 3: sort : show all the objects sorted based on string whether that is username or simple string then integers
   
@Override
 public int compareTo(Type next) {
     // handle null values at the beginning
     if(this.object == null || next.object == null){
         return -1;
     }
     
     if(this.object instanceof String){
   	  
         if(next.object instanceof String){
             String str1 = (String)this.object;
             String str2 = (String)next.object;
             return str1.compareTo(str2);
         }
         else if(next.object instanceof User1) {
        	 String str = (String)this.object;
      		User1 u = (User1)next.object;
      		return str.compareTo(u.getName());
      	}
         else if(next.object instanceof Integer){
             return -1;
         }
         return 0;
     }
      
     else if(this.object instanceof User1) {
   	  
     	if(next.object instanceof User1) {
     		User1 u1 = (User1)this.object;
     		User1 u2 = (User1)next.object;
     		return u1.getName().compareTo(u2.getName());
     	}
     	else if(next.object instanceof String) {
     		String str = (String)next.object;
     		User1 u = (User1)this.object;
     		return u.getName().compareTo(str);
     	}
   
     	else if(next.object instanceof Integer)
     		return -1;

     	return 0;
     }
     
     else if(this.object instanceof Integer){ 
         
    	  if(next.object instanceof Integer){
              int i = (int)next.object;
              int j = (int)this.object;
              return j - i;
          }else if(next.object instanceof String || next.object instanceof User1){
              return 1;
          }
          return 0;
      }

     return 0;
 }
}

//----------------------------------------------------------------------------------------------------------------------    

class User1 {
    private int id;
    private String name;

    public User1(){

    }

    public User1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "--"+ id + " : " + name +"";
    }
    
    @Override
    public int hashCode() {
        return this.getId();
    }
}