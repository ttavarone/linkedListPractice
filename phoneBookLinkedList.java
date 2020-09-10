public class LinkedListPhonebook {
    
    static class LinkedList {
        static class Node{
            String name; 
            int number;
            Node next; 
            Node(String nameIn, int numberIn) 
            { 
                name = nameIn;
                number = numberIn;
                next = null;
            }
        }
        
        private Node[] pb = new Node[26];
        LinkedList(){
            for(int i = 0; i < pb.length; i++){
                pb[i] = new Node("a", 0);
            }
        }
        
        //method to add a new contact
        String addContact(String name, int number){
            name = name.toLowerCase();
            if(name.length() == 0){
                return "No input/Invalid entry.";
            } 
            else {
                if(name.length() >= 1){
                    char firstLetter = name.charAt(0);
                    int charVal = findCharVal(firstLetter);
                    Node newContact = new Node(name, number);
                    
                    /* Now go to the letter in the array by getting the int
                     value of the char (firstLetter); then add the new node
                     as the next value in the array of nodes */
                    Node curPos = pb[charVal];
                    while(curPos.next != null){
                        curPos = curPos.next; 
                    }
                    
                    //now finally set the current Node.next to the new value
                    curPos.next = newContact;
                }
            }
            return "Successfully added "+name;
        }
        
        //finds a contact and prints out the name and number
        String findContact(String name){
            name = name.toLowerCase();
            char firstLetter = name.charAt(0);
            int charVal = findCharVal(firstLetter);
            Node curPos = pb[charVal];
            while(curPos != null){
                if(curPos.name.equals(name)){
                    return "Name: "+curPos.name+"\n"+"Number: "+curPos.number+"\n";
                }
                curPos = curPos.next;
            }
            return "Not found.";
        }
        
        //method to find the int value of a char
        int findCharVal(char letter){
            return Character.getNumericValue(letter);
        }
    } 
  
  
//******************************* MAIN METHOD *******************************
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkedList phoneBook = new LinkedList(); 
        
        //System.out.println(phoneBook.addContact("Angelina", 12345));
        
        System.out.println(phoneBook.addContact("Tucker", 54321));
    } 
}   
