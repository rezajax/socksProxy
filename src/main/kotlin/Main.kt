package com.example

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
    val serverSocket = ServerSocket(1122)
    println("Server listening on port ${serverSocket.localPort}")

    while (true) {
        val clientSocket = serverSocket.accept()
        println("Client connected with port: ${clientSocket.port}")


        clientSocket.use {
            val input = clientSocket.getInputStream()
            val output = clientSocket.getOutputStream()


            try {
                val reader = BufferedReader(InputStreamReader(input))
                val writer = PrintWriter(OutputStreamWriter(output), true)
                val buffer = ByteArray(1024)
                var bytesRead: Int


                while (input.read(buffer).also { bytesRead = it } != -1) {
                    // Convert the bytes to hexadecimal representation
                    val hexData = buffer.copyOf(bytesRead).joinToString(" ") { "%02x".format(it) }
                    println("Received (${bytesRead} bytes): $hexData.")
                    println("Received (${bytesRead} bytes): ${buffer.copyOf(bytesRead).joinToString("") { it.toString() }}")

                }
                writer.println("Hello from Kotlin!")


                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    println("Received from client: $line")
                    // Echo the data back to the client (or implement SOCKS5 protocol logic here)
                    writer.println("Server received: $line")
                }

            } catch (e: IOException) {
                println("Error: ${e.message}")
            }
            println("Client disconnected: ${clientSocket.remoteSocketAddress}")
        }
    }


}