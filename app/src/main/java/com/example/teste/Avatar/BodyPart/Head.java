package com.example.teste.Avatar.BodyPart;

import com.example.teste.Avatar.AvatarPart;
import com.example.teste.R;

import java.util.ArrayList;
import java.util.List;

public class Head extends AvatarPart
{
    /**
     * @param icon
     * @param image
     * @param name
     */
    public Head(int icon, int image, String name)
    {
        super(icon, image, name);
    }

    // Avatar method
    public static List<AvatarPart> All()
    {
        List<AvatarPart> bodyParts = new ArrayList<>();

        bodyParts.add(new Head(
            R.drawable.icone_cabeca_1,
            R.drawable.cabeca_1,
            "avatar1"
        ));

        bodyParts.add(new Head(
            R.drawable.icone_cabeca_2,
            R.drawable.cabeca_2,
            "avatar2"
        ));

        bodyParts.add(new Head(
            R.drawable.icone_cabeca_3,
            R.drawable.cabeca_3,
            "avatar3"
        ));

        return bodyParts;
    }
}
