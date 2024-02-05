import java.util.HashMap;

public class DNDStuf {

    public final String[] strSkills = {"Athletics","Svaing Throw"};
    public final String[] dexSkills = {"Acrobatics","Sleight of Hand","Stealth","Svaing Throw"};
    public final String conSkills = "Svaing Throw";
    public final String[] inlSkills = {"Arcana","History","Investigation","Nature","Religion","Svaing Throw"};
    public final String[] wisSkills = {"Animal Handling","Insight","Medicine","Perception","Survival","Svaing Throw"};
    public final String[] chaSkills = {"Deception","Intimidation","Performance","Persuasion","Svaing Throw"};

    public final String[] classes = {"Artificer","Barbarian","Bard","Cleric","Druid","Fighter","Monk","Paladin","Ranger","Rogue","Sorcerer","Warlock","Wizard"};
    public static HashMap<String, String[]> subClassesDic = new HashMap<String, String[]>(); 
    public static final String[][] subClasses = {{"Alchemist","Armorer","Artillerist","Battle Smith"},
    {"Path of the Ancestral Guardian","Path of the Battlerager","Path of the Beast","Path of the Berserker","Path of the Giant","Path of the Storm Herald","Path of the Totem Warrior","Path of Wild Magic","Path of the Zealot",},
    {"College of Creatio","College of Eloquence","College of Glamour","College of Lore","College of Spirits","College of Swords","College of Valor","College of Whispers"},
    {"Arcana Domain","Death Domain","Forge Domain","Grave Domain","Knowledge Domain","Life Domain","Light Domain","Nature Domain","Order Domain","Peace Domain","Tempest Domain","Trickery Domain","Twilight Domain","War Domain"},
    {"Circle of Dreams","Circle of the Land","Circle of the Moon","Circle of the Shepherd","Circle of Spores","Circle of Stars","Circle of Wildfire"},
    {"Arcane Archer","Battle Master","Cavalier","Champion","Eldritch Knight","Psi Warrior","Purple Dragon Knight (Banneret)","Rune Knight","Samurai"},
    {"Way of the Ascendant Dragon","Way of the Astral Self","Way of the Drunken Master","Way of the Four Elements","Way of the Kensei","Way of the Long Death","Way of Mercy","Way of the Open Hand","Way of Shadow","Way of the Sun Soul"},
    {"Oath of the Ancients","Oath of Conquest","Oath of the Crown","Oath of Devotion","Oath of Glory","Oathbreaker","Oath of Redemption","Oath of Vengeance","Oath of the Watchers"},
    {"Beast Master","Drakewarden","Fey Wanderer","Gloom Stalker","Horizon Walker","Hunter","Monster Slayer","Swarmkeeper"},
    {"Arcane Trickster","Assassin","Inquisitive","Mastermind","Phantom","Scout","Soulknife","Swashbuckler","Thief"},
    {"Aberrant Mind","Clockwork Soul","Divine Soul","Draconic Bloodline","Lunar Sorcery","Shadow Magic","Storm Sorcery","Wild Magic"},
    {"The Archfey","The Celestial","The Fathomless","The Fiend","The Genie","The Great Old One","The Hexblade","The Undead","The Undying"},
    {"School of Abjuration","Bladesinging","School of Conjuration","School of Divination","School of Enchantment","School of Evocation","School of Illusion","School of Necromancy","Order of Scribes","School of Transmutation","War Magic"}};
    
    DNDStuf(){
        for (int i = 0;i < subClasses.length; i++) {
            subClassesDic.put(classes[i], subClasses[i]);
        }
    }

}

