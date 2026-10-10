package es.studium.listadoskotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersFragment : Fragment() {

    private var faction: String = FACTION_EMPIRE

    companion object {
        private const val ARG_FACTION = "arg_faction"
        const val FACTION_EMPIRE = "empire"
        const val FACTION_REBELS = "rebels"

        fun newInstance(faction: String): CharactersFragment {
            val fragment = CharactersFragment()
            val args = Bundle().apply {
                putString(ARG_FACTION, faction)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            faction = it.getString(ARG_FACTION, FACTION_EMPIRE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewCharacters)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val characters = if (faction == FACTION_EMPIRE) {
            getEmpireCharacters()
        } else {
            getRebelCharacters()
        }

        recyclerView.adapter = CharacterAdapter(characters)
    }

    private fun getEmpireCharacters(): List<CharacterModel> {
        return listOf(
            CharacterModel(
                "Darth Vader",
                "El Señor Oscuro del Sith y mano derecha del Emperador. Su imponente presencia y dominio del lado oscuro infunden terror en toda la galaxia. Su armadura negra y su característica respiración son legendarias.",
                R.drawable.vader
            ),
            CharacterModel(
                "Emperador Palpatine",
                "El astuto gobernante del Imperio Galáctico. Bajo la fachada de canciller benevolente, manipuló las Guerras Clon para destruir la República y establecer un régimen tiránico basado en el poder de los Sith.",
                R.drawable.palpatine
            ),
            CharacterModel(
                "Stormtrooper",
                "Soldado de asalto imperial. Equipados con armadura blanca estandarizada, forman la columna vertebral del ejército del Imperio, ejecutando las órdenes de sus superiores sin cuestionarlas.",
                R.drawable.stormtrooper
            ),
            CharacterModel(
                "Boba Fett",
                "El cazarrecompensas más temido de la galaxia. Contratado frecuentemente por el Imperio y el bajo mundo, su destreza en combate y su armadura mandaloriana lo hacen letal en cualquier misión.",
                R.drawable.bobba
            ),
            CharacterModel(
                "Gran Moff Tarkin",
                "Gobernador regional y artífice de la doctrina del terror. Tarkin supervisó la construcción y el uso de la Estrella de la Muerte, demostrando la absoluta crueldad del Imperio contra sus detractores.",
                R.drawable.moff
            ),
            CharacterModel(
                "Piloto TIE",
                "Soldado de élite especializado en pilotar los rápidos cazas TIE del Imperio. Su valentía fanática y lealtad inquebrantable garantizan la superioridad aérea imperial en los combates espaciales.",
                R.drawable.tie
            )
        )
    }

    private fun getRebelCharacters(): List<CharacterModel> {
        return listOf(
            CharacterModel(
                "Luke Skywalker",
                "Un joven granjero de Tatooine que descubrió su destino como caballero Jedi. Destruyó la primera Estrella de la Muerte y fue clave en la redención de su padre, trayendo equilibrio a la Fuerza.",
                R.drawable.luke
            ),
            CharacterModel(
                "Princesa Leia Organa",
                "Líder valiente y decidida de la Alianza Rebelde. Diplomática consumada y estratega militar, Leia luchó incansablemente contra la tiranía imperial con astucia y un coraje inquebrantable.",
                R.drawable.leia
            ),
            CharacterModel(
                "Han Solo",
                "Contrabandista cínico reconvertido en héroe de la Rebelión. Al mando del Halcón Milenario junto a Chewbacca, aportó audacia, lealtad y un toque de sarcasmo a la causa rebelde.",
                R.drawable.han
            ),
            CharacterModel(
                "Chewbacca",
                "Fiel guerrero wookiee y copiloto del Halcón Milenario. Conocido por su fuerza descomunal, su lealtad eterna hacia Han Solo y su valentía en cada batalla contra las fuerzas imperiales.",
                R.drawable.chewacca
            ),
            CharacterModel(
                "Yoda",
                "Maestro Jedi legendario con siglos de sabiduría. Aunque exiliado en Dagobah, entrenó a Luke Skywalker en los caminos de la Fuerza, transmitiendo la esperanza de que los Jedi volverían a surgir.",
                R.drawable.yoda
            ),
            CharacterModel(
                "R2-D2",
                "Astromecánico astuto y leal. A lo largo de la galaxia, R2-D2 ha salvado innumerables vidas, reparado naves en pleno vuelo y almacenado información vital para la supervivencia de la Rebelión.",
                R.drawable.r2d2
            )
        )
    }
}
