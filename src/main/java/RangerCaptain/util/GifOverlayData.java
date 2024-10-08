package RangerCaptain.util;

import RangerCaptain.MainModfile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

import static RangerCaptain.util.MonsterEnum.*;

public class GifOverlayData {
    public static final HashMap<MonsterEnum, Animation<TextureRegion>> OVERLAY_DATA = new HashMap<>();

    private static void add(MonsterEnum monster, String fileName) {
        OVERLAY_DATA.put(monster, loadGifOverlay(fileName));
    }

    private static Animation<TextureRegion> loadGifOverlay(String fileName) {
        return GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal(MainModfile.makeImagePath("anims/"+fileName)).read());
    }

    static {
        add(ADEPTILE, "Adeptile_idle.gif");
        add(AEROBOROS, "Aeroboros_idle.gif");
        add(ALLSEER, "Allseer_idle.gif");
        add(AMPHARE, "Amphare_idle.gif");
        add(ANATHEMA, "Anathema_idle.gif");
        add(APOCROWLYPSE, "Apocrowlypse_idle.gif");
        add(ARKIDD, "Arkidd_idle.gif");
        add(ARTILLEREX, "Artillerex_idle.gif");
        add(AURICLAW, "Auriclaw_idle.gif");
        add(AVEREVOIR, "Averevoir_stance_idle.gif");
        add(BANSHEEP, "Bansheep_idle.gif");
        add(BEANSTALKER, "Beanstalker_idle.gif");
        add(BINTERLOPER, "Binterloper_idle.gif");
        add(BINVADER, "Binvader_idle.gif");
        add(BLOSSOMAW, "Blossomaw_idle.gif");
        add(BLUNDERBUSK, "Blunderbusk_idle.gif");
        add(BOLTAM, "Boltam_idle.gif");
        add(BRAXSUIT, "Braxsuit_idle.gif");
        add(BRUSHROOM, "Brushroom_idle.gif");
        add(BULLETINO, "Bulletino_idle.gif");
        add(BURNACE, "Burnace_idle.gif");
        add(BUSHEYE, "Busheye_idle.gif");
        add(CANDEVIL, "Candevil_idle.gif");
        add(CAPRICORPSE, "Capricorpse_idle.gif");
        add(CARNIVIPER, "Carniviper_idle.gif");
        add(CATFIVE, "Cat-5_idle.gif");
        add(CHARLEQUIN, "Charlequin_idle.gif");
        add(CLOCKSLEY, "Clocksley_idle.gif");
        add(CLUCKABILLY, "Cluckabilly_idle.gif");
        add(COALDRON, "Coaldron_idle.gif");
        add(CRYOSHEAR, "Cryoshear_idle.gif");
        add(DANDYLION, "Dandylion_idle.gif");
        add(DECIBELLE, "Decibelle_idle.gif");
        add(DIVEAL, "Diveal_idle.gif");
        add(DIVEBERG, "Diveberg_idle.gif");
        add(DJINN_ENTONIC, "Djinn_Entonic_idle.gif");
        add(DOMINOTH, "Dominoth_idle.gif");
        add(DRACULEAF, "Draculeaf_idle.gif");
        add(ELFLESS, "Elfless_idle.gif");
        add(FAERIOUS, "Faerious_idle.gif");
        add(FAUCETEAR, "Faucetear_idle.gif");
        add(FERRICLAW, "Ferriclaw_idle.gif");
        add(FLAPWOODS, "Flapwoods_idle.gif");
        add(FOLKLORD, "Folklord_idle.gif");
        add(FORTIWINX, "Fortiwinx_idle.gif");
        add(FOUNTESS, "Fountess_idle.gif");
        add(FRAGLIACCI, "Fragliacci_idle.gif");
        add(FRILLYPAD, "Frillypad_idle.gif");
        add(FUNGOGH, "Fungogh_idle.gif");
        add(GALAGOR, "Galagor_idle.gif");
        add(GEARYU, "Gearyu_idle.gif");
        add(GLAISTAIN, "Glaistain_idle.gif");
        add(GRAMPUS, "Grampus_idle.gif");
        add(GUMBAAL, "Gumbaal_idle.gif");
        add(HAUNTOME, "Hauntome_idle.gif");
        add(HEDGEHERNE, "Hedgeherne_idle.gif");
        add(HOPSKIN, "Hopskin_idle.gif");
        add(HUNTORCH, "Huntorch_idle.gif");
        add(ICEPECK, "Icepeck_idle.gif");
        add(JELLYTON, "Jellyton_idle.gif");
        add(JORMUNGOLD, "Jormungold_idle.gif");
        add(JUMPKIN, "Jumpkin_idle.gif");
        add(KHEPRI, "Khepri_idle.gif");
        add(KHUFO, "Khufo_idle.gif");
        add(KINGRAVE, "Kingrave_idle.gif");
        add(KIRIKURI, "Kirikuri_idle.gif");
        add(KITTELLY, "Kittelly_idle.gif");
        add(KUNEKO, "Kuneko_idle.gif");
        add(LAPACITOR, "Lapacitor_idle.gif");
        add(LILIGATOR, "Liligator_idle.gif");
        add(LITTLERED, "Littlered_idle.gif");
        add(LOBSTACLE, "Lobstacle_idle.gif");
        add(MACABRA, "Macabra_idle.gif");
        add(MAGIKRAB, "Magikrab_idle.gif");
        add(MAJORTOM, "Majortom_idle.gif");
        add(MALCHEMY, "Malchemy_idle.gif");
        add(MANISPEAR, "Manispear_idle.gif");
        add(MARDIUSA, "Mardiusa_idle.gif");
        add(MASCOTORN, "Mascotorn_idle.gif");
        add(MASCOTOY, "Mascotoy_idle.gif");
        add(MASQUERATTLE, "Masquerattle_idle.gif");
        add(MIASMODEUS, "Miasmodeus_idle.gif");
        add(MINORTOM, "Minortom_idle.gif");
        add(MISS_MIMIC, "Miss_Mimic_idle.gif");
        add(MOTHMANIC, "Mothmanic_idle.gif");
        add(MUSKRATEER, "Muskrateer_idle.gif");
        add(NEVERMORT, "Nevermort_idle.gif");
        add(PADPOLE, "Padpole_idle.gif");
        add(PALANGOLIN, "Palangolin_idle.gif");
        add(PAWNDEAD, "Pawndead_idle.gif");
        add(PICKSIE, "Picksie_idle.gif");
        add(PINBOLT, "Pinbolt_idle.gif");
        add(PLASMANTLER, "Plasmantler_idle.gif");
        add(POMBOMB, "Pombomb_idle.gif");
        add(PONDWALKER, "Pondwalker_idle.gif");
        add(PUPPERCUT, "Puppercut_idle.gif");
        add(PYROMELEON, "Pyromeleon_idle.gif");
        add(QUEENYX, "Queenyx_idle.gif");
        add(RAMTASM, "Ramtasm_idle.gif");
        add(RATCOUSEL, "Ratcousel_idle.gif");
        add(REGENSEA, "Regensea_idle.gif");
        add(RIPTERRA, "Ripterra_idle.gif");
        add(ROBINDAM, "Robindam_idle.gif");
        add(ROCKERTRICE, "Rockertrice_idle.gif");
        add(ROSEHOOD, "Rosehood_idle.gif");
        add(SALAMAGUS, "Salamagus_idle.gif");
        add(SANZATIME, "Sanzatime_idle.gif");
        add(SCAMPIRE, "Scampire_idle.gif");
        add(SCARLETEETH, "Scarleteeth_idle.gif");
        add(SCUBALRUS, "Scubalrus_idle.gif");
        add(SHARKTANKER, "Sharktanker_idle.gif");
        add(SHINING_KUNEKO, "Shining_Kuneko_idle.gif");
        add(SIRENADE, "Sirenade_idle.gif");
        add(SKELEVANGELIST, "Skelevangelist_idle.gif");
        add(SMOGMAGOG, "Smogmagog_idle.gif");
        add(SNOOPIN, "Snoopin_idle.gif");
        add(SOUTHPAW, "Southpaw_idle.gif");
        add(SPARKTAN, "Sparktan_idle.gif");
        add(SPIROUETTE, "Spirouette_idle.gif");
        add(SPITZFYRE, "Spitzfyre_idle.gif");
        add(SPOOKIONNA, "Spooki-onna_idle.gif");
        add(SPRINGHEEL, "Springheel_idle.gif");
        add(SQUIREY, "Squirey_idle.gif");
        add(STARDIGRADE, "Stardigrade_idle.gif");
        add(TERRACOOKA, "Terracooka_idle.gif");
        add(THWACKALOPE, "Thwackalope_idle.gif");
        add(TOKUSECT, "Tokusect_idle.gif");
        add(TRAFFIKRAB, "Traffikrab_idle.gif");
        add(TRAPWURM, "Trapwurm_idle.gif");
        add(TRIPHINX, "Triphinx_idle.gif");
        add(TWIRLIGIG, "Twirligig_idle.gif");
        add(UMBRAHELLA, "Umbrahella_idle.gif");
        add(UNDYIN, "Undyin_idle.gif");
        add(VELOCIRIFLE, "Velocirifle_idle.gif");
        add(VENDEMON, "Vendemon_idle.gif");
        add(WEEVILITE, "Weevilite_idle.gif");
        add(WINGLOOM, "Wingloom_idle.gif");
        add(WOOLTERGEIST, "Wooltergeist_idle.gif");
        add(WYRMAW, "Wyrmaw_idle.gif");
        add(ZEUSTRIKE, "Zeustrike_idle.gif");
        add(ZOMBLEAT, "Zombleat_idle.gif");
    }
}
