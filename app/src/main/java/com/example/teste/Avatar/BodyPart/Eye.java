package com.example.teste.Avatar.BodyPart;

import com.example.teste.Avatar.AvatarPart;
import com.example.teste.R;

import java.util.ArrayList;
import java.util.List;

public class Eye extends AvatarPart
{
    /**
     * @param icon
     * @param image
     * @param name
     */
    public Eye(int icon, int image, String name)
    {
        super(icon, image, name);
    }

    public static List<AvatarPart> All ()
    {
        List<AvatarPart> eyeParts = new ArrayList<>(  );

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_1_marrom,
            R.drawable.olhos_1_marrom,
            "olho1"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_2,
            R.drawable.olhos_2,
            "olho2"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_3_marrom,
            R.drawable.olhos_3_marrom,
            "olho3"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_4_marrom,
            R.drawable.olhos_4_marrom,
            "olho4"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_5_marrom,
            R.drawable.olhos_5_marrom,
            "olho5"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_6_marrom,
            R.drawable.olhos_6_marrom,
            "olho6"
        ));

        return eyeParts;
    }

    public static List<AvatarPart> Type1 () {
        List<AvatarPart> eyeParts = new ArrayList<>(  );

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_1_marrom,
            R.drawable.olhos_1_marrom,
            "olho1"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_1_azul,
            R.drawable.olhos_1_azul,
            "olho2"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_1_verde,
            R.drawable.olhos_1_verde,
            "olho3"
        ));

        return eyeParts;
    }

    public static List<AvatarPart> Type2 ()
    {
        List<AvatarPart> eyeParts = new ArrayList<>();

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_3_marrom,
            R.drawable.olhos_3_marrom,
            "olho1"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_3_azul,
            R.drawable.olhos_3_azul,
            "olho2"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_3_verde,
            R.drawable.olhos_3_verde,
            "olho3"
        ));

        return eyeParts;
    }

    public static List<AvatarPart> Type3 ()
    {
        List<AvatarPart> eyeParts = new ArrayList<>();

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_4_marrom,
            R.drawable.olhos_4_marrom,
            "olho1"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_4_azul,
            R.drawable.olhos_4_azul,
            "olho2"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_4_verde,
            R.drawable.olhos_4_verde,
            "olho3"
        ));

        return eyeParts;
    }

    public static List<AvatarPart> Type4 ()
    {
        List<AvatarPart> eyeParts = new ArrayList<>();

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_5_marrom,
            R.drawable.olhos_5_marrom,
            "olho1"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_5_azul,
            R.drawable.olhos_5_azul,
            "olho2"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_5_verde,
            R.drawable.olhos_5_verde,
            "olho3"
        ));

        return eyeParts;
    }

    public static List<AvatarPart> Type5 ()
    {
        List<AvatarPart> eyeParts = new ArrayList<>();

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_6_marrom,
            R.drawable.olhos_6_marrom,
            "olho1"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_6_azul,
            R.drawable.olhos_6_azul,
            "olho2"
        ));

        eyeParts.add(new Eye(
            R.drawable.icone_olhos_6_verde,
            R.drawable.olhos_6_verde,
            "olho3"
        ));

        return eyeParts;
    }
}
