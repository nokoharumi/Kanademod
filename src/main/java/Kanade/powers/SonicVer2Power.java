package Kanade.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import Kanade.cards.AngelPlayer.HandSonicVer2;

public class SonicVer2Power extends AbstractSonicPower{
    public static final String POWER_ID = "SonicVer2Power";
    public static final String NAME = "音速手刃Ver2";
    public static final String DESCRIPTION = "造成伤害和得到格挡";
    public static int damage;
    public static int block;

    public SonicVer2Power(final AbstractCreature owner, final AbstractCreature target, final int damage, final int block){
        super(owner, target);
        this.name = SonicVer2Power.NAME;
        this.ID = SonicVer2Power.POWER_ID;
        this.damage = damage;
        this.block = block;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/power/" + SonicVer2Power.POWER_ID + ".png");
        this.type = AbstractPower.PowerType.BUFF;
    }

    public void atEndOfRound(){
        AbstractDungeon.actionManager.addToBottom(new DamageAction(target, new DamageInfo(this.owner, this.damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this.owner, this.owner, this.block));
        this.flash();
    }

    public void updateDescription(){
        this.description = SonicVer2Power.DESCRIPTION;
    }
}
