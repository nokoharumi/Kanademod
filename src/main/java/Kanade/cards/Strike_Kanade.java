package Kanade.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Strike_Kanade extends AbstractAngelPlayerCards{
    public static final String ID = "Strike_Kanade";
    public static final String NAME;
    public static final CardStrings cardStrings;
    public static final int COST = 1;
    public static final String DESCRIPTION;
    public static final int ATTACK_DMG = 24;

    public Strike_Kanade(){
        super(ID, NAME, COST, DESCRIPTION, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        this.baseDamage = Strike_Kanade.ATTACK_DMG;
    }

    @Override
    public void upgrade() {
        if (!upgraded){
            this.upgradeName();
            this.upgradeDamage(12);
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Strike_Kanade();
    }

    @Override
    public void use(final AbstractPlayer player, final AbstractMonster monster) {
        AbstractDungeon.actionManager.addToTop(new DamageAction(monster, new DamageInfo(player, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Strike_Kanade");
        NAME = Strike_Kanade.cardStrings.NAME;
        DESCRIPTION = Strike_Kanade.cardStrings.DESCRIPTION;
    }
}
