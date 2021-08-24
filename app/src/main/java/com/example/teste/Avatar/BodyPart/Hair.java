package com.example.teste.Avatar.BodyPart;

import com.example.teste.Avatar.AvatarPart;
import com.example.teste.R;

import java.util.ArrayList;
import java.util.List;

public class Hair extends AvatarPart
{
    /**
     * @param icon
     * @param image
     * @param name
     */
    public Hair(int icon, int image, String name)
    {
        super(icon, image, name);
    }

    //Métodos dos cabelos Principais
    public static List<AvatarPart> All ()
    {
        List<AvatarPart> hairParts = new ArrayList<>();

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_1_marrom,
            R.drawable.cabelo_1_marrom,
            "cabelo1"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_2_marrom,
            R.drawable.cabelo_2_marrom,
            "cabelo2"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_3_marrom,
            R.drawable.cabelo_3_marrom,
            "cabelo3"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_4_marrom,
            R.drawable.cabelo_4_marrom,
            "cabelo4"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_5_marrom,
            R.drawable.cabelo_5_marrom,
            "cabelo5"
        ));

        return hairParts;
    }

    //Métodos dos cabelos 1
    public static List<AvatarPart> Type1 ()
    {
        List<AvatarPart> hairParts = new ArrayList<>();

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_1_marrom,
            R.drawable.cabelo_1_marrom,
            "cabelo1"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_1_amarelo,
            R.drawable.cabelo_1_amarelo,
            "cabelo2"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_1_laranja,
            R.drawable.cabelo_1_laranja,
            "cabelo3"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_1_preto,
            R.drawable.cabelo_1_preto,
            "cabelo4"
        ));

        return hairParts;
    }

    //Métodos dos cabelos 2
    public static List<AvatarPart> Type2 ()
    {
        List<AvatarPart> hairParts = new ArrayList<>();

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_2_marrom,
            R.drawable.cabelo_2_marrom,
            "cabelo1"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_2_amarelo,
            R.drawable.cabelo_2_amarelo,
            "cabelo2"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_2_laranja,
            R.drawable.cabelo_2_laranja,
            "cabelo3"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_2_preto,
            R.drawable.cabelo_2_preto,
            "cabelo4"
        ));

        return hairParts;
    }

    //Métodos dos cabelos 3
    public static List<AvatarPart> Type3 ()
    {
        List<AvatarPart> hairParts = new ArrayList<>();

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_3_marrom,
            R.drawable.cabelo_3_marrom,
            "cabelo1"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_3_amarelo,
            R.drawable.cabelo_3_amarelo,
            "cabelo2"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_3_laranja,
            R.drawable.cabelo_3_laranja,
            "cabelo3"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_3_preto,
            R.drawable.cabelo_3_preto,
            "cabelo4"
        ));

        return hairParts;
    }

    //Métodos dos cabelos 4
    public static List<AvatarPart> Type4 ()
    {
        List<AvatarPart> hairParts = new ArrayList<>();

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_4_marrom,
            R.drawable.cabelo_4_marrom,
            "cabelo1"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_4_amarelo,
            R.drawable.cabelo_4_amarelo,
            "cabelo2"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_4_laranja,
            R.drawable.cabelo_4_laranja,
            "cabelo3"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_4_preto,
            R.drawable.cabelo_4_preto,
            "cabelo4"
        ));

        return hairParts;
    }

    //Métodos dos cabelos 5
    public static List<AvatarPart> Type5 ()
    {
        List<AvatarPart> hairParts = new ArrayList<>();

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_5_marrom,
            R.drawable.cabelo_5_marrom,
            "cabelo1"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_5_amarelo,
            R.drawable.cabelo_5_amarelo,
            "cabelo2"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_5_laranja,
            R.drawable.cabelo_5_laranja,
            "cabelo3"
        ));

        hairParts.add(new Hair(
            R.drawable.icone_cabelo_5_preto,
            R.drawable.cabelo_5_preto,
            "cabelo4"
        ));

        return hairParts;
    }
}
