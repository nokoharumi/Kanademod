package Kanade.cards.AngelPlayer;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;

import Kanade.cards.AbstractAngelPlayerCards;

public class GuardSkill extends AbstractAngelPlayerCards{
    public static final String ID = "GuardSkill";
    public static final String NAME;
    public static final CardStrings cardStrings;
    public static final int COST = 0;
    public static final String DESCRIPTION;

    public GuardSkill(){
        super(ID, NAME, COST, DESCRIPTION, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void upgrade() {
        if (!upgraded){
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new GuardSkill();
    }

    @Override
    public void use(final AbstractPlayer player, final AbstractMonster monster) {
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(player, player, new DexterityPower(player, this.magicNumber), this.magicNumber));
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(player, player, new LoseDexterityPower(player, this.magicNumber), this.magicNumber));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("GuardSkill");
        NAME = GuardSkill.cardStrings.NAME;
        DESCRIPTION = GuardSkill.cardStrings.DESCRIPTION;
    }
}
