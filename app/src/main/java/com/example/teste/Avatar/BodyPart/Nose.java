package com.example.teste.Avatar.BodyPart;

import com.example.teste.Avatar.AvatarPart;
import com.example.teste.R;

import java.util.ArrayList;
import java.util.List;

public class Nose extends AvatarPart
{
    /**
     * @param icon
     * @param image
     * @param name
     */
    public Nose(int icon, int image, String name)
    {
        super(icon, image, name);
    }

    // Nose methods
    public static List<AvatarPart> All ()
    {
        List<AvatarPart> noseParts = new ArrayList<>();

        noseParts.add(new Nose(
            R.drawable.icone_nariz_1,
            R.drawable.nariz_1,
            "nariz1"
        ));

        noseParts.add(new Nose(
            R.drawable.icone_nariz_2,
            R.drawable.nariz_2,
            "nariz2"
        ));

        noseParts.add(new Nose(
            R.drawable.icone_nariz_3,
            R.drawable.nariz_3,
            "nariz3"
        ));

        return noseParts;
    }
}
