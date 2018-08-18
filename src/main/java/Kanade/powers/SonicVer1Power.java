package Kanade.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import Kanade.cards.AngelPlayer.HandSonicVer1;

public class SonicVer1Power extends AbstractPower{
    public static final String POWER_ID = "SonicVer1Power";
//    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = "音速手刃Ver1";
    public static String DESCRIPTION = "造成伤害和得到格挡";
//    public AbstractPlayer player;
    public AbstractCreature target;
    public int damage;
    public int block;

    public SonicVer1Power(final AbstractCreature owner, final AbstractCreature target, final int amount, final int damage, final int block){
//        this.player = AbstractDungeon.player;
        this.name = HandSonicVer1.NAME;
        this.ID = "SonicVer1Power";
        this.owner = owner;
        this.target = target;
        this.amount = amount;
        this.damage = damage;
        this.block = block;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/power/" + POWER_ID + ".png");
        this.type = AbstractPower.PowerType.BUFF;
    }

//    public void onPlayCard(final AbstractCard card, final AbstractMonster monster){
//        AbstractDungeon.actionManager.addToBottom(new DamageAction(monster, new DamageInfo(player, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
//        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(player, player, this.amount));
//    }

//    public void atStartOfTurn(){
//        AbstractDungeon.actionManager.addToBottom(new DamageAction(target, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
//        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this.owner, this.owner, this.block));
//    }

//    @Override
//    public void onEnergyRecharge(){
//        this.flash();
//        AbstractDungeon.player.gainEnergy(1);
//        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, "SonicVer1Power"));
//    }

    public void atEndOfRound(){
        AbstractDungeon.actionManager.addToBottom(new DamageAction(target, new DamageInfo(this.owner, this.damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this.owner, this.owner, this.block));
        this.flash();
        if (this.amount == 1){
            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, "SonicVer1Power"));
        }else {
            --this.amount;
        }
    }

//    @Override
//    public void atEndOfTurn(final boolean isPlayer){
//        if (isPlayer){
//            if (this.amount > 0){
//               for (int i = 0; i < this.amount; ++i){
//                   AbstractDungeon.actionManager.addToBottom(new DamageAction(target, new DamageInfo(this.owner, this.damage, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
//                   AbstractDungeon.actionManager.addToBottom(new GainBlockAction(this.owner, this.owner, this.block));
//               }
//               this.flash();
//               --this.amount;
//            }else {
//                AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, "SonicVer1Power"));
//            }
//        }
//    }

//    public void updateDescription(){
//        if (this.amount == 1){
//            this.description = HandSonicVer1.DESCRIPTION;
//        }else {
//            this.description = HandSonicVer1.UPGRADE_DESCRIPTION;
//        }
//    }

//    static {
//        powerStrings = CardCrawlGame.languagePack.getPowerStrings("SonicVer1Power");
//        NAME = SonicVer1Power.powerStrings.NAME;
//        DESCRIPTION = SonicVer1Power.powerStrings.DESCRIPTIONS;
//    }
}
