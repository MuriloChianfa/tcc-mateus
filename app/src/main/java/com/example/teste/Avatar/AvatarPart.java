package com.example.teste.Avatar;

/**
 * The avar part class..
 *
 * @author anyone
 * @version 0.1.0
 * @serial 0.1.0
 */
public abstract class AvatarPart
{
    /**
     * The icon of body part
     */
    private final int icon;

    /**
     * The image of body part
     */
    private final int image;

    /**
     * The name of body part
     */
    private final String name;

    /** */
    public AvatarPart(int icon, int image, String name)
    {
        this.icon = icon;
        this.image = image;
        this.name = name;
    }

    /**
     * @return Returns the icon of body part
     */
    public int getIcon()
    {
        return this.icon;
    }

    /**
     * @return Returns the image of body part
     */
    public int getImage()
    {
        return this.image;
    }
}
