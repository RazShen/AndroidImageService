package com.imageservice.anservice;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Client {

    /**
     *  constructor for the client.
     */
    public Client() {
    }

    /**
     * This method sends a single picture to the tcp server.
     * @param pic image to transfer
     * @throws Exception
     */
    public void connectToServerAndSend(File pic) throws Exception {
        try {
            //here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName("10.0.2.2");
            //create a socket to make the connection with the server
            Socket socket = new Socket(serverAddr, 2500);
            try {

                OutputStream output = socket.getOutputStream();
                InputStream input = socket.getInputStream();
                byte[] proveReadImage = new byte[1];
                // write the image to the server
                output.write(pic.toPath().getFileName().toString().getBytes());
                int i = input.read(proveReadImage);
                sleep(500);
                if (i == 1) {
                    output.write(extractBytes(pic));
                }
                output.flush();
            } catch (Exception e) {
                Log.e("TCP", "S: Error", e);
            } finally {
                socket.close();
            }
        } catch (Exception e) {
            Log.e("TCP", "C: Error", e);
        }

    }

    /**
     * This method transforms the picture into bytes.
     * @param file picture to transform
     * @return array of bits of the picture
     * @throws IOException
     */
    private static byte[] extractBytes(File file) throws IOException {
        // open image
        System.out.println(file.exists() + "!!");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum);
                //no doubt here is 0
                /*Writes len bytes from the specified byte array starting at offset
                off to this byte array output stream.*/
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            // Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bos.toByteArray();
    }

}
