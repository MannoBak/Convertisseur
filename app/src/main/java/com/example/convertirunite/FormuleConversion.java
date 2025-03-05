package com.example.convertirunite;

public class FormuleConversion {

    // Fonctions de conversion pour les unités

    /**
     * Pour la conversion des unités du poids
     *
     * @param kg
     * @return La valeur de kilogramme en livre
     */
    public double convertKgToLbs(double kg) {
        return kg * 2.20462;
    }

    public double convertKgToKg(double kg) {
        return kg;
    }

    public double convertGToG(double g) {
        return g;
    }

    public double convertLivreToLivre(double l) {
        return l;
    }

    // Formule de conversion de livres en kilogrammes
    public double convertLivreToKg(double livre) {
        return livre * 0.453592;
    }

    //formule pour convertir de g en kg
    public double convertGToKg(double g) {
        return g / 1000;
    }

    //Formule pour convertir de kg en g
    public double convertKgToG(double kg) {
        return kg * 1000;
    }

    //Pour convertir de livre en gramme
    public double convertLivreToG(double livre) {
        return livre * 453.592;
    }

    //Pour convertir de gramme en livre
    public double convertGToLivre(double g) {
        return g / 453.592;
    }

    /**
     * Formules de conversion pour la longueur
     */

    //Convertir mm en mm
    public double convertMmToMm(double mm) {
        return mm;
    }

    //Convertir mm en cm
    public double convertMmToCm(double mm) {
        return mm / 10;
    }

    //Convertir mm en m
    public double convertMmToM(double mm) {
        return mm / 1000;
    }

    //Convertir mm en km
    public double convertMmToKm(double mm) {
        return mm / 1000000;
    }


    //Convertir de cm en cm
    public double convertCmToCm(double cm) {
        return cm;
    }

    //Convertir de cm en cm
    public double convertCmToMm(double cm) {
        return cm * 10;
    }

    //Convertir de cm en m
    public double convertCmToM(double cm) {
        return cm / 100;
    }

    //Convertir de cm en km
    public double convertCmToKm(double cm) {
        return cm / 100000;
    }


    //Convertir de m en m
    public double convertMToM(double m) {
        return m;
    }

    //Convertir de m en mm
    public double convertMToMm(double m) {
        return m * 1000;
    }

    //Convertir de m en cm
    public double convertMToCm(double m) {
        return m * 100;
    }

    //Convertir de m en Km
    public double convertMToKm(double m) {
        return m / 1000;
    }


    //Convertir de de km en km
    public double convertKmToKm(double km) {
        return km;
    }

    //Convertir de de km en mm
    public double convertKmToMm(double km) {
        return km * 1000000;
    }

    //Convertir de km en cm
    public double convertKmToCm(double km) {
        return km * 100000;
    }

    //Convertir de km en m
    public double convertKmToM(double km) {
        return km * 1000;
    }

    /**
     * Pour la conversion du temps
     */

    /**
     * Au cas où l'utilisation garde la meme unité seconde
     */
    public double ConvertesecondToSecond(double s) {
        return s;
    }

    //De Minute en Minute
    public double ConvertMinToMin(double m) {
        return m;
    }

    //D'heure en heure
    public double ConvertHourToHour(double h) {
        return h;
    }

    public double ConvertDayToDay(double j) {
        return j;
    }


    /**
     * En cas de choix differents
     */

    //de s en min
    public double ConvertsecondToMin(double sec) {
        return sec / 60;
    }

    //De sec en heure
    public double ConvertsecondToHour(double sec) {
        return sec / 3600;
    }

    //De seconde en jour
    public double ConvertsecondToDay(double sec) {
        return sec / (60 * 60 * 24);
    }


    //de min en sec
    public double ConvertMinToSec(double min) {
        return min * 60;
    }

    //De Min en heure
    public double ConvertMinToHour(double min) {
        return min / 60;
    }

    //De minute en jour
    public double ConvertMinToDay(double min) {
        return min / (60 * 24);
    }


    //De Heure en sec
    public double ConvertHourToSec(double h) {
        return h * 3600;
    }

    //De Heure en Min
    public double ConvertHourToMin(double h) {
        return h * 60;
    }

    //D'heure en jour
    public double ConvertHourToDay(double h) {
        return h / 24;
    }

    //De jour en seconde
    public double ConvertDayToSec(double j) {
        return j * 24 * 60 * 60;
    }

    //De jour en minute
    public double ConvertDayToMin(double j) {
        return j * 24 * 60;
    }

    //De jour en heure
    public double ConvertDayToHour(double j) {
        return j * 24;
    }


    /**
     * Pour la conversion des temperatures
     */
    //Pour convertir de celsius en celsius
    public double ConvertCelsToCels(double C) {
        return C;
    }

    //De celcius en Kelvin
    public double ConvertCelsToKel(double C) {
        return C + 273.15;
    }

    //De celcius en Fahrenheit
    public double ConvertCelsToFahr(double C) {
        return C * (9 / 5) + 32;
    }


    //Pour convertir de Kelvin en Kelvin
    public double ConvertKelToKel(double K) {
        return K;
    }

    //De Kelvin en Celcius
    public double ConvertKelToCels(double K) {
        return K - 273.15;
    }

    //De kelvin en Fahrenheit
    public double ConvertKelToFahr(double K) {
        return (K - 273.15) * 9 / 5 + 32;
    }

    //Pour convertir de Fahrenheit en Fahrenheit
    public double ConvertFahrToFahr(double F) {
        return F;
    }

    //De Fahrenheit en Celcius
    public double ConvertFahrToCels(double F) {
        return (F - 32) * 5 / 9;
    }

    //De Fahrenheit en Kelvin
    public double ConvertFahrToKel(double F) {
        return (F - 32) * 5 / 9 + 273.15;
    }

    /**
     * Pour la conversion des devises
     */
    // De CFA à Euro
    public double ConvertCfaToEuro(double cfa) {
        return cfa / 650;
    }
    public double ConvertCfaToDollar(double cfa){
        return cfa/605.83;
    }

    //De euro à cfa
    public double ConvertEuroToCfa(double euro){
        return 650.0 * euro;
    }
    public double ConvertEuroToDollar(double euro){
        return euro/0.93;
    }
    // De cfa à cfa
    public double ConvertCfaToCfa(double cfa){
        return  cfa;
    }

    public double ConvertEuroToEuro(double euro){
        return euro;
    }

    public double ConvertDollarToEuro(double dollar){
        return 0.93 * dollar;
    }

    public double ConvertDollarToCfa(double dollar){
        return 605.83 * dollar;
    }
    public double ConvertDollarToDollar(double dollar){
        return dollar;
    }

}