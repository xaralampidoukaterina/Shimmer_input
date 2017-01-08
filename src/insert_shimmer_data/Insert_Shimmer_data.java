/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insert_shimmer_data;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author katerina
 * 
 * csv file 
 * #year, month, data, hours, mins, seconds, packet id, sensor id,
 * acc x (raw), acc x (cal), acc y (raw), acc y (cal), acc z (raw), acc z (cal), 
 * gyro x(raw), gyro x (cal), gyro y (raw), gyro y (cal), gyro z (raw), gyro z (cal),
 * mag x (raw), mag x (cal), mag y (raw), mag y (cal), mag z (raw), mag z (cal)
 */
public class Insert_Shimmer_data {

    /**
     * @param args the command line arguments
     */
    
    private static final String USERNAME= "root";
    private static final String PASSWORD= "";
    private static final String CONN_STRING= "jdbc:mysql://localhost:3306/database";


    public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException {
        // TODO code application logic here
        Connection conn =null;
         //read from the file
        String  filename ="bsn_alldata.csv";
        File file = new File(filename);
        try{
            int i=10;
            conn = (Connection)DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            try (Scanner inputStream = new Scanner(file)) {
                while(inputStream.hasNext()){
                    String data =inputStream.next(); //gets a whole line
                    String[] values =data.split(",");
                    /*timestamp*/
                    Integer year = Integer.parseInt(values[0]);
                    Integer month = Integer.parseInt(values[1]);
                    Integer day = Integer.parseInt(values[2]);
                    Integer hours = Integer.parseInt(values[3]);
                    Integer minutes = Integer.parseInt(values[4]);
                    Integer seconds = Integer.parseInt(values[5]);
                    String str = ""+year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds+"";
                    Timestamp timest = Timestamp.valueOf(str);
                    /*mobile device*/
                    String mobile_device = "android_1";
                    /*sensor_id*/
                    Integer sens_id = Integer.parseInt(values[7]);
                    Integer sensor_id = sens_id;
                    /*acc x-y-z*/
                    Float a_x_r = Float.parseFloat(values[8]);
                    Float a_x_c = Float.parseFloat(values[9]);
                    Float a_y_r = Float.parseFloat(values[10]);
                    Float a_y_c = Float.parseFloat(values[11]);
                    Float a_z_r = Float.parseFloat(values[12]);
                    Float a_z_c = Float.parseFloat(values[13]);
                    /*gyro x-y-z*/
                    Float g_x_r = Float.parseFloat(values[14]);
                    Float g_x_c = Float.parseFloat(values[15]);
                    Float g_y_r = Float.parseFloat(values[16]);
                    Float g_y_c = Float.parseFloat(values[17]);
                    Float g_z_r = Float.parseFloat(values[18]);
                    Float g_z_c = Float.parseFloat(values[19]);
                    /*mag x-y-z*/
                    Float m_x_r = Float.parseFloat(values[20]);
                    Float m_x_c = Float.parseFloat(values[21]);
                    Float m_y_r = Float.parseFloat(values[22]);
                    Float m_y_c = Float.parseFloat(values[23]);
                    Float m_z_r = Float.parseFloat(values[24]);
                    Float m_z_c = Float.parseFloat(values[25]);
                    /*packet id*/
                    Integer packet_id = Integer.parseInt(values[6]);
                    /*channel_id*/
                    String acc_x= "acc_x";
                    String acc_y = "acc_y";
                    String acc_z= "acc_z";
                    String gyro_x = "gyro_x";
                    String gyro_y = "gyro_y";
                    String gyro_z = "gyro_z";
                    String mag_x = "mag_x";
                    String mag_y = "mag_y";
                    String mag_z= "mag_z";
                    /*battery level*/
                    Integer battery_level = Integer.parseInt(values[26]);
                    /*Sql for acc_x*/
                    PreparedStatement post0 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+acc_x+"','"+a_x_r+"','"+a_x_c+"','"+packet_id+"','"+battery_level+"')");
                    post0.executeUpdate();
                    /*Sql for acc_y*/
                    PreparedStatement post1 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+acc_y+"','"+a_y_r+"','"+a_y_c+"','"+packet_id+"','"+battery_level+"')");
                    post1.executeUpdate();
                    /*Sql for acc_z*/
                    PreparedStatement post2 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+acc_z+"','"+a_z_r+"','"+a_z_c+"','"+packet_id+"','"+battery_level+"')");
                    post2.executeUpdate();
                    /*Sql for gyro_x*/
                    PreparedStatement post3 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+gyro_x+"','"+g_x_r+"','"+g_x_c+"','"+packet_id+"','"+battery_level+"')");
                    post3.executeUpdate();
                    /*Sql for gyro_y*/
                    PreparedStatement post4 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+gyro_y+"','"+g_y_r+"','"+g_y_c+"','"+packet_id+"','"+battery_level+"')");
                    post4.executeUpdate();
                    /*Sql for gyro_z*/
                    PreparedStatement post5 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+gyro_z+"','"+g_z_r+"','"+g_z_c+"','"+packet_id+"','"+battery_level+"')");
                    post5.executeUpdate();
                    /*Sql for mag_x*/
                    PreparedStatement post6 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+mag_x+"','"+m_x_r+"','"+m_x_c+"','"+packet_id+"','"+battery_level+"')");
                    post6.executeUpdate();
                    /*Sql for mag_y*/
                    PreparedStatement post7 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+mag_y+"','"+m_y_r+"','"+m_y_c+"','"+packet_id+"','"+battery_level+"')");
                    post7.executeUpdate();
                    /*Sql for mag_z*/
                    PreparedStatement post8 = conn.prepareStatement("INSERT INTO measurements(times,mobile_device,node_id,channel_id,value_row,value_cal,packet_id,battery_level)VALUES('"+timest+"','"+mobile_device+"','"+sensor_id+"','"+mag_z+"','"+m_z_r+"','"+m_z_c+"','"+packet_id+"','"+battery_level+"')");
                    post8.executeUpdate();
                    
                    //  System.out.println(values[26]);
                }
                System.out.println("Connected");
            }
           
        }catch(SQLException e){
            System.err.println(e);
        }
        
    }
    
}
