package com.example.extra2.Models;

import java.io.Serializable;

public class Operaciones implements Serializable {

    private String operacion;
    private Integer num1;
    private Integer num2;
    private Integer resultado;
    private String img;

    public Operaciones(String img, String operacion) {
        this.img = img;
        this.operacion = operacion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum2() {
        return num2;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int operaciones(String operador, Integer num1, Integer num2) {
        this.operacion = operador;
        this.num1 = num1;
        this.num2 = num2;

        switch (operador) {
            case "+":
                Sumar(num1, num2);
                break;
            case "-":
                Restar(num1, num2);
                break;
            case "*":
                Multiplicar(num1, num2);
                break;
            case "/":
                Dividir(num1, num2);
                break;
            default:
                return 0;
        }
        return resultado;
    }

    public void Sumar(int num1, int num2) {
        this.resultado = num1 + num2;
    }

    public void Restar(int num1, int num2) {
        this.resultado = num1 - num2;
    }

    public void Multiplicar(int num1, int num2) {
        this.resultado = num1 * num2;
    }

    public void Dividir(int num1, int num2) {
        this.resultado = num1 / num2;
    }
}