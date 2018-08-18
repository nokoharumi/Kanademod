package Kanade.relics;

import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

public class AngelPlayer extends AbstractKanadeRelic {
    public static final String ID = "AngelPlayer";
    public static final int ENERGY_AMT = 1;


    public AngelPlayer() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT);
    }

    @Override
    public void onUseCard(final AbstractCard targetCard, final UseCardAction useCardAction) {
//        final AbstractPlayer p = AbstractDungeon.player;
//        if (EnergyPanel.totalCount - targetCard.cost + AngelPlayer.ENERGY_AMT <= p.energy.energy)
//            AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(AngelPlayer.ENERGY_AMT));
    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + AngelPlayer.ENERGY_AMT + this.DESCRIPTIONS[1];
    }

    @Override
    public AbstractRelic makeCopy() {
        return new AngelPlayer();
    }
}