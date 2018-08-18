package Kanade.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.helpers.ImageMaster;

import basemod.abstracts.CustomRelic;
import Kanade.Kanade;

public abstract class AbstractKanadeRelic extends CustomRelic{
    public AbstractKanadeRelic(final String id, final RelicTier tier, final LandingSound landingSound){
        super(id, ImageMaster.loadImage(Kanade.kanadeRelicImage(id)), ImageMaster.loadImage(Kanade.kanadeRelicOutlineImage(id)), tier, landingSound);
    }
}
