package Kanade.cards.AngelPlayer;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import Kanade.cards.AbstractAngelPlayerCards;
import Kanade.powers.SonicVer1Power;

@SpireInitializer
public class HandSonicVer1 extends AbstractAngelPlayerCards{

    public static final String ID = "HandSonicVer1";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
//    public static final String UPGRADE_DESCRIPTION;
    public static final int COST = 2;
    /**public static final String IMG = "";**/

    public HandSonicVer1() {
        super(ID, HandSonicVer1.NAME, COST, HandSonicVer1.DESCRIPTION, CardType.SKILL, CardRarity.RARE, CardTarget.ENEMY);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
//        this.baseDamage = 2;
//        this.baseBlock = 2;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
//            this.upgradeDamage(2);
//            this.upgradeBlock(1);
//            this.rawDescription = UPGRADE_DESCRIPTION;
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new HandSonicVer1();
    }

    @Override
    public void use(final AbstractPlayer player, final AbstractMonster monster) {
        AbstractDungeon.actionManager.addToBottom(new DamageAction(monster, new DamageInfo(player, 3, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(player, player, 3));
        AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(1));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(player, player, new SonicVer1Power(player, monster, this.magicNumber, 3, 3), this.magicNumber));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("HandSonicVer1");
        NAME = HandSonicVer1.cardStrings.NAME;
        DESCRIPTION = HandSonicVer1.cardStrings.DESCRIPTION;
//        UPGRADE_DESCRIPTION = HandSonicVer1.cardStrings.UPGRADE_DESCRIPTION;
    }
}
