package com.example.teste.Avatar.BodyPart;

import com.example.teste.Avatar.AvatarPart;
import com.example.teste.R;

import java.util.ArrayList;
import java.util.List;

public class Mouth extends AvatarPart
{
    /**
     * @param icon
     * @param image
     * @param name
     */
    public Mouth(int icon, int image, String name)
    {
        super(icon, image, name);
    }

    // Mouth methods
    public static List<AvatarPart> All()
    {
        List<AvatarPart> mouthParts = new ArrayList<>();

        mouthParts.add(new Mouth(
            R.drawable.icone_boca_1,
            R.drawable.boca_1,
            "boca1"
        ));

        mouthParts.add(new Mouth(
            R.drawable.icone_boca_2,
            R.drawable.boca_2,
            "boca2"
        ));

        mouthParts.add(new Mouth(
            R.drawable.icone_boca_3,
            R.drawable.boca_3,
            "boca3"
        ));

        mouthParts.add(new Mouth(
            R.drawable.icone_boca_4,
            R.drawable.boca_4,
            "boca4"
        ));

        mouthParts.add(new Mouth(
            R.drawable.icone_boca_5,
            R.drawable.boca_5,
            "boca5"
        ));

        mouthParts.add(new Mouth(
            R.drawable.icone_boca_6,
            R.drawable.boca_6,
            "boca6"
        ));

        return mouthParts;
    }
}
