package Kanade.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend_Kanade extends AbstractAngelPlayerCards{
    public static final String ID = "Defend_Kanade";
    public static final String NAME;
    public static final CardStrings cardStrings;
    public static final int COST = 1;
    public static final String DESCRIPTION;
    public static final int DEFEND_DMG = 12;

    public Defend_Kanade(){
        super(ID, NAME, COST, DESCRIPTION, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        this.baseBlock = Defend_Kanade.DEFEND_DMG;
    }

    @Override
    public void upgrade() {
        if (!upgraded){
            this.upgradeName();
            this.upgradeBlock(12);
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Defend_Kanade();
    }

    @Override
    public void use(final AbstractPlayer player, final AbstractMonster monster) {
        AbstractDungeon.actionManager.addToTop(new GainBlockAction(player, player,this.block));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Defend_Kanade");
        NAME = Defend_Kanade.cardStrings.NAME;
        DESCRIPTION = Defend_Kanade.cardStrings.DESCRIPTION;
    }
}
