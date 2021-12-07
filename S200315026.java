
package s200315026;

import java.util.Scanner;

public class S200315026 {

    //-----------------------------------------------------------------------------------------------
    // Ad: Ömer Özkan 
    // No: 200315026
    //-----------------------------------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------------------------------
    // 4+1 room = 4 adult + 1 child, 3+1 room = 3 adult + 1 child, 2+1 room = 2 adult + 1 child
    //-----------------------------------------------------------------------------------------------
    
    public static void main(String[] args) {
       
        Scanner inp = new Scanner(System.in);
        //-----------------------------------------------------------------------------------------------
        // değişkenler
        //-----------------------------------------------------------------------------------------------
        double roomCostStorage = 0;
        double roomCostStorage1 = 0;
        double roomCostStorage2 = 0;
        double roomCostStorage3 = 0;
        double roomCostStorage4 = 0;
        double roomCostStorage5 = 0;
        double roomCostStorage6 = 0;
        double roomCostStorage7 = 0;
        double roomCostStorage8 = 0;
        double roomCostStorage9 = 0;
        double roomCost = 0;
        int personNumber;
        
        String roomType = "";
        String roomTypeStorage = "";
        String roomTypeStorage1 = "";
        String roomTypeStorage2 = "";


        int roomHold4 = 0;
        int roomHold3 = 0;
        int roomHold2 = 0;

        System.out.println("Welcome to the hotel, How many guests will stay at the hotel?");
        System.out.println("Please, login a number");
        
        personNumber = inp.nextInt();
        
        System.out.printf("You have logined %d %n", personNumber);
        
        //-----------------------------------------------------------------------------------------------
        // kişi sayısı kontrolü
        //-----------------------------------------------------------------------------------------------
        if (personNumber == 1) {
            
            roomType = " a 2-person room ";
            roomCost = 200+80;
                        
        }
        else if (personNumber > 1){
            
            //-----------------------------------------------------------------------------------------------
            // Arkadaş grubumu yoksa aile  mi kontrolü
            //-----------------------------------------------------------------------------------------------
            System.out.println("Are you a family or group of friends");
            System.out.println("Please choose an option: family -- friends");
            
            String choose = inp.next();
            choose = choose.toLowerCase();
            
            //-----------------------------------------------------------------------------------------------
            // Arkadaş grubu için fiyat hesaplama
            //-----------------------------------------------------------------------------------------------
            if ("friends".equals(choose)) {
                
               // arkadaş grubu için kişi sayısının 4'e eşit veya büyük olup olmadığına göre odalara kişileri dağıtma ve fiyat hesaplama 
               if (personNumber >= 4) {
                    
               int perPerson4 = personNumber / 4;
               int remain4 = personNumber % 4;
               
               roomCostStorage = perPerson4 * 150 * 4;
               roomTypeStorage = perPerson4 + " 4-person room";
               
                   if (remain4==3) {
                     roomTypeStorage1 = "a 3-person room";
                     roomCostStorage1 = 170 * 3;
                   }
                   else if (remain4 == 2) {
                       roomTypeStorage1 = "a 2-person room";
                       roomCostStorage1 = 200 * 2;
                   }
                   else if (remain4 == 1) {
                       roomTypeStorage1 = "a 2-person room";
                       roomCostStorage1 = 200+80;
                       
                   }
  
               }
               else if (personNumber == 3) {
                    
               roomCostStorage = personNumber * 170;
               roomTypeStorage = "a 3-person room";
                    
               }
               else if (personNumber == 2) {
                   
               roomCostStorage = personNumber * 200;
               roomTypeStorage = "a 2-person room";
               
               }
               
               roomCost = roomCostStorage + roomCostStorage1;
               if ((roomTypeStorage.isEmpty()) || (roomTypeStorage1.isEmpty())) {
                    roomType = roomTypeStorage + roomTypeStorage1;
                }
               else{
                    roomType = roomTypeStorage + " and " + roomTypeStorage1;
                }
               
            }
            
            // ----------------------------------------------------------------------------------------------
            // Aile için çocuklu çocuksuz fiyat hesaplama  
            //-----------------------------------------------------------------------------------------------
            else if ("family".equals(choose)) {
                
                System.out.println("Do you have any child?");
                System.out.println("PLease login an answer \nYes or No");
                
                String answer = (inp.next()).toLowerCase();
                
                //-----------------------------------------------------------------------------------------------
                // Çocuklu fiyat hesaplama 
                //-----------------------------------------------------------------------------------------------
                if ("yes".equals(answer)) {
                    
                    System.out.println("PLease, login your number of children");
                    int numberofChildren = inp.nextInt();
                    int numberofAdult = personNumber - numberofChildren;
                    
                    
                //-----------------------------------------------------------------------------------------------
                // 4+1, 3+1, 2+1 tarzı odalara atama 
                //-----------------------------------------------------------------------------------------------
                    if (personNumber >= 4) {
                        
                        int numberofRoom4_1 = numberofAdult / 4;
                        
                        if (numberofRoom4_1 > 0) {
            
    
                            if (numberofChildren >= numberofRoom4_1) {

                                roomTypeStorage = numberofRoom4_1 + " 4+1-person room";
                                roomCostStorage = ((150*4) + (150 * 3/4)) * numberofRoom4_1;

                                numberofChildren = numberofChildren - numberofRoom4_1;
                                numberofAdult = numberofAdult - (numberofRoom4_1 * 4);
                            }
                            else if (numberofChildren < numberofRoom4_1) {

                                roomTypeStorage = numberofChildren + " 4+1-person room";
                                roomCostStorage = ((150 * 4) + (150 * 3/4)) * numberofChildren;

                                numberofAdult = numberofAdult - (numberofChildren * 4);
                                numberofChildren = 0;

                            }
                        }    
                        
                        if (((numberofAdult / 3) > 0) && (numberofChildren > 0)) {
                            
                            int numberofRoom3_1 = numberofAdult / 3;
                            
                            if (numberofChildren >= numberofRoom3_1) {
                            
                                roomTypeStorage1 = numberofRoom3_1 + " 3+1-person room";
                                roomCostStorage1 = ((170*3) + (170 * 3/4)) * numberofRoom3_1;
                            
                                numberofChildren -= numberofRoom3_1;
                                if(numberofChildren < 0) numberofChildren = 0;
                                numberofAdult = numberofAdult - (numberofRoom3_1 * 3);
                                if(numberofAdult < 0) numberofAdult = 0;
                                
                            }
                            else if (numberofChildren < numberofRoom3_1) {
                            
                                roomTypeStorage1 = numberofChildren + " 3+1-person room";
                                roomCostStorage1 = ((170 * 3) + (170 * 3/4)) * numberofChildren;
                            
                                numberofAdult = numberofAdult - numberofChildren;
                                if(numberofAdult < 0) numberofAdult = 0;
                                numberofChildren = 0;
                                
                            }  
                        }
                        
                        if (((numberofAdult / 2) > 0) && (numberofChildren > 0)) {
                            
                            int numberofRoom2_1 = numberofAdult / 2;
                            
                            if (numberofChildren >= numberofRoom2_1) {
                            
                                roomTypeStorage2 = numberofRoom2_1 + " 2+1-person room";
                                roomCostStorage2 = ((200*2) + (200 * 3/4)) * numberofRoom2_1;
                            
                                numberofChildren -= numberofRoom2_1;
                                numberofAdult = numberofAdult - (numberofRoom2_1 * 2);
                            }
                            else if (numberofChildren < numberofRoom2_1) {
                            
                                roomTypeStorage2 = numberofChildren + " 2+1-person room";
                                roomCostStorage2 = ((200 * 2) + (200 * 3/4)) * numberofChildren;
                            
                                numberofAdult = numberofAdult - numberofChildren;
                                numberofChildren = 0;
                                
                            }  
                        }
                        
                        //-----------------------------------------------------------------------------------------------
                        // Kalan çocuk ve yetişkinleri 4, 3, 2 kişilik odalara atama 
                        //-----------------------------------------------------------------------------------------------
                        int newPersonNumber = numberofAdult + numberofChildren;
                        
                        if ((numberofAdult / 4) > 0) {
                            
                            roomCostStorage6 = 150 * 4 * (numberofAdult/4);
                            //roomTypeStorage6 = (numberofAdult/4)+" 4-person room";
                            roomHold4 += (numberofAdult/4);
                            numberofAdult = numberofAdult - (4 * (numberofAdult / 4));
                            
                        }
                        if ((numberofChildren / 4) > 0) {
                            
                            roomCostStorage7 = 150 * 4 * (numberofChildren/4) * 3/4;
                            //roomTypeStorage7 = ((numberofChildren/4) + (numberofAdult/4)) + " 4-person room";
                            roomHold4 += (numberofChildren/4);
                            numberofChildren = numberofChildren - (4 * (numberofChildren / 4));
                            
                        }
                        
                        newPersonNumber = numberofAdult + numberofChildren;
                        
                        if (newPersonNumber >= 4) {
                            
                            if (numberofAdult == 3) {
                                
                                roomCostStorage8 = (150 * 3) + (150 * 3/4);
                                //roomTypeStorage8 = "a 4-person room";
                                roomHold4 += 1;
                                
                                numberofAdult -= 3;
                                numberofChildren -= 1;
                                
                                if (numberofChildren == 2) {
                                    roomCostStorage9 = 200 * 3/4 * 2;
                                    //roomTypeStorage9 = "a 2-person room";
                                    numberofChildren = 0;
                                    roomHold2 += 1;
                                }
                                else if (numberofChildren == 2) {
                                    roomCostStorage9 = 280 * 3/4;
                                    //roomTypeStorage9 = "a 2-person room";
                                    numberofChildren = 0;
                                    roomHold2 += 1;
                                }
                            }
                            else if (numberofAdult == 2) {
                                
                                roomCostStorage8 = (150 * 2) + (150 * 3/4 * 2);
                                //roomTypeStorage8 = "a 4-person room";
                                roomHold4 += 1;
                                
                                numberofAdult -= 2;
                                numberofChildren -= 2;
                                
                                if (numberofChildren == 1) {
                                    roomCostStorage9 = 280 * 3/4;
                                    //roomTypeStorage9 = "a 2-person room";
                                    numberofChildren = 0;
                                    roomHold2 += 1;
                                }
                            }
                            else if (numberofAdult == 1) {
                                
                                roomCostStorage8 = (150) + (150 * 3/4 * 3);
                                //roomTypeStorage8 = "a 4-person room";
                                roomHold4 += 1;
                                
                                numberofAdult -= 1;
                                numberofChildren -= 3;
                                
                            }
                            
                        }
                        else if (newPersonNumber == 3) {
                            roomCostStorage3 = (170 * numberofAdult) + (170 * 3/4 * numberofChildren);
                            //roomTypeStorage3 = "a 3-person room";
                            roomHold3 += 1;
                        }
                        else if (newPersonNumber == 2) {
                            roomCostStorage3 = (200 * numberofAdult) + (200 * 3/4 * numberofChildren);
                            //roomTypeStorage3 = "a 2-person room";
                            roomHold2 += 1;
                        }
                        else if (newPersonNumber == 1) {
                            
                            if(numberofChildren == 1) roomCostStorage3 = 280;
                            if(numberofAdult == 1) roomCostStorage3 = 280;
                            //roomTypeStorage3 = "a 2-person room";  
                            roomHold2 += 1;
                        }
                           
                    }                    
                    else if ((numberofChildren == 1) && (numberofAdult == 2)) {
                        
                        roomTypeStorage = "a 2+1-person room";
                        roomCostStorage = (2 * 200) + (100);
                    }
                    else if ((numberofChildren == 2) && (numberofAdult == 1)) {
                        
                        roomTypeStorage = "a 2-person room";
                        roomCostStorage = (200) + (2*100);
                        roomHold2 += 1;
                    }
                    else if ((numberofChildren == 1) && (numberofAdult == 1)) {
                        
                        roomTypeStorage = "a 2-person room";
                        roomCostStorage = 200 + 100;
                        roomHold2 += 1;
                    }
                    else if (numberofChildren == 1) {
                        
                        roomTypeStorage = "a 2-person room";
                        roomCostStorage = 280 * 3/4;
                        roomHold2 += 1;
                    }
                        
                    
                    roomCost = roomCostStorage+roomCostStorage1+roomCostStorage2+roomCostStorage3+roomCostStorage4+roomCostStorage5+roomCostStorage6+roomCostStorage7+roomCostStorage8+roomCostStorage9;
                    if(!(roomTypeStorage.isEmpty())) roomType += roomTypeStorage + " ";
                    if(!(roomTypeStorage1.isEmpty())) roomType = roomType + roomTypeStorage1 + " ";
                    if(!(roomTypeStorage2.isEmpty())) roomType = roomType + roomTypeStorage2 + " ";
                    if(roomHold4 > 0) roomType = roomType +roomHold4 + " 4-person room" + " ";
                    if(roomHold3 > 0) roomType = roomType +roomHold3 + " 3-person room" + " ";
                    if(roomHold2 > 0) roomType = roomType +roomHold2 + " 2-person room ";
                    //if(!(roomTypeStorage3.isEmpty())) roomType = roomType + roomTypeStorage3 + " ";
                    //if(!(roomTypeStorage4.isEmpty())) roomType = roomType + roomTypeStorage4 + " ";
                    //if(!(roomTypeStorage5.isEmpty())) roomType = roomType + roomTypeStorage5 + " ";

                }
                
                //-----------------------------------------------------------------------------------------------
                // çocuksuz fiyat hesaplama ve odalara dağıtma 
                //-----------------------------------------------------------------------------------------------
                else if ("no".equals(answer)) {
               
                if (personNumber >= 4) {
                    
                int perPerson4 = personNumber / 4;
                int remain4 = personNumber % 4;
                roomCostStorage = perPerson4 * 150 * 4;
                roomTypeStorage = perPerson4 + " 4-person room";

                    if (remain4==3) {
                      roomTypeStorage1 = "a 3-person room";
                      roomCostStorage1 = 170 * 3;
                    }
                    else if (remain4 == 2) {
                        roomTypeStorage1 = "a 2-person room";
                        roomCostStorage1 = 200 * 2;
                    }
                    else if (remain4 == 1) {
                        roomTypeStorage1 = "a 2-person room";
                        roomCostStorage1 = 200+80;

                    }
                    
                }
                else if (personNumber == 3) {

                roomCostStorage = personNumber * 170;
                roomTypeStorage = "a 3-person room";

                }
                else if (personNumber == 2) {

                roomCostStorage = personNumber * 200;
                roomTypeStorage = "a 2-person room";
               
               }
               
               roomCost = roomCostStorage + roomCostStorage1;
               
                if ((roomTypeStorage.isEmpty()) || (roomTypeStorage1.isEmpty())) {

                    roomType = roomTypeStorage + roomTypeStorage1;
                }
                else{
                    roomType = roomTypeStorage + " and " + roomTypeStorage1;

                }

               }
                
            }
            else{
                
                System.out.println("Please login a true value");
            }
            
        }
        
        else{
            
            System.out.println("Please login a valid number");        
        }
        
        //-----------------------------------------------------------------------------------------------
        // vip kontrolü ve indirim uygulama 
        //-----------------------------------------------------------------------------------------------
        System.out.println("Are you VIP \nPlease login an answer \nYes or No");
        
        String vipAnswer = (inp.next()).toLowerCase();
        
        if ("yes".equals(vipAnswer)) {
            
            roomCost = roomCost * 95.0/100;
        }
        
        //-----------------------------------------------------------------------------------------------
        // kaç gün kalacağı ve ona göre indirim uygulama 
        //-----------------------------------------------------------------------------------------------
        System.out.println("How many days will you stay? \nPlease login a number");
        
        int stayDay = inp.nextInt();
        
        if ((stayDay == 1) || (stayDay == 2)) {
            
            System.out.println("Do you want to stay on weekdays? \nPlease login an answer \nYes or No");
            
            String typeDayAnswer = (inp.next()).toLowerCase();
            
            if ("yes".equals(typeDayAnswer)) {
                
                roomCost = (roomCost * stayDay);
                roomCost = roomCost * 97.0/100;
                
            }
        }
        
        else if ((stayDay <= 7) && (stayDay >= 4)) {
            
            roomCost = roomCost * stayDay;
            roomCost = roomCost * 96.0/100;
            
        }
        else if (stayDay > 7) {
            
            roomCost = roomCost * stayDay;
            roomCost = roomCost * 94.0/100;
        }
        
        //-----------------------------------------------------------------------------------------------
        // rezerve edecek mi etmeyecek mi
        //-----------------------------------------------------------------------------------------------    
        
        System.out.println("Your final cost and room is here: ");
        System.out.printf("%s for %d guests for %d days, with total cost of %.2f \n", roomType, personNumber, stayDay, roomCost);
        
        System.out.println("");
        System.out.println("Do you want to book \nPlease login an answer \nYes or No");
        
        String bookAnswer = (inp.next()).toLowerCase();
        
        if ("yes".equals(bookAnswer)) {
            
            System.out.printf("You just booked %s for %d guests for %d days, with total cost of %.2f", roomType, personNumber, stayDay, roomCost);
            
        } 

    }
}
