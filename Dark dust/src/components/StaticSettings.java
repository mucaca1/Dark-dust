/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author Matej
 */
public class StaticSettings {
    public static String getPathToPhotos(){
        return "src\\Imges\\BoardGameCards";
    }
    public static String getPathToPlayerPhotos(){
        return "src\\Imges\\Characters";
    }
    
    public static boolean isVisiableAllCards(){
        return false;
    }
}
