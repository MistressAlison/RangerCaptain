package RangerCaptain.cardmods.fusion;

import RangerCaptain.MainModfile;
import RangerCaptain.cardmods.fusion.abstracts.AbstractFusionMod;
import RangerCaptain.cards.Braxsuit;
import RangerCaptain.powers.SuitUpPower;
import RangerCaptain.util.FormatHelper;
import RangerCaptain.util.Wiz;
import basemod.abstracts.AbstractCardModifier;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;

public class BraxsuitMod extends AbstractFusionMod {
    public static final String ID = MainModfile.makeID(BraxsuitMod.class.getSimpleName());
    public static final String[] DESCRIPTION_TEXT = CardCrawlGame.languagePack.getUIString(ID).TEXT;
    public static final String[] CARD_TEXT = CardCrawlGame.languagePack.getUIString(ID).EXTRA_TEXT;
    public static final int AMOUNT = 1;


    public BraxsuitMod() {
        super(ID);
    }

    @Override
    public void onInitialApplication(AbstractCard card) {
        if (card instanceof Braxsuit) {
            card.baseMagicNumber += AMOUNT;
            card.magicNumber += AMOUNT;
        }
    }

    @Override
    public String getModDescription(AbstractCard card) {
        return DESCRIPTION_TEXT[0];
    }

    public String modifyDescription(String rawDescription, AbstractCard card) {
        if (!(card instanceof Braxsuit)) {
            rawDescription = FormatHelper.insertAfterText(rawDescription, CARD_TEXT[0]);
        }
        return rawDescription;
    }

    @Override
    public void onUse(AbstractCard card, AbstractCreature target, UseCardAction action) {
        if (!(card instanceof Braxsuit)) {
            Wiz.applyToSelf(new SuitUpPower(Wiz.adp(), AMOUNT));
        }
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new BraxsuitMod();
    }
}
