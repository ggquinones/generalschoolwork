import java.util.Scanner;


public class Freezing_Boiling 
{
	final int ethylFreezing = -173;
    final int ethylBoiling = 172;
    final int waterFreezing = 32;
    final int waterBoiling = 212;
    int temperature;
    public boolean isEthylFreezing(int temperature){
        
        return temperature<-173;
             }
    
    public boolean isWaterFreezing(int temperature){
        return temperature<=32;
            }
    
    public boolean isEthylBoiling(int temperature){
        return temperature>=172;
            }
    
    public boolean isWaterBoiling(int temperature){
        return temperature>=212;
            }
    
    
    public String stateReport(int temperature){
        String waterReport;
        String ethylReport;
        String report;
        if(isEthylFreezing(temperature) == true){
            ethylReport = "Ethyl is freezing";
        }
        else{
            if(isEthylBoiling(temperature)==true){
                ethylReport = "Ethyl is boiling";
            }
            else{
                ethylReport = "Ethyl is a liquid";
            }
        }
        if(isWaterFreezing(temperature) == true){
            waterReport ="Water is freezing";
        }
        else{
            if(isWaterBoiling(temperature)==true){
                waterReport ="Water is boiling";
            }
            else{
                waterReport ="Water is a liquid";
            }
        }
            report = "For the given temperature "+temperature+"\n Farenheit\n"+ethylReport+"\n"+waterReport;
            System.out.println(report);
            return report;
    }
   }