/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package throwingexceptions;

/**
 *
 * @author Zara Veda
 */
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils
{
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n)
    {   
        int fac = 1;
        
        if(n < 0) {
            throw new IllegalArgumentException("n must be positive");
        } else {
            if(n > 16) {
                throw new IllegalArgumentException("n must be under 16");
            } else {
                for (int i=n; i>0; i--)
                fac *= i;
            }
        }
        
        return fac;
    }
}
