package RangerCaptain.actions;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ExtractAction extends AbstractGameAction {
    private final boolean random;
    private final Consumer<AbstractCard> onExtract;
    private final AbstractGameAction followAction;
    private static final float DURATION = Settings.ACTION_DUR_XFAST;
    private static final ArrayList<AbstractCard> extractedCards = new ArrayList<>();

    public ExtractAction(int amount) {
        this(amount, false, card -> {});
    }

    public ExtractAction(int amount, boolean random) {
        this(amount, random, card -> {});
    }

    public ExtractAction(int amount, boolean random, Consumer<AbstractCard> onExtract) {
        this(amount, random, onExtract, null);
    }

    public ExtractAction(int amount, boolean random, AbstractGameAction followAction) {
        this(amount, random, card -> {}, followAction);
    }

    public ExtractAction(int amount, boolean random, Consumer<AbstractCard> onExtract, AbstractGameAction followAction) {
        this.random = random;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = DURATION;
        this.amount = amount;
        this.onExtract = onExtract;
        this.followAction = followAction;
    }

    @Override
    public void update() {
        extractedCards.clear();
        amount = Math.min(amount, AbstractDungeon.player.discardPile.size());
        if (amount > 0) {
            if (random) {
                for (int i = 0; i < amount; i++) {
                    extract(AbstractDungeon.player.discardPile.getRandomCard(true));
                }
            } else {
                for (int i = 0 ; i < amount ; i++) {
                    extract(AbstractDungeon.player.discardPile.getTopCard());
                }
            }
        }
        if (followAction != null) {
            this.addToTop(followAction);
        }
        this.isDone = true;
    }

    private void extract(AbstractCard c) {
        if (AbstractDungeon.player.hand.size() < BaseMod.MAX_HAND_SIZE) {
            extractedCards.add(c);
            onExtract.accept(c);
            AbstractDungeon.player.hand.addToHand(c);
            AbstractDungeon.player.discardPile.removeCard(c);
            c.lighten(false);
            c.applyPowers();
        }
    }
}