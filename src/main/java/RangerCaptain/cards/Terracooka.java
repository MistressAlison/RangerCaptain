package RangerCaptain.cards;

import RangerCaptain.cards.abstracts.AbstractEasyCard;
import RangerCaptain.patches.CustomTags;
import RangerCaptain.powers.BurnedPower;
import RangerCaptain.util.CardArtRoller;
import RangerCaptain.util.MonsterEnum;
import RangerCaptain.util.Wiz;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static RangerCaptain.MainModfile.makeID;

public class Terracooka extends AbstractEasyCard {
    public final static String ID = makeID(Terracooka.class.getSimpleName());

    public Terracooka() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = 5;
        setMonsterData(MonsterEnum.TERRACOOKA);
        tags.add(CustomTags.MAGIC_BURN);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.applyToEnemy(m, new BurnedPower(m, p, magicNumber));
        addToBot(new ExhaustAction(1, false, false, false));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
        name = originalName = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeTitle();
        setMonsterData(MonsterEnum.COALDRON);
    }

    @Override
    public String cardArtCopy() {
        return Miracle.ID;
    }

    @Override
    public CardArtRoller.ReskinInfo reskinInfo(String ID) {
        return new CardArtRoller.ReskinInfo(ID, darken(BRONZE), WHITE, darken(BRONZE), WHITE, false);
    }
}