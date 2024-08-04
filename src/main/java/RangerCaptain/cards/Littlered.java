package RangerCaptain.cards;

import RangerCaptain.cards.abstracts.AbstractMultiUpgradeCard;
import RangerCaptain.powers.BerserkerPower;
import RangerCaptain.util.CardArtRoller;
import RangerCaptain.util.MonsterData;
import RangerCaptain.util.Wiz;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static RangerCaptain.MainModfile.makeID;

public class Littlered extends AbstractMultiUpgradeCard {
    public final static String ID = makeID(Littlered.class.getSimpleName());

    public Littlered() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
        setMonsterData(MonsterData.LITTLERED);
        baseInfo = info = 0;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.applyToSelf(new BerserkerPower(p, magicNumber));
    }

    @Override
    public String cardArtCopy() {
        return Miracle.ID;
    }

    @Override
    public CardArtRoller.ReskinInfo reskinInfo(String ID) {
        return new CardArtRoller.ReskinInfo(ID, darken(RED), WHITE, darken(RED), WHITE, false);
    }

    @Override
    public void addUpgrades() {
        addUpgradeData(this::upgrade0);
        addUpgradeData(this::upgrade1);
        setExclusions(0, 1);
    }

    public void upgrade0() {
        upgradeMagicNumber(1);
        name = originalName = cardStrings.EXTENDED_DESCRIPTION[0];
        initializeTitle();
        setMonsterData(MonsterData.SCARLETEETH);
        baseInfo = info = 1;
    }

    public void upgrade1() {
        upgradeBaseCost(1);
        name = originalName = cardStrings.EXTENDED_DESCRIPTION[1];
        initializeTitle();
        setMonsterData(MonsterData.ROSEHOOD);
        info = baseInfo = 2;
        isInnate = true;
    }
}