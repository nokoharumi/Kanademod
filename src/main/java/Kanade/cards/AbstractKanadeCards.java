package Kanade.cards;

import com.megacrit.cardcrawl.cards.AbstractCard;

import Kanade.patches.AbstractCardEnum;
import basemod.abstracts.CustomCard;
import Kanade.Kanade;

import static Kanade.Kanade.kanadeCardImage;

public abstract class AbstractKanadeCards extends CustomCard{
    public AbstractKanadeCards(final String id, final String name, final int cost, final String description, final AbstractCard.CardType type, final AbstractCard.CardRarity rarity, final AbstractCard.CardTarget target) {
        super(id, name, Kanade.kanadeCardImage(id), cost, description, type, AbstractCardEnum.Kanade, rarity, target);
    }
}
