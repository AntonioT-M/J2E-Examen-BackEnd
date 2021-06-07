/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author atmim
 */
public class Client {
    @Id
    public ObjectId Client_ID;
    
    public String Nombre_Usuario;
    public String Contraseña;
    public String Nombre;
    public String Apellidos;
    public String Correo_Electronico;
    public String Edad;
    public double Estatura;
    public double Peso;
    public double IMC;
    public double GEB;
    public double ETA;
    public String Fecha_Creacion;
    public String Fecha_Actualizacion;
    
    public Client(){}

    public Client(ObjectId Client_ID, String Nombre_Usuario, String Contraseña, 
            String Nombre, String Apellidos, String Correo_Electronico, 
            String Edad, double Estatura, double Peso, double IMC, double GEB, 
            double ETA, String Fecha_Creacion, String Fecha_Actualizacion) {
        this.Client_ID = Client_ID;
        this.Nombre_Usuario = Nombre_Usuario;
        this.Contraseña = Contraseña;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Correo_Electronico = Correo_Electronico;
        this.Edad = Edad;
        this.Estatura = Estatura;
        this.Peso = Peso;
        this.IMC = IMC;
        this.GEB = GEB;
        this.ETA = ETA;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Actualizacion = Fecha_Actualizacion;
    }
    
    public String get_ID(){
        return Client_ID.toHexString();
    }
    
    public void set_ID(ObjectId Client_ID){
        this.Client_ID = Client_ID;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public String getCorreo_Electronico() {
        return Correo_Electronico;
    }

    public String getEdad() {
        return Edad;
    }

    public double getEstatura() {
        return Estatura;
    }

    public double getPeso() {
        return Peso;
    }

    public double getIMC() {
        return IMC;
    }

    public double getGEB() {
        return GEB;
    }

    public double getETA() {
        return ETA;
    }

    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public String getFecha_Actualizacion() {
        return Fecha_Actualizacion;
    }

    public void setNombre_Usuario(String Nombre_Usuario) {
        this.Nombre_Usuario = Nombre_Usuario;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setCorreo_Electronico(String Correo_Electronico) {
        this.Correo_Electronico = Correo_Electronico;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    public void setEstatura(double Estatura) {
        this.Estatura = Estatura;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public void setGEB(double GEB) {
        this.GEB = GEB;
    }

    public void setETA(double ETA) {
        this.ETA = ETA;
    }

    public void setFecha_Creacion(String Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public void setFecha_Actualizacion(String Fecha_Actualizacion) {
        this.Fecha_Actualizacion = Fecha_Actualizacion;
    }
}
