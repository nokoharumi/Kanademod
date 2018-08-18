package Kanade.characters;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.util.ArrayList;

import Kanade.patches.CharacterEnum;
import basemod.abstracts.CustomPlayer;

public class TachibanaKanade extends CustomPlayer{
    public static final int ENERGY_PER_TURN = 3;
    public static final String[] orbTextures;
    public static final String orbVfx;

    public TachibanaKanade(final String name, final AbstractPlayer.PlayerClass setClass){
        super(name, setClass, TachibanaKanade.orbTextures, TachibanaKanade.orbVfx, (String)null, "images/characters/skeleton.json");
        this.dialogX = this.drawX + 0.0f * Settings.scale;
        this.dialogY = this.drawY + 240.0f * Settings.scale;
        this.initializeClass(
                "images/character/main.png",
                "images/character/shoulder2.png",
                "images/character/shoulder.png",
                "images/character/corpse/main.png",
                getLoadout(), 20.0f, -10.0f, 220.0f, 290.0f, new EnergyManager(ENERGY_PER_TURN)
        );
    }

    public static ArrayList<String> getStartingDeck(){
        final ArrayList<String> retVal = new ArrayList<String>();
        retVal.add("Strike_Kanade");
        retVal.add("Strike_Kanade");
        retVal.add("Strike_Kanade");
        retVal.add("Defend_Kanade");
        retVal.add("Defend_Kanade");
        retVal.add("Defend_Kanade");
        retVal.add("AttackSkill");
        retVal.add("GuardSkill");
        retVal.add("HandSonicVer1");
        return retVal;
    }

    public static ArrayList<String> getStartingRelics(){
        final ArrayList<String> retVal = new ArrayList<String>();
        retVal.add("AngelPlayer");
        UnlockTracker.markRelicAsSeen("AngelPlayer");
        return retVal;
    }

    public static CharSelectInfo getLoadout(){
        return new CharSelectInfo("立华奏", "Description..", 65, 65, 0, 99, 4, CharacterEnum.TachibanaKanade, getStartingRelics(), getStartingDeck(), false);
    }

    static {
        orbTextures = new String[] {
                "images/ui/topPanel/Kanade/layer1.png",
                "images/ui/topPanel/Kanade/layer2.png",
                "images/ui/topPanel/Kanade/layer3.png",
                "images/ui/topPanel/Kanade/layer4.png",
                "images/ui/topPanel/Kanade/layer5.png",
                "images/ui/topPanel/Kanade/layer6.png",
                "images/ui/topPanel/Kanade/layer1d.png",
                "images/ui/topPanel/Kanade/layer2d.png",
                "images/ui/topPanel/Kanade/layer3d.png",
                "images/ui/topPanel/Kanade/layer4d.png",
                "images/ui/topPanel/Kanade/layer4d.png"
        };
        orbVfx = "images/ui/topPanel/energyKanadeVFX.png";
    }
}
