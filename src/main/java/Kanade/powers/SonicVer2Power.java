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

public class SonicVer2Power extends AbstractPower{
    public static final String POWER_ID = "SonicVer2Power";
    public static final String NAME = "音速手刃Ver2";
    public static final String DESCRIPTION = "造成伤害和得到格挡";
    public AbstractCreature target;
//    public int damage;
//    public int block;

    public SonicVer2Power(final AbstractCreature owner, final AbstractCreature target, final int amount){
        this.name = HandSonicVer2.NAME;
        this.ID = "SonicVer2Power";
        this.owner = owner;
        this.target = target;
        this.amount = amount;
//        this.block = amount+1;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/power/" + POWER_ID + ".png");
        this.type = AbstractPower.PowerType.BUFF;
    }

    public void atEndOfRound(){
        AbstractDungeon.actionManager.addToBottom(new DamageAction(target, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this.owner, this.owner, this.amount));
    }
}
