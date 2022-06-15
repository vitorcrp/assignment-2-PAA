package Questao1.A;

import Questao1.Graph;

public class Permutation
{
    /**

     * permutation function

     * @param l starting index

     * @param r end index

     */

    public void permute(Graph graph, int l, int r)
    {

        if (l == r)
            System.out.println(graph);
        else
        {
            for (int i = l; i <= r; i++)
            {
                swap(graph,l,i);

                permute(graph, l+1, r);

                swap(graph,l,i);
            }
        }
    }


    /**

     * Swap Characters at position

     * @param i position 1

     * @param j position 2

     * @return swapped string

     */

    public String swap(Graph graph, int i, int j)

    {

        char temp;

        char[] charArray = a.toCharArray();

        temp = charArray[i] ;

        charArray[i] = charArray[j];

        charArray[j] = temp;

        return String.valueOf(charArray);

    }


    //
//    public void permute(String str, int l, int r)
//    {
//        if (l == r)
//            System.out.println(str);
//        else
//        {
//            for (int i = l; i <= r; i++)
//            {
//                str = swap(str,l,i);
//
//                permute(str, l+1, r);
//
//                str = swap(str,l,i);
//            }
//        }
//    }



//    public String swap(String a, int i, int j)
//
//    {
//
//        char temp;
//
//        char[] charArray = a.toCharArray();
//
//        temp = charArray[i] ;
//
//        charArray[i] = charArray[j];
//
//        charArray[j] = temp;
//
//        return String.valueOf(charArray);
//
//    }





}


// This code is contributed by Mihir Joshi