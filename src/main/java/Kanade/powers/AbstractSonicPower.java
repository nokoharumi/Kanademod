package Kanade.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.regex.Pattern;

import basemod.DevConsole;

public abstract class AbstractSonicPower extends AbstractPower {

    public AbstractCreature target;

    public AbstractSonicPower(final AbstractCreature owner, final AbstractCreature target) {
        this.owner = owner;
        this.target = target;
        this.amount = -1;
    }

    @Override
    public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if(source == this.owner && Pattern.compile("^SonicVer[1-5]Power$").matcher(power.ID).find() && !power.ID.equals(this.ID)) { // target == this.target
            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
        }
    }

    @Override
    public void stackPower(final int stackAmount) {
        // do nothing
    }
}
